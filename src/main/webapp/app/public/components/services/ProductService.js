(function(){
    'use strict';
    App.service('ProductService',['$http',
        function($http){

            var baseUrl = '/restful-services/stockApi';

            this.getProducts = function(){
                return $http.get(baseUrl + '/getAllItems');
            };

            this.getItemById = function(item){
                return $http.post(baseUrl + '/getItemById', item);
            };

            this.addItem = function(item){
                return $http.post(baseUrl + '/createItem/', item);
            };

            this.updateItem = function(p, id){
                return $http.post(baseUrl, + '/updatePrice/'+p +"/"+id);
            };

            this.deleteProduct = function(item){
                return $http.delete(baseUrl + '/deleteItem', item);
            };
        }])
})();