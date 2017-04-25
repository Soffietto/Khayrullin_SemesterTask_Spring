<#include "welcome.ftl">
<div>
    <h2>Choose a speciality:</h2>
<#list specialisty_list as s>
    <div>
        <a href="/admin/?city=${city_id}&studio?=${studio_id}&speciality?=${s.id}">${s.name}</a>
    </div>
<#else>
    <p>No specialities!</p>
</#list>
</div>
<a href="/admin/home">Home</a>