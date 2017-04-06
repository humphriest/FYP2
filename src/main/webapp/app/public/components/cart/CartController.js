(function(){
    'use strict';
    App.controller('CartController', ['$scope','CartService','$cookieStore',
        function ($scope, CartService, $cookieStore) {

            $scope.currentUser = $cookieStore.get('userCookie');

            CartService.getCartByUser($scope.currentUser)
                .then(function (res) {
                    $scope.items = res.data;
                    console.log(res.data)
                })
                .catch(function (err) {
                    console.log(err);
                })
            
        }])
});