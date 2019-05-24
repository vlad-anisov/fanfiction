<#include "security.ftl">
<nav class="navbar navbar-expand-lg navbar-light">
    <a class="navbar-brand" href="/">FanFiction</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <#if know>
            <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/">Admin panel</a>
            </li>
            </#if>
            </#if>
        </ul>
        <form class="form-inline mr-3">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-success my-2 my-sm-0" type="submit">Search</button>
        </form>
        <#if know>
        <div class="navbar-text mr-3">${name}</div>
            <form action="/logout" method="post">
                <button type="submit" class="btn btn btn-outline-primary btn-sm d-flex justify-content-center">
                    <i class="material-icons">exit_to_app</i>
                </button>
            </form>
        </#if>
    </div>
</nav>