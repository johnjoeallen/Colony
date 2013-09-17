<%@ page import="colony.NewPost" %>


<div class="fieldcontain ${hasErrors(bean: NewPostInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="NewPost.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${NewPostInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: NewPostInstance, field: 'content', 'error')} ">
	<label for="content">
		<g:message code="NewPost.content.label" default="Post" />
		
	</label>
	<g:textArea name="content" value="${NewPostInstance?.content}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: NewPostInstance, field: 'colonies', 'error')} ">
	<label for="member">
		<g:message code="NewPost.colonies.label" default="Colonies" />
		
	</label>
	<g:select id="colony" name="colony.name" from="${colony.Colony.list()}" multiple="multiple" optionKey="id" size="5" optionValue="name" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: NewPostInstance, field: 'tags', 'error')} ">
	<label for="tags">
		<g:message code="NewPost.tags.label" default="Tags" />
		
	</label>
	<g:select name="tags" from="${colony.Tag.list()}" multiple="multiple" optionKey="id" size="5" value="${NewPostInstance?.tags*.id}" class="many-to-many"/>
</div>
