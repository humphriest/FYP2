(function(){

    'use strict';

    App.controller('MainMenuController',['$scope','$cookieStore','ProductService',
    function($scope, $cookieStore, ProductService){

        $scope.message = "Hello and welcome message from the controller";

        $scope.currentUser = $cookieStore.get('userCookie');
        console.log($scope.currentUser);


    }])
})();