<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "welcome.ftl">
<#if error??>
Bad creds
</#if>
<@sf.form action="/admin/city=${city_id}/studio=${studio_id}/specialty=${specialty_id}/new_teacher" method="post" modelAttribute="teacher">
<h4>City: ${city_name}</h4>
<h4>Studio: ${studio_name}</h4>
<h4>Specialty: ${specialty_name}</h4>
<h4>Please, enter a new teacher:</h4>
<fieldset>
    <div>
        <@sf.label path="firstName">First name: </@sf.label>
        <@sf.input path="firstName" type="text"/>
        <@sf.errors path="firstName"/>
    </div>
    <div>
        <@sf.label path="lastName">Last name: </@sf.label>
        <@sf.input path="lastName" type="text"/>
        <@sf.errors path="lastName"/>
    </div>
    <div>
        <@sf.label path="age">Age: </@sf.label>
        <@sf.input path="age" type="number"/>
        <@sf.errors path="age"/>
    </div>
    <div>
        <@sf.label path="seniority">Seniority: </@sf.label>
        <@sf.input path="seniority" type="number"/>
        <@sf.errors path="seniority"/>
    </div>
    <div>
        <@sf.label path="regalia">Regalias:</@sf.label>
        <@sf.input path="regalia" type="text"/>
        <@sf.errors path="regalia"/>
    </div>
    <div>
        <@sf.label path="phone">Phone number:</@sf.label>
        <@sf.input path="phone" type="text"/>
        <@sf.errors path="phone"/>
    </div>
    <div>
        <input type="submit" value="Apply">
    </div>
</fieldset>
</@sf.form>
<a href="/city=${city_id}/studio=${studio_id}/specialty=${specialty_id}">Back</a>
<a href="/home">Home</a>