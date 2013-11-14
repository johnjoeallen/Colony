<%@ page import="colony.Entry" %>



<div class="fieldcontain ${hasErrors(bean: entryInstance, field: 'content', 'error')} ">
	<label for="content">
		<g:message code="entry.content.label" default="Content" />
		
	</label>
	<g:textField name="content" value="${entryInstance?.content}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: entryInstance, field: 'owner', 'error')} required">
	<label for="owner">
		<g:message code="entry.owner.label" default="Owner" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="owner" name="owner.id" from="${colony.Member.list()}" optionKey="id" required="" value="${entryInstance?.owner?.id}" class="many-to-one"/>
</div>

