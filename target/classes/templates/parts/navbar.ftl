<#include "security.ftl">
<nav class="navbar navbar-expand-lg">
    <a class="navbar-brand" href="/">FanFiction</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <#if isAdmin?ifExists>
                <li class="nav-item mr-3">
                    <a class="nav-link" href="/admin">Admin panel</a>
                </li>
            </#if>
        </ul>
        <#if know>
            <a href="/fanfic/new" class="btn btn-outline-primary mr-3" >New Fanfic</a>
        <div class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" id="navbarDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                ${name}
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="/user/${name}">Profile</a>
                <a class="dropdown-item" href="/user/${name}/edit">Settings</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="/logout">Exit</a>
            </div>
        </div>
            <#else>
                <a href="/login" class="btn btn-outline-primary mr-3" >Login</a>
        </#if>
    </div>
</nav>