<#import "parts/common.ftl" as common>
<@common.page>
    <style>
        .img-bg{
            background: url(${fanfic.image});
            width: 100%;
            filter: blur(30px) contrast(.9) brightness(.9);
        }
    </style>
        <div class="row d-flex justify-content-center">
            <img src="${fanfic.getImage()}" class="img-bg">
            <img src="${fanfic.getImage()}" class="img-fluid rounded-lg" style="position: absolute;">
        </div>
        <div class="row d-flex justify-content-center mt-3">
            <div class="col-sm"></div>
        <div class="col-sm">
            <div class="row d-flex justify-content-center">
            <h1>${fanfic.getTitle()}</h1>
            </div>
        </div>
        <div class="col-sm">
            <#if edit??>
                <a href="/fanfic/${fanfic.id}/edit" class="btn btn-outline-primary" >Edit Fanfic</a>
            </#if>
        </div>
        </div>
    <div class="row d-flex justify-content-center mt-3">
    <div class="container" style="width: 45rem">
        ${fanfic.description}
        </div>
    </div>
    <div class="row d-flex justify-content-center mt-3">
    <div class="container" style="width: 45rem">
        <h5>Genre:
            <div class="badge badge-primary text-wrap">
                ${fanfic.getGenre().name()}
            </div>
        </h5>
    </div>
    </div>
    <div class="row d-flex justify-content-center mt-3">
        <div class="container" style="width: 45rem">
        <h5>Tags:<#list fanfic.tag as tag>
            <div class="badge badge-secondary text-wrap">${tag}</div><#sep>
        </#list>
        </h5>
    </div>
    </div>
    <div class="row d-flex justify-content-center mt-3">
    <div class="container" style="width: 45rem">
        <h5>Author: <a class="badge badge-danger text-wrap" href="/user/${fanfic.user.username}">${fanfic.user.username}</a></h5>
    </div>
    </div>
    <div class="row d-flex justify-content-center mt-3">
        <h2>Chapters</h2>
    </div>
    <div class="row d-flex justify-content-center">
    <div class="container" style="width: 45rem">
    <table id="sort" class="table table-striped table-hover table-borderless">
        <thead>
        <tr>
            <th scope="col" style="width: 30rem"></th>
            <#if edit??><th scope="col" ></th></#if>
        </tr>
        </thead>
        <tbody>
        <#list fanfic.getChapters() as chapter>
            <tr>
                <th scope="row"><a class="text-primary" href="/fanfic/${fanfic.id}/chapter/${chapter.id}"><h5>${chapter.title}</h5></a></th>
                <#if edit??>
                <td>
                            <a href="/fanfic/${fanfic.id}/chapter/${chapter.id}/edit" class="btn btn-outline-primary mr-2" style="width: 5rem">Edit</a>
                            <a href="/fanfic/${fanfic.id}/chapter/${chapter.id}/delete" class="btn btn-outline-danger"style="width: 5rem">Delete</a>
                </td>
                </#if>
            </tr>
        </#list>
        </tbody>
    </table>
    </div>
    </div>
    <#if edit??>
    <div class="row d-flex justify-content-center">
        <a href="/fanfic/${fanfic.id}/chapter/new" class="btn btn-primary mb-3"  style="width: 10rem">Add Chapter</a>
    </div>
    </#if>
</@common.page>