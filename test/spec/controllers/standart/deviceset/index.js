'use strict';

describe('Controller: StandartDevicesetIndexCtrl', function () {

  // load the controller's module
  beforeEach(module('myCodeRepositoryApp'));

  var StandartDevicesetIndexCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    StandartDevicesetIndexCtrl = $controller('StandartDevicesetIndexCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(StandartDevicesetIndexCtrl.awesomeThings.length).toBe(3);
  });
});
