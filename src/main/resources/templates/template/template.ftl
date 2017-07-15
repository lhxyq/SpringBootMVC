<#macro text id="" name="" type="text" label="" labelCss="" textCss="" placeholder="" required="">
    <div class="form-group">
        <label for="${id}" class="${labelCss}">${label}</label>
        <div class="${textCss}">
            <input id="${id}" type="${type}" class="form-control" placeholder="${placeholder}" required="${required}">
        </div>
        <div class="text-left"></div>
    </div>
</#macro>