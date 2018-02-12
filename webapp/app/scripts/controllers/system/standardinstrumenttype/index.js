'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:SystemStandardinstrumenttypeIndexCtrl
 * @description 标准器类别
 * # SystemStandardinstrumenttypeIndexCtrl
 * Controller of the webappApp
 */
angular.module('webappApp')
    .controller('SystemStandardinstrumenttypeIndexCtrl', function ($stateParams, $scope, CommonService, standardDeviceInstrumentType) {
        var self = this;

        self.init = function () {
            standardDeviceInstrumentType.initController(self, $scope, $stateParams);
            $scope.params = self.initScopeParams();
            self.load();
        };

        self.init();
    });
