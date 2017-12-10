<%--
  Created by IntelliJ IDEA.
  User: yasintulumen
  Date: 10/12/2017
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SCoin</title>
    <style>
        .name.ng-valid {
            background-color: lightgreen;
        }
        .name.ng-dirty.ng-invalid-minlength {
            background-color: yellow;
        }


    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body ng-app="myApp" class="ng-cloak">
<div class="generic-container" ng-controller="TickerController as ctrl">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">Daily SCoin </span></div>
        <div class="formcontainer">
            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                <input type="hidden" ng-model="ctrl.oldVal" />
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="oldVal">Value</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.oldVal" id="oldVal" class="name form-control input-sm" placeholder="Enter value" required ng-minlength="1" />
                            <div class="has-error" ng-show="myForm.$dirty">
                                <span ng-show="myForm.name.$error.minlength">Minimum length required is 1</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-actions floatRight">
                        <input type="submit" id="convertButton"  value="{'Convert'}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Result </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Value</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="u in ctrl.tickers">
                    <td><span ng-bind="u.value"></span></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script src="<c:url value='/static/js/app.js' />"></script>
<script src="<c:url value='/static/js/service/ticker_service.js' />"></script>
<script src="<c:url value='/static/js/controller/ticker_controller.js' />"></script>
</body>
</html>