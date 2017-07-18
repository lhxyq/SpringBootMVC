<#import "/templates/master/master.ftl" as layout/>

<@layout.layout2>
<div class="font-color">

    <div class="row">
        <div class="form-group h4">
            <label class="control-label col-lg-offset-3 col-lg-2 text-right" for="">用户名</label>
            <div class="col-lg-1 text-left"><span>${users.name}</span></div>
        </div>
    </div>

    <div class="row">
        <div class="form-group h4">
            <label class="control-label col-lg-offset-3 col-lg-2 text-right" for="">密码</label>
            <div class="col-lg-1 text-left"><span>${users.password}</span></div>
        </div>
    </div>

    <div class="row">
        <div class="form-group h4">
            <label class="control-label col-lg-offset-3 col-lg-2 text-right" for="">Email</label>
            <div class="col-lg-1 text-left"><span>${users.email}</span></div>
        </div>
    </div>
</div>
</@layout.layout2>