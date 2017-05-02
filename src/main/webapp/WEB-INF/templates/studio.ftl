<#include "welcome.ftl">
<#include "studio_list.ftl">
<#include "studio_search_form.ftl">
<hr>
<#if admin>
<a href="/admin/city=${city_id}/new_studio">New Studio!</a>
</#if>
<a href="/home">Home</a>