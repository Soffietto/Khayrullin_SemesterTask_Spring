<div>
    <h4>City: ${city_name}</h4>
    <h4>Studio: ${studio_name}</h4>
    <hr>
</div>
<div>
    <h2>Choose a specialty:</h2>
<#list specialty_list as s>
    <div>
        <p>Specialty: <a href="/city=${city_id}/studio=${studio_id}/specialty=${s.id}">${s.name}</a></p>
        <#if admin>
            <#include "specialty_delete_form.ftl">
        </#if>
    </div>
    <hr>
<#else>
    <p>No specialties!</p>
</#list>
</div>