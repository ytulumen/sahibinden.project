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
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body ng-app="myApp" class="ng-cloak">
<div class="generic-container" ng-controller="HistoryController as ctrl">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">History of SCoin </span></div>

        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List</span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Value</th>
                    <th>Date</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="u in ctrl.scoins">
                    <td><span ng-bind="u.value"></span></td>
                    <td><span>{{u.date | date: 'dd.MM.yyyy HH:mm'}}</span></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script src="<c:url value='/static/js/app.js' />"></script>
<script src="<c:url value='/static/js/service/history_service.js' />"></script>
<script src="<c:url value='/static/js/controller/history_controller.js' />"></script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</body>
</html>