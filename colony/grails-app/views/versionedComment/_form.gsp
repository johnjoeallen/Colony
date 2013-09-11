<%@ page import="colony.VersionedComment" %>



<div class="fieldcontain ${hasErrors(bean: versionedCommentInstance, field: 'content', 'error')} ">
	<label for="content">
		<g:message code="versionedComment.content.label" default="Content" />
		
	</label>
	<g:textField name="content" value="${versionedCommentInstance?.content}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: versionedCommentInstance, field: 'created', 'error')} required">
	<label for="created">
		<g:message code="versionedComment.created.label" default="Created" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="created" precision="day"  value="${versionedCommentInstance?.created}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: versionedCommentInstance, field: 'previous', 'error')} ">
	<label for="previous">
		<g:message code="versionedComment.previous.label" default="Previous" />
		
	</label>
	<g:select id="previous" name="previous.id" from="${colony.VersionedComment.list()}" optionKey="id" value="${versionedCommentInstance?.previous?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: versionedCommentInstance, field: 'comment', 'error')} required">
	<label for="comment">
		<g:message code="versionedComment.comment.label" default="Comment" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="comment" name="comment.id" from="${colony.Comment.list()}" optionKey="id" required="" value="${versionedCommentInstance?.comment?.id}" class="many-to-one"/>
</div>

