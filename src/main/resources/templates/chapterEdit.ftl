<#import "parts/common.ftl" as common>
<@common.page>
    <div class="row d-flex justify-content-center">
        <h1>Edit Chapter</h1>
    </div>
        <form class="mt-3" method="post" enctype="multipart/form-data">
            <div class="row d-flex justify-content-center">
                <input type="file" class="custom-file-input" id="validatedCustomFile" value="${chapter.image}" name="image" accept="image/*" style="width: 15rem; position: fixed">
                <label  for="validatedCustomFile" class="custom-file-label" style="width: 15rem;position: relative;">Cover</label>
            </div>
            <div class="row d-flex justify-content-center">
                <input required pattern="(^\w.*)" type="text" class="form-control mb-3" value="${chapter.title}" name="title" style="width: 15rem">
            </div>
            <div class="row d-flex justify-content-center">
                <textarea id="autosize-textarea" type="text" class="form-control mb-3" name="text" style="width: 50rem;">${chapter.text}</textarea>
            </div>
            <div class="row d-flex justify-content-center">
                <button class="btn btn-lg btn-primary btn-block mb-3" type="submit" style="width: 10rem">Save</button>
            </div>
        </form>
    </div>
    <script src="/js/autosize.js"></script>
    <script>
        autosize(document.getElementById('autosize-textarea'));
    </script>
</@common.page>