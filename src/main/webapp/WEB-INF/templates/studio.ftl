<#include "welcome.ftl">

<div>
    <h2>Choose a studio:</h2>
<#list studio_list as s>
    <div>
        <a href="/admin/?city=${city_id}&studio=${s.id}">${s.name}</a>
    </div>
<#else>
    <p>No studios!</p>
</#list>
</div>
<a href="/admin/city=${city_id}/new_studio">New Studio!</a>
<a href="/admin/home">Back</a>