(function(){
    'use strict';
    App.controller('ProductController', ['$scope','$http','$state','ProductService','$stateParams',
        function($scope, $http, $state, ProductService, $stateParams){

            $scope.productsMessage = "products";

            $scope.item = {};

            console.log($scope.item+ " item<<");

            $scope.currentItem = JSON.parse($stateParams.stockItemId);
            console.log($scope.currentItem);

            ProductService.getItemById(JSON.stringify($scope.currentItem))
                .then(function(res){
                    $scope.item = res.data;
                    console.log($scope.items+" items");
                }, function(err){
                    console.log(err);
                });

            $scope.addToCart = function (item) {

            }
        }])
})();