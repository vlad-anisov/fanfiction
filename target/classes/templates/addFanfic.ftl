<#import "parts/common.ftl" as common>
<@common.page>
    <div class="row d-flex justify-content-center">
        <h1>Add Fanfic</h1>
    </div>
        <form class="mt-3 was-validated" method="post" enctype="multipart/form-data">
            <div class="row d-flex justify-content-center">
                <input required pattern="(^\w.*)" type="text" class="form-control mb-3" placeholder="Title" name="title" style="width: 20rem">
            </div>
            <div class="row d-flex justify-content-center">
                <textarea class="autosize-textarea form-control mb-3" required pattern="(^\w.*)" type="text" placeholder="Description" name="description" style="width: 45rem"></textarea>
            </div>
            <div class="row d-flex justify-content-center mb-2">
                <div class="input-group" style="width: 20rem">
                    <select required class="custom-select" id="inputGroupSelect02" name="genre">
                        <option value="Action">Action</option>
                        <option value="Adventure">Adventure</option>
                        <option value="Anime">Anime</option>
                        <option value="Fantasy">Fantasy</option>
                        <option value="Romance">Romance</option>
                        <option value="Thriller">Thriller</option>
                        <option value="Horror">Horror</option>
                        <option value="Humor">Humor</option>
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
                <textarea class="autosize-textarea form-control mb-3" required pattern="(^\w.*)" type="text" placeholder="Tag" name="tag" style="width: 20rem"></textarea>
            </div>
            <div class="row d-flex justify-content-center">
                <div class="custom-file mb-3" style="width: 20rem">
                <input type="file" class="custom-file-input" id="validatedCustomFile" required name="image" accept="image/*">
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