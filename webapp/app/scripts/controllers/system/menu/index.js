'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:SystemMenuIndexCtrl
 * @description
 * # SystemMenuIndexCtrl
 * Controller of the webappApp
 */
angular.module('webappApp')
  .controller('SystemMenuIndexCtrl', function ($scope, WebAppMenuService) {
    var self = this;

    Array.prototype.Filted = function() {
      var res = [];
      for (var i = 0; i < this.length; i++) {
        if (this[i] !== 0) {
          res.push(this[i]);
        }
      }
      return res;
    };

    var test = ['fsdf', 2, 0];

    for (var o in test) {
      console.log(test[o]);
    }

    for (var m = 0; m < test.length; m++) {
      console.log(test[m]);
    }

    // 定义显示方法
    var showData = function () {
      // 获取后台数据
      WebAppMenuService.getMenuTree(function (data) {
        $scope.datas = [];
        angular.forEach(data, function(value) {
          $scope.datas.push(value);
          if (value._children) {
            angular.forEach(value._children, function(v){
              $scope.datas.push(v);
            });
          }
        });
      });
    };

    // 执行获取数据
    showData();

    // 统一暴露
    $scope.getFullName = WebAppMenuService.getFullName;
    $scope.getRoute = WebAppMenuService.getRouteFromMenu;
    $scope.getUrl = WebAppMenuService.getFullUrl;
  });
