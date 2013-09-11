package colony

import org.springframework.dao.DataIntegrityViolationException

class VersionedCommentController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [versionedCommentInstanceList: VersionedComment.list(params), versionedCommentInstanceTotal: VersionedComment.count()]
    }

    def create() {
        [versionedCommentInstance: new VersionedComment(params)]
    }

    def save() {
        def versionedCommentInstance = new VersionedComment(params)
        if (!versionedCommentInstance.save(flush: true)) {
            render(view: "create", model: [versionedCommentInstance: versionedCommentInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'versionedComment.label', default: 'VersionedComment'), versionedCommentInstance.id])
        redirect(action: "show", id: versionedCommentInstance.id)
    }

    def show(Long id) {
        def versionedCommentInstance = VersionedComment.get(id)
        if (!versionedCommentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'versionedComment.label', default: 'VersionedComment'), id])
            redirect(action: "list")
            return
        }

        [versionedCommentInstance: versionedCommentInstance]
    }

    def edit(Long id) {
        def versionedCommentInstance = VersionedComment.get(id)
        if (!versionedCommentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'versionedComment.label', default: 'VersionedComment'), id])
            redirect(action: "list")
            return
        }

        [versionedCommentInstance: versionedCommentInstance]
    }

    def update(Long id, Long version) {
        def versionedCommentInstance = VersionedComment.get(id)
        if (!versionedCommentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'versionedComment.label', default: 'VersionedComment'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (versionedCommentInstance.version > version) {
                versionedCommentInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'versionedComment.label', default: 'VersionedComment')] as Object[],
                          "Another user has updated this VersionedComment while you were editing")
                render(view: "edit", model: [versionedCommentInstance: versionedCommentInstance])
                return
            }
        }

        versionedCommentInstance.properties = params

        if (!versionedCommentInstance.save(flush: true)) {
            render(view: "edit", model: [versionedCommentInstance: versionedCommentInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'versionedComment.label', default: 'VersionedComment'), versionedCommentInstance.id])
        redirect(action: "show", id: versionedCommentInstance.id)
    }

    def delete(Long id) {
        def versionedCommentInstance = VersionedComment.get(id)
        if (!versionedCommentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'versionedComment.label', default: 'VersionedComment'), id])
            redirect(action: "list")
            return
        }

        try {
            versionedCommentInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'versionedComment.label', default: 'VersionedComment'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'versionedComment.label', default: 'VersionedComment'), id])
            redirect(action: "show", id: id)
        }
    }
}
