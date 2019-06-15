<#import "parts/common.ftl" as common>
<#include "parts/security.ftl">
<@common.page>
        <div class="col-md-12 lead mb-5" align="center"><h1>User profile</h1></div>
        <div class="text-center mb-3">
            <div class="row d-flex justify-content-center mb-5">
                <div class="col-sm">
                </div>
                <div class="col-sm">
                    <h2>${userProfile.username}</h2>
                </div>
                <div class="col-sm">
                    <#if edit??>
                    <a href="/user/${userProfile.username}/edit" class="btn btn-outline-primary" >Edit Profile</a>
                    </#if>
                </div>
            </div>
            <div class="container">
            <#list userProfile.fanfics as fanfic>
            <div class="row d-flex justify-content-center">
                <div class="card mb-4" style="width: 27rem">
                    <div class="card-body">
                        <a class="text-primary" href="/fanfic/${fanfic.id}"><h5 class="mb-3">${fanfic.title}</h5></a>
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
                            <#if edit??>
                            <a href="/fanfic/${fanfic.id}/edit" class="btn btn-outline-success mr-2" style="width: 5rem">Edit</a>
                            <a href="/fanfic/${fanfic.id}/delete" class="btn btn-outline-danger" style="width: 5rem">Delete</a>
                            </#if>
                        </small>
                    </div>
                </div>
            </div>
            </#list>
        </div>
            <#if edit??>
                <div class="row d-flex justify-content-center">
                    <a href="/fanfic/${userProfile.username}/new" class="btn btn-primary mb-3"  style="width: 10rem">Add Fanfic</a>
                </div>
            </#if>
        </div>
</@common.page>