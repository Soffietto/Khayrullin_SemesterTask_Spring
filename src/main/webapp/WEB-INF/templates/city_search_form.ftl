<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<@sf.form action="/city_search" method="post">
Search:<br>
<input type="text" name="search">
<div>
    <input type="submit" value="Search">
</div>
</@sf.form>