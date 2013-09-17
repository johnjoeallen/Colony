<%@ page import="colony.Entry" %>



<div class="fieldcontain ${hasErrors(bean: entryInstance, field: 'created', 'error')} required">
	<label for="created">
		<g:message code="entry.created.label" default="Created" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="created" precision="day"  value="${entryInstance?.created}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: entryInstance, field: 'post', 'error')} required">
	<label for="post">
		<g:message code="entry.post.label" default="Post" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="post" name="post.id" from="${colony.Post.list()}" optionKey="id" required="" value="${entryInstance?.post?.id}" class="many-to-one"/>
</div>

