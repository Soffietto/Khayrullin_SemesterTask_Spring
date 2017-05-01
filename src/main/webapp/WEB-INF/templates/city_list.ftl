<div>
    <h2>Choose a city:</h2>
    <hr>
<#list city_list as c>
    <div>
        <p>City: <a href="/city=${c.id}">${c.name}</a></p>
        <#if admin>
            <#include "city_delete_form.ftl">
        </#if>
    </div>
    <hr>
<#else>
    <p>No cities!</p>
</#list>
</div>