'use strict';

describe('Controller: StandartDevicesetAddCtrl', function () {

  // load the controller's module
  beforeEach(module('myCodeRepositoryApp'));

  var StandartDevicesetAddCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    StandartDevicesetAddCtrl = $controller('StandartDevicesetAddCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(StandartDevicesetAddCtrl.awesomeThings.length).toBe(3);
  });
});
