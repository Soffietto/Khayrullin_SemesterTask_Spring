<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<@sf.form action="/admin/city=${city_id}/studio=${studio_id}/specialty=${specialty_id}/delete_teacher" method="post">
<div>
    <button name="delete_button" type="submit" value="${t.id}">Delete</button>
</div>
</@sf.form>