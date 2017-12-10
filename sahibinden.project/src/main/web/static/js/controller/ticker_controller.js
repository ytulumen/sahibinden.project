'use strict';

angular.module('myApp').controller('TickerController', ['$scope', 'TickerService', function($scope, TickerService, $filter) {
    var self = this;
    self.ticker={value:'', date:'', oldVal:''};
    self.tickers=[];

    fetchAll();

    function fetchAll(){
        TickerService.fetchAll()
            .then(
            function(d) {
                self.tickers = d;
            },
            function(errResponse){
                console.error('Error while fetching ');
            }
        );
    }



}]);