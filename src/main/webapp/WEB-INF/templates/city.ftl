<div>
    <h2>Choose a city:</h2>
    <hr>
<#list city_list as c>
    <div>
        <a href="${admin_url}/city=${c.id}">${c.name}</a>
    </div>
    <hr>
<#else>
    <p>No cities!</p>
</#list>
</div>