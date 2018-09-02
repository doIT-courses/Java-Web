<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<html>
<head>
    <title>Sign up</title>
</head>
<body>
    <@sf.form action="/users/new" method="post" modelAttribute="user">
        <div>
            <@sf.label path="name">Name</@sf.label>
            <@sf.input path="name"/>
            <@sf.errors path="name"/>
        </div>
        <div>
            <@sf.label path="surname">Surname</@sf.label>
            <@sf.input path="surname"/>
            <@sf.errors path="surname"/>
        </div>
        <div>
            <@sf.label path="email">Email</@sf.label>
            <@sf.input path="email"/>
            <@sf.errors path="email"/>
        </div>
        <input type="submit">
    </@sf.form>
</body>
</html>