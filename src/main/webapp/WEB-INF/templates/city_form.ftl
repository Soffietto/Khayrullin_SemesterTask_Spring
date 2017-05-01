<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "welcome.ftl">
<@sf.form action="/admin/new_city" method="post" modelAttribute="city">
<h4>Please, enter a new city:</h4>
<fieldset>
    <div>
        <@sf.label path="name">Name</@sf.label>
        <@sf.input path="name" type="text"/>
        <@sf.errors path="name"/>
    </div>
    <div>
        <input type="submit" value="Apply">
    </div>
</fieldset>
</@sf.form>
<hr>
<a href="/home">Home</a>