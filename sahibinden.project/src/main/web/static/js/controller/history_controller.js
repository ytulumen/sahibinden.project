'use strict';

angular.module('myApp').controller('HistoryController', ['$scope', 'HistoryService', function($scope, HistoryService) {
    var self = this;
    self.scoin={value:'',date:''};
    self.scoins=[];

    fetchAll();

    function fetchAll(){
        HistoryService.fetchAll()
            .then(
                function(d) {
                    self.scoins = d;
                },
                function(errResponse){
                    console.error('Error while fetching History of SCoins');
                }
            );
    }

}]);