'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:LoginCtrl
 * @description
 * # LoginCtrl
 * Controller of the webappApp
 */
angular.module('webappApp')
  .controller('LoginCtrl', ['$scope', '$location', 'UserServer', 'config', function ($scope, $location, UserServer, config) {
    var self = this;
    // 初始化用户
    self.login = function (user) {
      UserServer.login(user, function (status) {
        if (status === 401) {
          self.setMessage('对不起', '您的用户名或密码输入有误或用' +
            '户状态不正常，请重新输入。');
          $scope.form.$submitted = false;
        } else if (status === 200) {
          // 登录成功，先清空缓存，然后跳转.自动跳转
          // todo 菜单初始化
          //WebAppMenuService.init();
          $location.path(config.mainPath);
        } else {
          self.setMessage('对不起', '系统发生未知错误，请稍后重试，或联系您的管理员。');
          $scope.form.$submitted = false;
        }
      });
    };

    // 统一暴露
    $scope.login = self.login;
  }]);
