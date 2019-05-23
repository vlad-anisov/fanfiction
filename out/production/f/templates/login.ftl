<#import "parts/common.ftl" as common>
<#import "parts/login.ftl" as login>
<@common.page>
    <h1>Login</h1>
    <@login.login "/login"/>
    <a href="/signup">SignUp</a>
</@common.page>
