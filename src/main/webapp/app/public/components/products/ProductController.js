(function(){
    'use strict';
    App.controller('ProductController', ['$scope','$http','$state','ProductService','$stateParams','CartService','$rootScope','$cookieStore',
        function($scope, $http, $state, ProductService, $stateParams, CartService, $rootScope, $cookieStore){

            $scope.productsMessage = "products";
            $scope.cartItem = {};
            $scope.currentUser = $cookieStore.get('userCookie');
            console.log($scope.item+ " item<<");
            $scope.starRating = 2;
            $scope.review = {};

            $scope.currentItem = JSON.parse($stateParams.stockItemId);
            console.log($scope.currentItem);

            ProductService.getItemById($scope.currentItem)
                .then(function(res){
                    $scope.item = res.data.stockItem;
                    $scope.getComments($scope.item);
                    console.log($scope.item +" item");
                    console.log(res.data +" res item");
                }, function(err){
                    console.log(err);
                });

            $scope.addToCart = function (item) {
                $scope.cartItem.stockItem = item;
                $scope.cartItem.user = $scope.currentUser;
                $scope.cartItem.paid = false;
                $scope.cartItem.quantity = 1;
                $scope.totalPrice = 0;
                CartService.addItemToCart(JSON.stringify($scope.cartItem))
                    .then(function (res) {
                       // $rootScope.updateCart();
                        console.log(res);
                    })
                    .catch(function (err) {
                        console.log(err);
                    })
            };

            $scope.comment = function (item) {
                $scope.review.body = review.body;
                $scope.review.review = review.rating;
                $scope.review.timeStamp = Date.now();
                $scope.review.user = $scope.currentUser;
                $scope.review.stockItem = item;
                $http.post('/restful-services/reviewApi/createReview')
                    .then(function (res) {
                        console.log(res.data);
                    })
                    .catch(function (err) {
                        console.log(err);
                    })
            };
            $scope.getComments = function (stockItem) {
                $http.post('/restful-services/reviewApi/getCommentByItem', stockItem)
                    .then(function (res) {
                        $scope.carts = res.data;
                        console.log("res data: " + res.data);
                    })
                    .catch(function (err) {
                        console.log(err);
                    });
            }

        }])
})();