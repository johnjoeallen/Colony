<%@ page import="colony.Colony" %>



<div class="fieldcontain ${hasErrors(bean: colonyInstance, field: 'created', 'error')} ">
	<label for="created">
		<g:message code="colony.created.label" default="Created" />
		
	</label>
	<g:datePicker name="created" precision="day"  value="${colonyInstance?.created}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: colonyInstance, field: 'entries', 'error')} ">
	<label for="entries">
		<g:message code="colony.entries.label" default="Entries" />
		
	</label>
	<g:select name="entries" from="${colony.Entry.list()}" multiple="multiple" optionKey="id" size="5" value="${colonyInstance?.entries*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: colonyInstance, field: 'members', 'error')} ">
	<label for="members">
		<g:message code="colony.members.label" default="Members" />
		
	</label>
	<g:select name="members" from="${colony.Member.list()}" multiple="multiple" optionKey="id" size="5" value="${colonyInstance?.members*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: colonyInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="colony.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${colonyInstance?.name}"/>
</div>

