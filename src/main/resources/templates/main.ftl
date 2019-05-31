<#import "parts/common.ftl" as common>
<@common.page>
<div class="row d-flex justify-content-center">
    <h1>Main</h1>
</div>
<div class="row d-flex justify-content-center">
    <div class="mb-4">
        <form method="post">
            <input type="text" name="text" placeholder="Введите текст">
            <input type="text" name="tag" placeholder="Тэг">
            <button type="submit">Добавить</button>
        </form>
    </div>
</div>
<#list fanfics as fanfic>
    <div class="row d-flex justify-content-center">
    <div class="card mb-4"  style="width: 35rem">
        <div class="card-body">
            <p class="card-text">
                <b>${fanfic.id}</b><br>
                <b>${fanfic.text}</b><br>
                <b>${fanfic.author.getUsername()}</b><br>
                <b>${fanfic.tag}</b>
            </p>
        </div>
    </div>
    </div>
</#list>
</@common.page>
