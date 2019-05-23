<#import "parts/common.ftl" as common>
<#import "parts/login.ftl" as login>
<@common.page>
    <h1>Sing up</h1>
    ${message}
    <@login.login "/signup"/>
</@common.page>