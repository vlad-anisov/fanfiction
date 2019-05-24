<#import "parts/common.ftl" as common>
<#import "parts/login.ftl" as login>
<@common.page>
    <div class="row d-flex justify-content-center">
    <div class="col-sm-3">
    <h1 class="text-center">Sing up</h1>
    ${message}
    <@login.login "/signup"/>
    </div>
</@common.page>