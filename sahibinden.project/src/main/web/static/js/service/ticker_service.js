'use strict';

angular.module('myApp').factory('TickerService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/ticker/';

    var factory = {
        fetchAll: fetchAll,
    };
    return factory;

    function fetchAll() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }



}]);