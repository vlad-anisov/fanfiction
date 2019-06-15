<#import "parts/common.ftl" as common>
<@common.page>
    <div class="row d-flex justify-content-center">
        <h1>Add Chapter</h1>
    </div>
        <form class="mt-3 was-validated " method="post" enctype="multipart/form-data">
            <div class="row d-flex justify-content-center" >
                <input type="file" class="custom-file-input" id="validatedCustomFile" required name="image" accept="image/*" style="position: fixed">
                <label  for="validatedCustomFile" class="custom-file-label" style="width: 20rem;position: relative;">Cover</label>
            </div>
            <div class="row d-flex justify-content-center">
                <input required pattern="(^\w.*)" type="text" class="form-control mb-3" placeholder="Title" name="title" style="width: 20rem">
            </div>
            <div class="row d-flex justify-content-center">
                <textarea id="autosize-textarea" type="text" class="form-control mb-3" placeholder="Text" name="text" style="width: 45rem;"></textarea>
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