<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "welcome.ftl">

<@sf.form action="/admin/teacher" method="post" modelAttribute="teacher">
<fieldset>
    <div>
        <@sf.label path="first_name">First name: </@sf.label>
        <@sf.input path="first_name" type="text"/>
        <@sf.errors path="first_name"/>
    </div>
    <div>
        <@sf.label path="last_name">Last name: </@sf.label>
        <@sf.input path="last_name" type="text"/>
        <@sf.errors path="last_name"/>
    </div>
    <div>
        <@sf.label path="age">Age: </@sf.label>
        <@sf.input path="age" type="number"/>
        <@sf.errors path="age"/>
    </div>
    <div>
        <@sf.label path="seniority">Seniority: </@sf.label>
        <@sf.input path="senioruty" type="number"/>
        <@sf.errors path="seniority"/>
    </div>
    <div>
        <@sf.label path="city">City:</@sf.label>
        <@sf.input path="city" type="text"/>
        <@sf.errors path="city"/>
    </div>
    <div>
        <@sf.label path="studio">Studio:</@sf.label>
        <@sf.input path="studio" type="text"/>
        <@sf.errors path="studio"/>
    </div>
    <div>
        <@sf.label path="speciality">Speciality:</@sf.label>
        <@sf.input path="speciality" type="text"/>
        <@sf.errors path="speciality"/>
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