<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link href="/css/bootstrap.css" rel="stylesheet">
    <title>Sign Up</title>
</head>
<body>
<div class="container">
<@sf.form role="form" action="/sign_up" method="post" modelAttribute="user">
    <h2>Sign Up</h2>
    <fieldset>
        <div class="field">
            <@sf.label path="email">Email</@sf.label>
            <@sf.input path="email" cssClass="form-control" type="email"/>
            <@sf.errors path="email" cssClass="help-block"/>
        </div>
        <div class="field">
            <@sf.label path="name">Name:</@sf.label>
            <@sf.input path="name" cssClass="form-control" type="text"/>
            <@sf.errors path="name" cssClass="help-block"/>
        </div>
        <div class="field">
            <@sf.label path="password">Password</@sf.label>
            <@sf.input path="password" cssClass="form-control" type="password"/>
            <@sf.errors path="password" cssClass="help-block"/>
        </div>
        <div class="form-group">
            <input class="btn btn-info btn-outline" type="submit" value="Sign up">
        </div>
    </fieldset>
    <a href="/sign_in">Sign in</a>
</@sf.form>
</div>
</body>
</html>