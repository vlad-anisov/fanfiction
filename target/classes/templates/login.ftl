<#import "parts/common.ftl" as common>
<#import "parts/login.ftl" as login>
<@common.page>
<div class="row d-flex justify-content-center">
    <div class="col-sm-3">
    <h1 class="text-center">Login</h1>
        <#if message??>
            <div class="row d-flex justify-content-center mt-3">
                <#if message==true>
                    <div class="alert alert-success" role="alert">
                        User successfully activated
                    </div>
                </#if>
                <#if message==false>
                    <div class="alert alert-danger" role="alert">
                        Activated code is note found
                    </div>
                </#if>
            </div>
        </#if>
    <@login.login "/login"/>
    <a href="/signup">SignUp</a>
    </div>
</div>
</@common.page>
