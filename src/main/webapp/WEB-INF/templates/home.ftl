<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link href="/css/bootstrap.css" rel="stylesheet">
    <title>Welcome!</title>
</head>
<body>
<div class="container">
<#include "welcome.ftl">
<#include "city_list.ftl">
<#include "city_search_form.ftl">
    <hr>
<#if admin>
    <a class="btn btn-info" href="/admin/new_city">New City!</a>
</#if>
    <br>
    <br>
    <a class="btn btn-primary" href="/logout">Logout</a>
</div>
</body>
</html>