<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "welcome.ftl">

<@sf.form action="/admin/new_city" method="post" modelAttribute="city">
<fieldset>
    <div>
        <@sf.label path="name">Name</@sf.label>
        <@sf.input path="name" type="text"/>
        <@sf.errors path="name"/>
    </div>
    <div>
        <input type="submit" value="Apply" onclick="alert("Success!")">
    </div>
</fieldset>
</@sf.form>
<hr>
<a href="/admin/home">Back</a>