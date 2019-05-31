<#macro login path>
    <form class="form-signin mt-3" action="${path}" method="post">
        <input required type="text" class="form-control mb-3" placeholder="Username" name="username">
        <#if path=="/signup">
        <input required type="email"  class="form-control mb-3" placeholder="Email" name="email">
        </#if>
        <input required type="password" class="form-control mb-3" placeholder="Password" name="password">
        <div class="custom-control custom-checkbox mr-sm-2 mb-3">
            <input type="checkbox" class="custom-control-input" id="customControlAutosizing">
            <label class="custom-control-label" for="customControlAutosizing">Remember my preference</label>
        </div>
        <button class="btn btn-lg btn-primary btn-block mb-3" type="submit">Sign in</button>
    </form>
</#macro>