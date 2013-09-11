<%@ page import="colony.Post" %>



<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'member', 'error')} required">
	<label for="member">
		<g:message code="post.member.label" default="Member" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="member" name="member.id" from="${colony.Member.list()}" optionKey="id" required="" value="${postInstance?.member?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'versions', 'error')} ">
	<label for="versions">
		<g:message code="post.versions.label" default="Versions" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${postInstance?.versions?}" var="v">
    <li><g:link controller="versionedPost" action="show" id="${v.id}">${v?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="versionedPost" action="create" params="['post.id': postInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'versionedPost.label', default: 'VersionedPost')])}</g:link>
</li>
</ul>

</div>

