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
<#include "specialty_list.ftl">
<#include "specialty_search_form.ftl">
    <hr>
<#if admin>
    <a class="btn btn-info" href="/admin/city=${city_id}/studio=${studio_id}/new_specialty">New Specialty!</a>
</#if>
    <br>
    <a class="btn btn-danger" href="/city=${city_id}">Back</a>
    <a class="btn btn-primary" href="/home">Home</a>
</div>
</body>
</html>