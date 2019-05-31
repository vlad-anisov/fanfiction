<#import "parts/common.ftl" as common>
<@common.page>
    <h1>Edit</h1>
    <form action="/user/${user.username}/edit" method="post">
        <div class="row d-flex justify-content-center">
            <div>${message?if_exists}</div>
        <div class="input-group mb-3" style="width: 35rem">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">Name</span>
            </div>
            <input type="text" class="form-control"  aria-describedby="basic-addon1" name="newUsername" value="${user.username}">
        </div>
        </div>
        <div class="row d-flex justify-content-center mb-3">
            <div class="custom-control custom-switch">
                <input name="darkMode" type="checkbox" class="custom-control-input" id="customSwitch" ${user.isDarkMode()?string("checked","")}>
                <label class="custom-control-label" for="customSwitch">Dark mode</label>
            </div>
        </div>
        <div class="row d-flex justify-content-center">
            <div class="col-auto">
            <button formaction="/user/${user.username}/save" class="btn btn-outline-success" type="submit">Save</button>
            </div>
            <div class="col-auto">
                <button formaction="/user/${user.username}/delete" class="btn btn-outline-danger" type="submit">Delete account</button>
            </div>
        </div>
    </form>
</@common.page>