<#import "parts/common.ftl" as common>
<#import "parts/login.ftl" as login>
<@common.page>
    <div class="row d-flex justify-content-center">
    <div class="col-sm-3">
    <h1 class="text-center">Sing up</h1>
        <#if message??>
            <div class="row d-flex justify-content-center mt-3">
                <#if message==true>
                    <div class="alert alert-success" role="alert">
                        All saved
                    </div>
                </#if>
                <#if message==false>
                    <div class="alert alert-danger" role="alert">
                        User with the same name or email already exists
                    </div>
                </#if>
            </div>
        </#if>
    <@login.login "/signup"/>
    </div>
</@common.page>