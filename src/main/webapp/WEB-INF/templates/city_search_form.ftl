<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<@sf.form action="/city_search" method="post" cssClass="form-group">
Search:<br>
<input type="text" name="search">
<div>
    <input class="btn-primary" type="submit" value="Search">
</div>
</@sf.form>