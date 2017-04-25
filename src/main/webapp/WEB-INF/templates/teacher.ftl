<#include "welcome.ftl">

<div>
    <h2>Choose a teacher:</h2>
<#list teacher_list as t>
    <div>
        <a href="/city?=${city}&studio?=${studio}&speciality?=${speciality}&teacher?=${t.id}">${t.name}</a>
    </div>
<#else>
    <p>No teachers!</p>
</#list>
</div>