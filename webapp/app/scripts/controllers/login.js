'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:LoginCtrl
 * @description
 * # LoginCtrl
 * Controller of the webappApp
 */
angular.module('webappApp')
  .controller('LoginCtrl', ['$scope', '$location', 'UserService', 'config', 'SweetAlert', 'CommonService', 'WebAppMenuService', function ($scope, $location, UserService, config, SweetAlert, CommonService, WebAppMenuService) {
    var self = this;
    UserService.init();
    //var test = ['fsdf', 2, '343', {name: 'test'}, 0];
    //  todo 写博客
    // Array.prototype.Filted = function() {
    //   var res = [];
    //   for (var i = 0; i < this.length; i++) {
    //     if (this[i] !== 0) {
    //       res.push(this[i]);
    //     }
    //   }
    //   return res;
    // };
    // for (var o in test) {
    //   if (test.hasOwnProperty(o)) {
    //     console.log(o);
    //   }
    // }
    // console.log('test');
    // for (var m = 0; m < test.length; m++) {
    //   console.log(test[m]);
    // }
    // 初始化用户
    self.login = function (user) {
      UserService.login(user, function (status) {
        if (status === 401) {
          CommonService.setMessage('对不起', '您的用户名或密码输入有误或用' +
            '户状态不正常，请重新输入。');
          $scope.form.$submitted = false;
        } else if (status === 200) {
          // 登录成功，先清空缓存，然后跳转.自动跳转
          // todo 菜单初始化
          WebAppMenuService.init();
          $location.path(config.mainPath);
        } else {
          CommonService.setMessage('对不起', '系统发生未知错误，请稍后重试，或联系您的管理员。');
          $scope.form.$submitted = false;
        }
      });
    };


    // 统一暴露
    $scope.login = self.login;
    $scope.user = {username: '', password: ''};
  }]);
