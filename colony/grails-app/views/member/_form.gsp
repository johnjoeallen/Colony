<%@ page import="colony.Member" %>



<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'colony', 'error')} ">
	<label for="colony">
		<g:message code="member.colony.label" default="Colony" />
		
	</label>
	<g:select id="colony" name="colony.id" from="${colony.Colony.list()}" optionKey="id" value="${memberInstance?.colony?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'created', 'error')} required">
	<label for="created">
		<g:message code="member.created.label" default="Created" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="created" precision="day"  value="${memberInstance?.created}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="member.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${memberInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'stream', 'error')} ">
	<label for="stream">
		<g:message code="member.stream.label" default="Stream" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${memberInstance?.stream?}" var="s">
    <li><g:link controller="entry" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="entry" action="create" params="['member.id': memberInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'entry.label', default: 'Entry')])}</g:link>
</li>
</ul>

</div>

