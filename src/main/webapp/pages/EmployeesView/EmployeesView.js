Application.$controller("EmployeesViewPageController", ["$scope", function($scope) {
    "use strict";

    /* perform any action with the variables inside this block(on-page-load) */
    $scope.onPageVariablesReady = function() {
        /*
         * variables can be accessed through '$scope.Variables' property here
         * e.g. $scope.Variables.staticVariable1.getData()
         */

    };

    /* perform any action with widgets inside this block */
    $scope.onPageReady = function() {
        /*
         * widgets can be accessed through '$scope.Widgets' property here
         * e.g. $scope.Widgets.byId(), $scope.Widgets.byName()or access widgets by $scope.Widgets.widgetName
         */


    };



    $scope.switch1Change = function($event, $isolateScope) {

        if ($scope.Widgets.switch1.datavalue == "List") {
            $scope.Widgets.EmployeeList.show = true;
            $scope.Widgets.EmployeeGrid.show = false;
        }
        if ($scope.Widgets.switch1.datavalue == "Grid") {
            $scope.Widgets.EmployeeList.show = false;
            $scope.Widgets.EmployeeGrid.show = true;
        }
    };



    $scope.button1Click = function($event, $isolateScope) {
        $scope.Widgets.formcontainer.show = true;
    };

}]);




Application.$controller("pagedialog1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("EmployeeGrid1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);

Application.$controller("grid2Controller", ["$scope",
	function($scope) {
		"use strict";
		$scope.ctrlScope = $scope;
	}
]);

Application.$controller("liveform2Controller", ["$scope",
	function($scope) {
		"use strict";
		$scope.ctrlScope = $scope;
	}
]);