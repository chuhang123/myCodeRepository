'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:PersonalCtrl
 * @description
 * # PersonalCtrl
 * Controller of the webappApp
 */
angular.module('webappApp')
    .controller('PersonalCtrl', function ($scope, $state, UserService, CommonService, SweetAlert) {
        var self = this;

        self.init = function () {
            // 手机号正则表达式
            $scope.regex = '^1[34578]\\d{9}$';
            // 原密码
            $scope.password = '';
            // 重置密码
            $scope.resetPassword = '';
            // 确认密码
            $scope.confirmPassword = '';

            UserService.getCurrentLoginUser(function (user) {
                $scope.data = user;
            });
        };

        self.submit = function () {
            self.userPasswordAndName = {
                name: $scope.data.name,
                password: $scope.password,
                rePassword: $scope.confirmPassword
            };
            // 更新用户姓名和密码
            UserService.updatePasswordAndNameOfCurrentUser(self.userPasswordAndName, function (status) {

                if (204 === status) {
                    // 更新成功
                    // 传入空回调函数，因为如果用户直接访问的个人中心，则报错
                    CommonService.success('操作成功', '', function () {});
                } else if (205 === status) {
                    // 原密码错误
                    self.setMessage('对不起', '您的原密码输入有误，请重新输入');
                } else {
                    self.setMessage('对不起', '系统或网络异常，请稍后再试');
                }


                // 重新加载该页面
                $state.go($state.current, '', {reload: true});
            });
        };

        // 调用sweetAlert进行原密码错误的提示
        self.setMessage = function(title, message) {
            SweetAlert.swal({
                title: title,
                text: message
            });
        };


        self.init();
        $scope.submit = self.submit;
    });
