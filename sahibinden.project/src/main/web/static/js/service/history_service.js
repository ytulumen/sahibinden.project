'use strict';

angular.module('myApp').factory('HistoryService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/history/';

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
                    console.error('Error while fetching Roles');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }
}]);