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
                return $http.post(baseUrl + '/getCartByUser', user);
            };

            this.addItemToCart = function(item){
                return $http.post(baseUrl + '/addItemToCart', item);
            };

            /*this.updateUser = function(user){
             return $http.put(baseUrl, + '/' + user.id, user);
             };*/

            this.deleteProduct = function(item){
                return $http.delete(baseUrl + '/deleteItem', item);
            };
        }])
})();