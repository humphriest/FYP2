(function(){
    'use strict';
    App.controller('ProductController', ['$scope','$http','$state',
        function($scope, $http, $state){

            $scope.productsMessage = "products";

            $scope.item = {};

            console.log($scope.item+ " item<<");

            $scope.searchBar = "";
            $http.get('/restful-services/stockApi/getAllItems')
                .then(function(res){
                    $scope.items = res.data;
                    console.log($scope.items+" items");
                }, function(err){
                    console.log(err);
                });

            $scope.addToCart = function (item) {

            }
        }])
})();