var app = angular.module('app', [
//    'ngSrc'
]);


app.controller('MainController', function($scope) {
    $scope.keepRefreshing = false;

    $scope.onSaveScreenshot = function () {
        $scope.saveScreenshot = 'rest/screenshot/save?' + new Date().getTime();
        $scope.$apply();

        if ($scope.keepRefreshing) {
            setTimeout($scope.onSaveScreenshot, 1000);
        }
    };
});

