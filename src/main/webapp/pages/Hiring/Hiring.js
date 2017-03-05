Application.$controller("HiringPageController", ["$scope", function ($scope) {
    "use strict";

    /* perform any action on the variables within this block(on-page-load) */
    $scope.onPageVariablesReady = function () {
        /*
         * variables can be accessed through '$scope.Variables' property here
         * e.g. to get data in a static variable named 'loggedInUser' use following script
         * $scope.Variables.loggedInUser.getData()
         */
    };
    /* perform any action on widgets within this block */
    $scope.onPageReady = function () {
        /*
         * widgets can be accessed through '$scope.Widgets' property here
         * e.g. to get value of text widget named 'username' use following script
         * '$scope.Widgets.username.datavalue'
         */
    };

}]);

Application.$controller("grid3Controller", ["$scope",
	function($scope) {
		"use strict";
		$scope.ctrlScope = $scope;
	}
]);


Application.$controller("pagedialog1Controller", ["$scope",
	function($scope) {
		"use strict";
		$scope.ctrlScope = $scope;
	}
]);

Application.$controller("confirmdialog1Controller", ["$scope",
	function($scope) {
		"use strict";
		$scope.ctrlScope = $scope;
	}
]);

Application.$controller("dialog1Controller", ["$scope",
	function($scope) {
		"use strict";
		$scope.ctrlScope = $scope;
	}
]);

Application.$controller("liveform1Controller", ["$scope",
	function($scope) {
		"use strict";
		$scope.ctrlScope = $scope;
	}
]);