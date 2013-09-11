<%@ page import="colony.Comment" %>



<div class="fieldcontain ${hasErrors(bean: commentInstance, field: 'member', 'error')} required">
	<label for="member">
		<g:message code="comment.member.label" default="Member" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="member" name="member.id" from="${colony.Member.list()}" optionKey="id" required="" value="${commentInstance?.member?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: commentInstance, field: 'versions', 'error')} ">
	<label for="versions">
		<g:message code="comment.versions.label" default="Versions" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${commentInstance?.versions?}" var="v">
    <li><g:link controller="versionedComment" action="show" id="${v.id}">${v?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="versionedComment" action="create" params="['comment.id': commentInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'versionedComment.label', default: 'VersionedComment')])}</g:link>
</li>
</ul>

</div>

