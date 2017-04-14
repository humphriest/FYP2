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
                $scope.totalPrice = item.price;
                CartService.addItemToCart(JSON.stringify($scope.cartItem))
                    .then(function (res) {
                        // $rootScope.updateCart();
                        console.log(res);
                    })
                    .catch(function (err) {
                        console.log(err);
                    })
            };

            $scope.comment = function (review, item) {
                $scope.review.body = review.body;
                $scope.review.review = review.rating;
                $scope.review.user = $scope.currentUser;
                $scope.review.stockItem = item;
                console.log("comment clicked");
                $scope.ReviewObject = {};
                delete $scope.review["$$hashKey"];
                $http.post('/restful-services/reviewApi/createReview', JSON.stringify($scope.review))
                    .then(function (res) {
                        console.log(res.data);
                    })
                    .catch(function (err) {
                        console.log(err);
                    });
                console.log("review: ", $scope.review);
            };
            $scope.diffComment = function (review, item) {
                $scope.review.body = review.body;
                $scope.review.rating = review.rating;
                $scope.review.user = $scope.currentUser;
                $scope.review.stockItem = item;
                console.log("comment clicked");
                //$scope.ReviewObject = {};
                //delete $scope.review["$$hashKey"];
                $http.post('/restful-services/reviewApi/createReview', JSON.stringify($scope.review))
                    .then(function (res) {
                        console.log(res.data);
                    })
                    .catch(function (err) {
                        console.log(err);
                    });
                console.log("review: ", $scope.review);
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
            };

            $scope.updateItem = function (p) {
                //$scope.item.price = p;
                $http.post('/restful-services/stockApi/updatePrice/'+p+'/'+$scope.currentItem)
                //ProductService.updateItem(p,$scope.currentItem)
                    .then(function (res) {
                        console.log("res:", res.data);
                    })
                    .catch(function (err) {
                        console.log(err);
                    })
            }
        }])
})();