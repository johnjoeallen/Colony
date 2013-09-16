package colony

import org.springframework.dao.DataIntegrityViolationException

class VersionedPostController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [versionedPostInstanceList: VersionedPost.list(params), versionedPostInstanceTotal: VersionedPost.count()]
    }

    def create() {
        [versionedPostInstance: new VersionedPost(params)]
    }

    def save() {
        def versionedPostInstance = new VersionedPost(params)
        if (!versionedPostInstance.save(flush: true)) {
            render(view: "create", model: [versionedPostInstance: versionedPostInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'versionedPost.label', default: 'VersionedPost'), versionedPostInstance.id])
        redirect(action: "show", id: versionedPostInstance.id)
    }

    def show(String id) {
        def versionedPostInstance = VersionedPost.get(id)
        if (!versionedPostInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'versionedPost.label', default: 'VersionedPost'), id])
            redirect(action: "list")
            return
        }

        [versionedPostInstance: versionedPostInstance]
    }

    def edit(String id) {
        def versionedPostInstance = VersionedPost.get(id)
        if (!versionedPostInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'versionedPost.label', default: 'VersionedPost'), id])
            redirect(action: "list")
            return
        }

        [versionedPostInstance: versionedPostInstance]
    }

    def update(String id, Long version) {
        def versionedPostInstance = VersionedPost.get(id)
        if (!versionedPostInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'versionedPost.label', default: 'VersionedPost'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (versionedPostInstance.version > version) {
                versionedPostInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'versionedPost.label', default: 'VersionedPost')] as Object[],
                          "Another user has updated this VersionedPost while you were editing")
                render(view: "edit", model: [versionedPostInstance: versionedPostInstance])
                return
            }
        }

        versionedPostInstance.properties = params

        if (!versionedPostInstance.save(flush: true)) {
            render(view: "edit", model: [versionedPostInstance: versionedPostInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'versionedPost.label', default: 'VersionedPost'), versionedPostInstance.id])
        redirect(action: "show", id: versionedPostInstance.id)
    }

    def delete(String id) {
        def versionedPostInstance = VersionedPost.get(id)
        if (!versionedPostInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'versionedPost.label', default: 'VersionedPost'), id])
            redirect(action: "list")
            return
        }

        try {
            versionedPostInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'versionedPost.label', default: 'VersionedPost'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'versionedPost.label', default: 'VersionedPost'), id])
            redirect(action: "show", id: id)
        }
    }
}
