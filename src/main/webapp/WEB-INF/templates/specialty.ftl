<#include "welcome.ftl">
<#include "specialty_list.ftl">
<#if admin>
    <a href="/admin/city=${city_id}/studio=${studio_id}/new_specialty">New Specialty!</a>
</#if>
<a href="/city=${city_id}">Back</a>
<a href="/home">Home</a>