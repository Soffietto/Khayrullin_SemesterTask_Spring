<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<@sf.form action="/admin/city=${city_id}/delete_studio" method="post">
<div>
    <button name="delete_button" type="submit" value="${s.id}">Delete</button>
</div>
</@sf.form>