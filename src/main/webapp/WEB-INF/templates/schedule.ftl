<#include "welcome.ftl">
<#include "schedule_table.ftl">
<#if admin>
<a href="/admin/city=${city_id}/studio=${studio_id}/specialty=${specialty_id}/teacher=${teacher_id}/new_schedule">New Schedule</a>
</#if>
<a href="/city=${city_id}/studio=${studio_id}/specialty=${specialty_id}">Back</a>
<a href="/home">Home</a>