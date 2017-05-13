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
<#include "studio_list.ftl">
<#include "studio_search_form.ftl">
    <hr>
<#if admin>
    <a class="btn btn-info" href="/admin/city=${city_id}/new_studio">New Studio!</a>
</#if>
    <br>
    <a class="btn btn-primary" href="/home">Home</a>
</div>
</body>
</html>