<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<@sf.form action="/admin/city=${city_id}/studio=${studio_id}/delete_specialty" method="post">
<div>
    <button name="delete_button" type="submit" value="${s.id}">Delete</button>
</div>
</@sf.form>