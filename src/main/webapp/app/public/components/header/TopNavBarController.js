(function(){
    'use strict';

    App.controller('TopNavBarController', ['$scope','$state',
    function($scope, $state){

        $scope.nav = 'nav';

        $scope.products = function(){
            $state.go('app.products');
        };

        $scope.login = function () {
            $state.go('login')
        }
    }])
})();