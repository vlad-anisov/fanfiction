<#import "parts/common.ftl" as common>
<@common.page>
<div class="row d-flex justify-content-center mb-5">
    <h1>Main</h1>
</div>
<div class="text-center">
    <div class="container">
    <#list fanfics as fanfic>
        <div class="row d-flex justify-content-center">
            <div class="card mb-4" style="width: 27rem">
                <div class="card-body">
                    <a class="text-primary" href="/fanfic/${fanfic.id}"><h2 class="mb-3">${fanfic.title}</h2></a>
                    <div class="row d-flex justify-content-center">
                        <img src="${fanfic.getImage()}" class="img-fluid rounded-lg">
                    </div>
                    <div class="container mt-3">
                        ${fanfic.description}
                    </div>
                    <div class="container mt-3">
                        <h5>Genre:
                            <div class="badge badge-primary text-wrap">
                                ${fanfic.getGenre().name()}
                            </div>
                        </h5>
                    </div>
                    <div class="container mt-3">
                        <h6>Tags:<#list fanfic.tag as tag>
                            <div class="badge badge-secondary text-wrap">${tag}</div><#sep>
                            </#list>
                        </h6>
                    </div>
                </div>
                <div class="card-footer">
                    <small class="text-muted">
                        <a href="/fanfic/${fanfic.id}" class="btn btn-outline-primary mr-2" style="width: 5rem">Read</a>
                    </small>
                </div>
            </div>
        </div>
    </#list>
    </div>
</div>
</@common.page>
