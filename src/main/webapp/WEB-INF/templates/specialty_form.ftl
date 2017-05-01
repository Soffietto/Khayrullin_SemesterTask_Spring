<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "welcome.ftl">
<@sf.form action="/admin/city=${city_id}/studio=${studio_id}/new_specialty" method="post" modelAttribute="specialty">
<h4>City: ${city_name}</h4>
<h4>Studio: ${studio_name}</h4>
<h4>Please, enter a new speciality:</h4>
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
<a href="/city=${city_id}/studio=${studio_id}">Back</a>
<a href="/home">Home</a>