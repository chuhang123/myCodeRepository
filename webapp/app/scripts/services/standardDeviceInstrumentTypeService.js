'use strict';

/**
 * @ngdoc service
 * @name webappApp.InstrumentTypeService
 * @description 标准器类别
 * # InstrumentTypeService
 * Service in the webappApp.
 */
angular.module('webappApp')
    .service('standardDeviceInstrumentType', function ($http, CommonService) {
        var self = this;

        self.initController = function (controller, scope, stateParams) {
            CommonService.initControllerPage(controller, scope);

            controller.initScopeParams = function () {
                return {
                    discipline: stateParams.discipline,
                    page: stateParams.page,
                    size: stateParams.size
                };
            };

            controller.load = controller.reload = function () {
                console.log(scope.params)
                self.pageByDisciplineId(scope.params.discipline.id, controller.generateQueryParams(), function (data) {
                        scope.data = data;
                    }
                );
            };
        };

        self.pageByDisciplineId = function (disciplineId, params, callback) {
            var url = '/StandardDeviceInstrumentType/pageByDisciplineId/' + disciplineId;
            $http.get(url, params)
                .then(function success(response) {
                    callback(response.data);
                }, function error(response) {
                    CommonService.httpError(response);
                });
        };

        return {
            initController: self.initController,
            pageByDisciplineId: self.pageByDisciplineId
        };
    });
