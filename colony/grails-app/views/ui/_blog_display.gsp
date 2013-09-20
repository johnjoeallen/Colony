<div class="posts">
	<h2>${current.title} 
		<g:if test="${member != null && post.members.get(member) != null}">
			<a href="editPost/${post.id}"><img src="images/document_edit.png" width="16px" height="16px"/></a>
		</g:if>
	</h2>
	<span 
		class="posts author title">
			${post.members.collect { k, v -> 
				"<a href=\"@${v.nickName}\">${v.displayName}</a>" }.join(", ")} 
				in 
				${post.colonies.collect { k, v ->
					def html = "<a href=\"${v.name}\">${v.name}</a>"
					if (member != null && post.members.get(member) != null) {
						html += " <a href=\"unlinkPost/${v.id}/${post.id}\"><img src=\"images/document_delete.png\" width=\"16px\" height=\"16px\"/></a>"
					}
				
					html
				}.join(", ")}
		<br/>Published ${post.created}, Updated ${current.created}
	</span>
	<div class="postbody">
		<markdown:renderHtml>${current.content}</markdown:renderHtml>
		<a href="likePost"><img src="images/like.png" width="16px" height="16px"/>Like</a> 
		<a href="unlikePost"><img src="images/unlike.png" width="16px" height="16px"/>Unlike</a>
	</div>
</div>

