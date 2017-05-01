<div>
    <h4>City: ${city_name}</h4>
    <hr>
</div>
<div>
    <h2>Choose a studio:</h2>
<#list studio_list as s>
    <div>
        <p>Studio: <a href="/city=${city_id}/studio=${s.id}">${s.name}</a></p>
        <#if admin>
            <#include "studio_delete_form.ftl">
        </#if>
        <hr>
    </div>
<#else>
    <p>No studios!</p>
</#list>
</div>