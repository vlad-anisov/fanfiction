<#macro login path>
    <form class="form-signin mt-3" action="${path}" method="post">
        <input required pattern="^[a-zA-Z][a-zA-Z0-9]+$" type="text" class="form-control mb-3" placeholder="Username" name="username">
        <#if path=="/signup">
        <input required type="email"  class="form-control mb-3" placeholder="Email" name="email">
        </#if>
        <input required pattern="^[a-zA-Z0-9]+$" type="password" class="form-control mb-3" placeholder="Password" name="password">
        <#if path=="/login">
        <div class="custom-control custom-checkbox mr-sm-2 mb-3">
            <input type="checkbox" class="custom-control-input" id="customControlAutosizing" name="remember-me">
            <label class="custom-control-label" for="customControlAutosizing">Remember me</label>
        </div>
        </#if>
        <#if path=="/login">
        <button class="btn btn-lg btn-primary btn-block mb-3" type="submit">Sign in</button>
        <#else>
        <button class="btn btn-lg btn-primary btn-block mb-3" type="submit">Sing up</button>
        </#if>
    </form>
</#macro>