<#import "parts/common.ftl" as common>
<@common.page>
    <div class="row d-flex justify-content-center">
        <h1>Admin</h1>
    </div>
    <table class="table table-hover table-borderless" >
    <thead>
    <tr>
        <th scope="col" style="width: 8rem">ID</th>
        <th scope="col" style="width: 8rem">Username</th>
        <th scope="col" style="width: 8rem">Role</th>
        <th scope="col" style="width: 8rem">Status</th>
        <th scope="col" style="width: 8rem"></th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
            <tr>
                <th scope="row">${user.id}</th>
                <td><a class="text-primary" href="/user/${user.username}">${user.username}</a></td>
                <td><#list user.role as role>${role}<#sep>, </#list></td>
                <td><#if user.isEnabled()>
                        Active
                    <#else>
                        Block
                    </#if></td>
                <td>
                    <#if !user.getAdmin()>
                    <form method="post">
                        <input type="hidden" value="${user.id}" name="id">
                    <button formaction="/admin/assignAdmin" class="btn btn-outline-primary mr-2" style="width: 5rem" value="user.username">Admin</button>
                    <button formaction="/admin/block" class="btn btn-outline-warning mr-2"style="width: 5rem">Block</button>
                    <button formaction="/admin/delete" class="btn btn-outline-danger"style="width: 5rem">Delete</button>
                    </form>
                    </#if>
                </td>
            </tr>
    </#list>
    </tbody
    </table>
</@common.page>