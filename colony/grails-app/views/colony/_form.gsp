<%@ page import="colony.Colony" %>



<div class="fieldcontain ${hasErrors(bean: colonyInstance, field: 'created', 'error')} ">
	<label for="created">
		<g:message code="colony.created.label" default="Created" />
		
	</label>
	<g:datePicker name="created" precision="day"  value="${colonyInstance?.created}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: colonyInstance, field: 'open', 'error')} ">
	<label for="open">
		<g:message code="colony.open.label" default="Open" />
		
	</label>
	<g:checkBox name="open" value="${colonyInstance?.open}" />
</div>

<div class="fieldcontain ${hasErrors(bean: colonyInstance, field: 'contributors', 'error')} ">
	<label for="contributors">
		<g:message code="colony.contributors.label" default="Contributors" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${colonyInstance?.contributors?}" var="c">
    <li><g:link controller="member" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="member" action="create" params="['colony.id': colonyInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'member.label', default: 'Member')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: colonyInstance, field: 'entries', 'error')} ">
	<label for="entries">
		<g:message code="colony.entries.label" default="Entries" />
		
	</label>
	<g:select name="entries" from="${colony.Entry.list()}" multiple="multiple" optionKey="id" size="5" value="${colonyInstance?.entries*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: colonyInstance, field: 'followers', 'error')} ">
	<label for="followers">
		<g:message code="colony.followers.label" default="Followers" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${colonyInstance?.followers?}" var="f">
    <li><g:link controller="member" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="member" action="create" params="['colony.id': colonyInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'member.label', default: 'Member')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: colonyInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="colony.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${colonyInstance?.name}"/>
</div>

