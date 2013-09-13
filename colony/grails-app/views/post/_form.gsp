<%@ page import="colony.Post" %>



<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'type', 'error')} ">
	<label for="type">
		<g:message code="post.type.label" default="Type" />
		
	</label>
	<g:textField name="type" value="${postInstance?.type}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'current', 'error')} required">
	<label for="current">
		<g:message code="post.current.label" default="Current" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="current" name="current.id" from="${colony.VersionedPost.list()}" optionKey="id" required="" value="${postInstance?.current?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'member', 'error')} required">
	<label for="member">
		<g:message code="post.member.label" default="Member" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="member" name="member.id" from="${colony.Member.list()}" optionKey="id" required="" value="${postInstance?.member?.id}" class="many-to-one"/>
</div>

