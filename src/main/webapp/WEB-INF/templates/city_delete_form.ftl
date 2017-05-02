<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<@sf.form action="/admin/delete_city" method="post">
<div>
    <button name="delete_button" type="submit" value="${c.id}">Delete</button>
</div>
</@sf.form>