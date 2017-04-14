(function(){
    'use strict';
    App.service('CartService',['$http',
        function($http){

            var baseUrl = '/restful-services/cartApi';

            this.createCart = function () {
                return $http.post(baseUrl + 'createCart');
            };

            this.getCarts = function(){
                return $http.get(baseUrl + '/getAllCarts');
            };

            this.getCartByUser = function(user){
                return $http.post(baseUrl + '/getCartByUser/'+false, user);
            };
            this.getPurchasedByUser = function(user){
                return $http.post(baseUrl + '/getCartByUser/'+true, user);
            };

            this.addItemToCart = function(item){
                return $http.post(baseUrl + '/addItemToCart', item);
            };

            this.updatePaid = function(carts){
             return $http.post(baseUrl, + '/updatePaid', carts);
             };

            this.deleteProduct = function(item){
                return $http.delete(baseUrl + '/deleteItem', item);
            };
        }])
})();