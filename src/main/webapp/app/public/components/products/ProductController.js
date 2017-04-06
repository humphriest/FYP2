(function(){
    'use strict';
    App.controller('ProductController', ['$scope','$http','$state','ProductService','$stateParams','CartService','$rootScope','$cookieStore',
        function($scope, $http, $state, ProductService, $stateParams, CartService, $rootScope, $cookieStore){

            $scope.productsMessage = "products";
            $scope.cartItem = {};
            $scope.currentUser = $cookieStore.get('userCookie');
            console.log($scope.item+ " item<<");

            $scope.currentItem = JSON.parse($stateParams.stockItemId);
            console.log($scope.currentItem);

            ProductService.getItemById($scope.currentItem)
                .then(function(res){
                    $scope.item = res.data.stockItem;
                    console.log($scope.item +" item");
                    console.log(res.data +" res item");
                }, function(err){
                    console.log(err);
                });

            $scope.addToCard = function (item) {
                $scope.cartItem.stockItem = item;
                $scope.cartItem.user = $scope.currentUser;
                $scope.cartItem.paid = false;
                CartService.addItemToCart(JSON.stringify($scope.cartItem))
                    .then(function (res) {
                       // $rootScope.updateCart();
                        console.log(res);
                    })
                    .catch(function (err) {
                        console.log(err);
                    })
            }
        }])
})();