(function(){
    'use strict';
    App.service('ProductService',['$http',
        function($http){

            var baseUrl = '/restful-services/stockApi';

            this.getProducts = function(){
                return $http.get(baseUrl + '/getAllItems');
            };

            this.getItemById = function(item){
                return $http.get(baseUrl + '/current', item);
            };

            this.addItem = function(item){
                return $http.post(baseUrl + '/createItem/', item);
            };

            /*this.updateUser = function(user){
                return $http.put(baseUrl, + '/' + user.id, user);
            };*/

            this.deleteProduct = function(item){
                return $http.delete(baseUrl + '/deleteItem', item);
            };
        }])
})();