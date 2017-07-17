<#import "/templates/master/master.ftl" as layout/>

<@layout.layout>
<div class="container-fluid text-center form-horizontal">
    <div class="row">
        <div class="form-group h4">
            <label class="control-label col-lg-3" for="">用户名</label>
            <div class="col-lg-5"><span>${users.name}</span></div>
        </div>
    </div>

    <div class="row">
        <div class="form-group h4">
            <label class="control-label col-lg-3" for="">密码</label>
            <div class="col-lg-5"><span>${users.password}</span></div>
        </div>
    </div>

    <div class="row">
        <div class="form-group h4">
            <label class="control-label col-lg-3" for="">Email</label>
            <div class="col-lg-5"><span>${users.email}</span></div>
        </div>
    </div>
</div>
</@layout.layout>