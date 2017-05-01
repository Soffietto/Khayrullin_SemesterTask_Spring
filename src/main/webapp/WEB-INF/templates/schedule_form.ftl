<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "welcome.ftl">
<@sf.form action="/admin/city=${city_id}/studio=${studio_id}/specialty=${specialty_id}/teacher=${teacher_id}/new_schedule" method="post" modelAttribute="schedule">
<h4>City: ${city_name}</h4>
<h4>Studio: ${studio_name}</h4>
<h4>Specialty: ${specialty_name}</h4>
<h4>Teacher: ${teacher_name}</h4>
<h4>Please, enter a new schedule:</h4>
<fieldset>
    <div>
        <@sf.label path="monday">Monday: </@sf.label>
        <@sf.input path="monday" type="text"/>
        <@sf.errors path="monday"/>
    </div>
    <div>
        <@sf.label path="tuesday">Tuesday: </@sf.label>
        <@sf.input path="tuesday" type="text"/>
        <@sf.errors path="tuesday"/>
    </div>
    <div>
        <@sf.label path="wednesday">Wednesday: </@sf.label>
        <@sf.input path="wednesday" type="text"/>
        <@sf.errors path="wednesday"/>
    </div>
    <div>
        <@sf.label path="thursday">Thursday: </@sf.label>
        <@sf.input path="thursday" type="text"/>
        <@sf.errors path="thursday"/>
    </div>
    <div>
        <@sf.label path="friday">Friday: </@sf.label>
        <@sf.input path="friday" type="text"/>
        <@sf.errors path="friday"/>
    </div>
    <div>
        <@sf.label path="saturday">Saturday: </@sf.label>
        <@sf.input path="saturday" type="text"/>
        <@sf.errors path="saturday"/>
    </div>
    <div>
        <@sf.label path="sunday">Sunday: </@sf.label>
        <@sf.input path="sunday" type="text"/>
        <@sf.errors path="sunday"/>
    </div>
    <div>
        <input type="submit" value="Apply">
    </div>
</fieldset>
</@sf.form>
<hr>
<a href="/home">Home</a>