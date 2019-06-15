<#import "parts/common.ftl" as common>
<@common.page>
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.14.2/dist/bootstrap-table.min.css">
    <div class="row d-flex justify-content-center">
        <h1>Admin</h1>
    </div>
    <table class="table table-hover table-borderless" data-toggle="table" style="border: none">
    <thead>
    <tr>
        <th scope="col" data-field="username" data-sortable="true" >Username</th>
        <th scope="col" data-field="role" data-sortable="true">Role</th>
        <th scope="col" data-field="status" data-sortable="true">Status</th>
        <th scope="col" style="width: 20rem"></th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
            <tr>
                <td><a class="text-primary" href="/user/${user.username}">${user.username}</a></td>
                <td><#list user.role as role>${role}</#list></td>
                <td><#if user.isEnabled()>
                        Active
                    <#else>
                        Block
                    </#if></td>
                <td>
                    <#if !user.isAdmin()>
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