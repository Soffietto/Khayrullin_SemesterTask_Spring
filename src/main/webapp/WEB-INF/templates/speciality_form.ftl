<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "welcome.ftl">

<@sf.form action="/admin/speciality" method="post" modelAttribute="speciality">
<fieldset>
    <div>
        <@sf.label path="name">Name</@sf.label>
        <@sf.input path="name" type="text"/>
        <@sf.errors path="name"/>
    </div>
    <div>
        <@sf.label path="city">City:</@sf.label>
        <@sf.input path="city" type="text"/>
        <@sf.errors path="city"/>
    </div>
    <div>
        <input type="submit" value="Apply">
    </div>
</fieldset>
</@sf.form>