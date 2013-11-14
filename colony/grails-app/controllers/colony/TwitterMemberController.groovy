package colony

import org.springframework.dao.DataIntegrityViolationException

class TwitterMemberController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [twitterMemberInstanceList: TwitterMember.list(params), twitterMemberInstanceTotal: TwitterMember.count()]
    }

    def create() {
        [twitterMemberInstance: new TwitterMember(params)]
    }

    def save() {
        def twitterMemberInstance = new TwitterMember(params)
        if (!twitterMemberInstance.save(flush: true)) {
            render(view: "create", model: [twitterMemberInstance: twitterMemberInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'twitterMember.label', default: 'TwitterMember'), twitterMemberInstance.id])
        redirect(action: "show", id: twitterMemberInstance.id)
    }

    def show(String id) {
        def twitterMemberInstance = TwitterMember.get(id)
        if (!twitterMemberInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'twitterMember.label', default: 'TwitterMember'), id])
            redirect(action: "list")
            return
        }

        [twitterMemberInstance: twitterMemberInstance]
    }

    def edit(String id) {
        def twitterMemberInstance = TwitterMember.get(id)
        if (!twitterMemberInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'twitterMember.label', default: 'TwitterMember'), id])
            redirect(action: "list")
            return
        }

        [twitterMemberInstance: twitterMemberInstance]
    }

    def update(String id, Long version) {
        def twitterMemberInstance = TwitterMember.get(id)
        if (!twitterMemberInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'twitterMember.label', default: 'TwitterMember'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (twitterMemberInstance.version > version) {
                twitterMemberInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'twitterMember.label', default: 'TwitterMember')] as Object[],
                          "Another user has updated this TwitterMember while you were editing")
                render(view: "edit", model: [twitterMemberInstance: twitterMemberInstance])
                return
            }
        }

        twitterMemberInstance.properties = params

        if (!twitterMemberInstance.save(flush: true)) {
            render(view: "edit", model: [twitterMemberInstance: twitterMemberInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'twitterMember.label', default: 'TwitterMember'), twitterMemberInstance.id])
        redirect(action: "show", id: twitterMemberInstance.id)
    }

    def delete(String id) {
        def twitterMemberInstance = TwitterMember.get(id)
        if (!twitterMemberInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'twitterMember.label', default: 'TwitterMember'), id])
            redirect(action: "list")
            return
        }

        try {
            twitterMemberInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'twitterMember.label', default: 'TwitterMember'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'twitterMember.label', default: 'TwitterMember'), id])
            redirect(action: "show", id: id)
        }
    }
}
