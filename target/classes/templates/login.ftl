<#import "parts/common.ftl" as common>
<#import "parts/login.ftl" as login>
<@common.page>
<div class="row d-flex justify-content-center">
    <div class="col-sm-3">
    <h1 class="text-center">Login</h1>
        ${message?ifExists}
    <@login.login "/login"/>
    <a href="/signup">SignUp</a>
    </div>
</div>
</@common.page>
