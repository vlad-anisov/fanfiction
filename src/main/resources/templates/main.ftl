<#import "parts/common.ftl" as common>
<@common.page>
<h1>Main</h1>
<div>
    <form method="post">
        <input type="text" name="username" placeholder="Введите имя">
        <button type="submit">Добавить</button>
    </form>
</div>
<h3>Список пользователей</h3>
<#list users as user>
    <b>${user.id}</b>
    <b>${user.username}</b><br>
</#list>
</@common.page>
