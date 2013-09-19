<%@ page import="colony.UIPost" %>

<style>
	.postbody textarea { height: 400px; }
</style>

<g:hiddenField name="id" value="${postInstance.id}" />

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="UIPost.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${postInstance?.title}"/>
</div>

<div class="postbody ${hasErrors(bean: postInstance, field: 'content', 'error')} ">
	<label for="content">
		<g:message code="UIPost.content.label" default="Post" />
		
	</label>
	<g:textArea name="content" rows="50" cols="80" value="${postInstance?.content}"/>
</div>

<g:if test="${postInstance.id == null}">
<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'colonies', 'error')} ">
	<label for="member">
		<g:message code="UIPost.colonies.label" default="Colonies" />
		
	</label>
	<g:select id="colony" name="colonies.id" from="${colony.Colony.list()}" multiple="multiple" optionKey="id" size="5" optionValue="name" class="many-to-many"/>
</div>
</g:if>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'tags', 'error')} ">
	<label for="tags">
		<g:message code="UIPost.tags.label" default="Tags" />
		
	</label>
	<g:textField name="tags" value="${postInstance.tags}"/>
</div>
