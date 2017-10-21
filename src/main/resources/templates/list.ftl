<ul>
<#list fruits as fruit>
<li>${fruit}
</#list>
</ul>

如果是对null的list进行迭代需要用if提前判断
<#if nullFruits??>
<ul>
    <#list nullFruits as fruit>
    <li>${fruit}
</#list>
</ul>
</#if>

对empty的list进行迭代不需要if提前判断
<ul>
<#list emptyFruits as fruit>
<li>${fruit}
</#list>
</ul>
使用items 如果list为空ul也不会输出
<#list emptyFruits>
<ul>
    <#items as fruit>
    <li>${fruit}
    </#items>
</ul>
</#list>
加分隔符，最后一个不加
<p>Fruits: <#list fruits as fruit>${fruit}<#sep>,</#sep></#list>
<p>Fruits: <#list emptyFruits as fruit>${fruit}<#sep>,<#else>None </#list>