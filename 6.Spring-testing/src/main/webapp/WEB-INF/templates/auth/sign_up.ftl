<#include "../main-template.ftl"/>

<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<#macro content>
    <@sf.form action="/sign_up" method="post" modelAttribute="user">
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
            <@sf.input path="email" type="email"/>
            <@sf.errors path="email"/>
        </div>
        <div>
            <@sf.label path="password">Password</@sf.label>
            <@sf.input path="password" type="password"/>
            <@sf.errors path="password"/>
        </div>
        <input type="submit">
    </@sf.form>
</#macro>

<@main title="Sign up"/>