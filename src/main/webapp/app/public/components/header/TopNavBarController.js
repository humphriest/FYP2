(function(){
    'use strict';

    App.controller('TopNavBarController', ['$scope','$state','$cookieStore',
    function($scope, $state, $cookieStore){

        $scope.nav = 'nav';

        $scope.products = function(){
            $state.go('app.products');
        };

        $scope.login = function () {
            $state.go('login')
        };

        $scope.logout = function () {
          $cookieStore.remove('userCookie');
            $state.go('login');
        };

        $scope.viewCart = function () {
            $state.go('app.cart');
        };

        $scope.purchaseHistory = function () {
            $state.go("app.purchases");
        };

        $scope.currentUser = $cookieStore.get('userCookie');
    }])
})();