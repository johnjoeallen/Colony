<%@ page import="colony.VersionedPost" %>



<div class="fieldcontain ${hasErrors(bean: versionedPostInstance, field: 'content', 'error')} ">
	<label for="content">
		<g:message code="versionedPost.content.label" default="Content" />
		
	</label>
	<g:textArea name="content" value="${versionedPostInstance?.content}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: versionedPostInstance, field: 'created', 'error')} required">
	<label for="created">
		<g:message code="versionedPost.created.label" default="Created" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="created" precision="day"  value="${versionedPostInstance?.created}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: versionedPostInstance, field: 'previous', 'error')} ">
	<label for="previous">
		<g:message code="versionedPost.previous.label" default="Previous" />
		
	</label>
	<g:select id="previous" name="previous.id" from="${colony.VersionedPost.list()}" optionKey="id" value="${versionedPostInstance?.previous?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: versionedPostInstance, field: 'member', 'error')} ">
	<label for="member">
		<g:message code="versionedPost.member.label" default="Member" />
		
	</label>
	<g:select id="member" name="member.id" from="${colony.Member.list()}" optionKey="id" value="${versionedPostInstance?.member?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: versionedPostInstance, field: 'comments', 'error')} ">
	<label for="comments">
		<g:message code="versionedPost.comments.label" default="Comments" />
		
	</label>
	<g:select name="comments" from="${colony.Comment.list()}" multiple="multiple" optionKey="id" size="5" value="${versionedPostInstance?.comments*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: versionedPostInstance, field: 'tags', 'error')} ">
	<label for="tags">
		<g:message code="versionedPost.tags.label" default="Tags" />
		
	</label>
	<g:select name="tags" from="${colony.Tag.list()}" multiple="multiple" optionKey="id" size="5" value="${versionedPostInstance?.tags*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: versionedPostInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="versionedPost.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${versionedPostInstance?.title}"/>
</div>

