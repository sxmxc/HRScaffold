Application.$controller("EmployeeDetailsPageController", ["$scope", function($scope) {
    "use strict";

    /* perform any action with the variables inside this block(on-page-load) */
    $scope.onPageVariablesReady = function() {
        /*
         * variables can be accessed through '$scope.Variables' property here
         * e.g. $scope.Variables.staticVariable1.getData()
         */




        //$scope.Variables.HrdbSearch_Submit_Result.update(); calling the variable

    };

    /* perform any action with widgets inside this block */
    $scope.onPageReady = function() {
        /*
         * widgets can be accessed through '$scope.Widgets' property here
         * e.g. $scope.Widgets.byId(), $scope.Widgets.byName()or access widgets by $scope.Widgets.widgetName
         */


    };


    $scope.search2Submit = function($event, $isolateScope) {

        $scope.Variables.SelectedEmployeeList.update();
    };

}]);