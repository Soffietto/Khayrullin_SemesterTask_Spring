<div>
    <h4>City: ${city_name}</h4>
    <h4>Studio: ${studio_name}</h4>
    <h4>Specialty: ${specialty_name}</h4>
    <hr>
</div>
<div>
    <h2>Choose a teacher:</h2>
<#list teacher_list as t>
    <div>
        <p>Name: <a
                href="/city=${city_id}/studio=${studio_id}/specialty=${specialty_id}/teacher=${t.id}">${t.firstName} ${t.lastName}</a>
        </p>
        <p>Age: ${t.age}</p>
        <p>Seniority: ${t.seniority}</p>
        <p>Regalias: ${t.regalia}</p>
        <p>Phone: ${t.phoneNumber}</p>
        <#if admin>
            <#include "teacher_delete_form.ftl">
        </#if>
    </div>
    <hr>
<#else>
    <p>No teachers!</p>
</#list>
</div>