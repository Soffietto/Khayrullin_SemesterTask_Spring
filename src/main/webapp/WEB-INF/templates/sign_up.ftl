<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<@sf.form action="/sign_up" method="post" modelAttribute="user">
<fieldset>
    <div>
        <@sf.label path="email">Email</@sf.label>
        <@sf.input path="email" type="email"/>
        <@sf.errors path="email"/>
    </div>
    <div>
        <@sf.label path="name">Name:</@sf.label>
        <@sf.input path="name" type="text"/>
        <@sf.errors path="name"/>
    </div>
    <div>
        <@sf.label path="password">Password</@sf.label>
        <@sf.input path="password" type="password"/>
        <@sf.errors path="password"/>
    </div>
    <div>
        <input type="submit" value="Sign up">
    </div>
</fieldset>
<a href="/sign_in">Sign in</a>
</@sf.form>