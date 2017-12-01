'use strict';

/**
 * @ngdoc service
 * @name webappApp.UserServer
 * @description
 * # UserServer
 * Service in the webappApp.
 */
angular.module('webappApp')
  .service('UserServer', function ($cookies, $http) {
    var self = this;
    var cacheKey = 'userId';

    self.init = function () {
      self.currentLoginUser = {};
      $cookies.remove(cacheKey);
    };

    // 设置当登录用户
    self.setCurrentLoginUser = function (user) {
      self.currentLoginUser = user;
      $cookies.put(cacheKey, user.id);
    };

    // 获取当前的登录用户
    self.getCurrentLoginUser = function (callback) {
      if (self.currentLoginUser && !angular.equals(self.currentLoginUser, {})) {
        callback(self.currentLoginUser);
      } else if ($cookies.get(cacheKey)) {
        $http.get('/User/' + $cookies.get('userId'))
          .then(function success(response) {
            if (response.status === 200) {
              self.setCurrentLoginUser(response.data);
              callback(response.data);
            } else {
              callback({});
            }
          }, function error() {
            callback({});
          });
      } else {
        callback({});
      }
    };

    // todo login


    // 判断当前用户是否登录
    self.checkUserIsLogin = function (callback) {
      self.getCurrentLoginUser(function (user) {
        if (!angular.equals(user, {})) {
          callback(true);
        } else {
          callback(false);
        }
      });
    };
  });
