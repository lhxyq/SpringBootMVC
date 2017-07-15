<#macro text id="" name="" type="text" label="" labelCss="" textCss="" componetCss="" placeholder="" required="" equalTo="">
    <div class="form-group">
        <label for="${id}" class="${labelCss}">${label}</label>
        <div class="${textCss}">
            <input id="${id}" type="${type}" class="form-control ${componetCss}" placeholder="${placeholder}" required="${required}" equalTo="${equalTo}">
        </div>
        <div class="text-left"></div>
    </div>
</#macro>