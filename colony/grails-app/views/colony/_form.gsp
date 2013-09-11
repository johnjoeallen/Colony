<%@ page import="colony.Colony" %>



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

<div class="fieldcontain ${hasErrors(bean: colonyInstance, field: 'posts', 'error')} ">
	<label for="posts">
		<g:message code="colony.posts.label" default="Posts" />
		
	</label>
	<g:select name="posts" from="${colony.Post.list()}" multiple="multiple" optionKey="id" size="5" value="${colonyInstance?.posts*.id}" class="many-to-many"/>
</div>

