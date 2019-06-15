<#import "parts/common.ftl" as common>
<@common.page>
    <style>
        .img-bg{
            background: url(${chapter.image});
            width: 100%;
            filter: blur(30px) contrast(.9) brightness(.9);
        }
    </style>
        <div class="row d-flex justify-content-center">
            <img src="${chapter.getImage()}" class="img-bg">
            <img src="${chapter.getImage()}" class="img-fluid rounded-lg" style="position: absolute;">
        </div>
        <div class="row d-flex justify-content-center mt-5">
            <div class="col-sm"></div>
            <div class="col-sm">
                <div class="row d-flex justify-content-center">
                    <h1>${chapter.getTitle()}</h1>
                </div>
            </div>
        <div class="col-sm">
            <#if edit??>
                <a href="/fanfic/${chapter.fanfic.id}/chapter/${chapter.id}/edit" class="btn btn-outline-primary" >Edit Fanfic</a>
            </#if>
        </div>
        </div>
        <div class="row mt-5">
            ${chapter.getMarkdownText()}
        </div>
    <div class="row d-flex justify-content-center mt-5">
        <div class="btn-group" role="group">
            <#if previous??>
            <a href="./${previous}" class="btn btn-outline-primary" style="width: 10rem">Previous</a>
            </#if>
            <#if next??>
            <a href="./${next}" class="btn btn-outline-primary" style="width: 10rem">Next</a>
            </#if>
        </div>
    </div>

</@common.page>