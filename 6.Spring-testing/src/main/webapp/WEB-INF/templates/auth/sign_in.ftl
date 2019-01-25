<#include "../main-template.ftl"/>

<#macro content>
    <form action="/login/process" method="post">
        <div>
            Email: <input name="email" type="email">
        </div>
        <div>
            Password: <input name="password" type="password">
        </div>
        <input type="submit">
    </form>
    <#if error??>
        <p>Bad credentials</p>
    </#if>
</#macro>

<@main title="Login"/>