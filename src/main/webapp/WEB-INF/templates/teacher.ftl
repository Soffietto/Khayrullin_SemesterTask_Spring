<#include "welcome.ftl">
<#include "teacher_list.ftl">
<#include "teacher_search_form.ftl">
<hr>
<#if admin>
<a href="/admin/city=${city_id}/studio=${studio_id}/specialty=${specialty_id}/new_teacher">New Teacher!</a>
</#if>
<a href="/city=${city_id}/studio=${studio_id}">Back</a>
<a href="/home">Home</a>