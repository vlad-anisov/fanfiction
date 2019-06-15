<#import "parts/common.ftl" as common>
<@common.page>
    <div class="row d-flex justify-content-center">
        <h1>Edit Fanfic</h1>
    </div>
        <form class="mt-3 was-validated" method="post" enctype="multipart/form-data">
            <div class="row d-flex justify-content-center">
                <input value="${fanfic.title}" required pattern="(^\w.*)" type="text" class="form-control mb-3" placeholder="Title" name="title" style="width: 20rem">
            </div>
            <div class="row d-flex justify-content-center">
                <textarea class="autosize-textarea form-control mb-3" required pattern="(^\w.*)" type="text" placeholder="Description" name="description" style="width: 45rem">${fanfic.description}</textarea>
            </div>
            <div class="row d-flex justify-content-center mb-2">
                <div class="input-group" style="width: 20rem">
                    <select required class="custom-select" id="inputGroupSelect02" name="genre">
                        <option value="Action" <#if genre == "Action">selected</#if>>Action</option>
                        <option value="Adventure" <#if genre == "Adventure">selected</#if>>Adventure</option>
                        <option value="Anime" <#if genre == "Anime">selected</#if>>Anime</option>
                        <option value="Fantasy" <#if genre == "Fantasy">selected</#if>>Fantasy</option>
                        <option value="Romance" <#if genre == "Romance">selected</#if>>Romance</option>
                        <option value="Thriller" <#if genre == "Thriller">selected</#if>>Thriller</option>
                        <option value="Horror" <#if genre == "Horror">selected</#if>>Horror</option>
                        <option value="Humor" <#if genre == "Humor">selected</#if>>Humor</option>
                    </select>
                    <div class="input-group-append">
                        <label class="input-group-text" for="inputGroupSelect02">Genre</label>
                    </div>
                </div>
            </div>
            <div class="row d-flex justify-content-center">
                <label>Please enter tags, separated by commas</label>
            </div>
            <div class="row d-flex justify-content-center">
                <textarea class="autosize-textarea form-control mb-3" required pattern="(^\w.*)" type="text" placeholder="Tag" name="tag" style="width: 20rem"><#list fanfic.tag as tag>${tag}<#sep>, </#list></textarea>
            </div>
            <div class="row d-flex justify-content-center">
                <div class="custom-file mb-3" style="width: 20rem">
                <input type="file" class="custom-file-input" id="validatedCustomFile" name="image" accept="image/*">
                <label class="custom-file-label" for="validatedCustomFile">Cover</label>
                </div>
            </div>
            <div class="row d-flex justify-content-center">
            <button class="btn btn-lg btn-primary btn-block mb-3" type="submit" style="width: 10rem">Save</button>
            </div>
        </form>
    </div>
    <script src="/js/autosize.js"></script>
    <script>
        autosize(document.getElementsByClassName('autosize-textarea'));
    </script>
</@common.page>