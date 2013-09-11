package colony

import org.springframework.dao.DataIntegrityViolationException

class ColonyController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [colonyInstanceList: Colony.list(params), colonyInstanceTotal: Colony.count()]
    }

    def create() {
        [colonyInstance: new Colony(params)]
    }

    def save() {
        def colonyInstance = new Colony(params)
        if (!colonyInstance.save(flush: true)) {
            render(view: "create", model: [colonyInstance: colonyInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'colony.label', default: 'Colony'), colonyInstance.id])
        redirect(action: "show", id: colonyInstance.id)
    }

    def show(Long id) {
        def colonyInstance = Colony.get(id)
        if (!colonyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'colony.label', default: 'Colony'), id])
            redirect(action: "list")
            return
        }

        [colonyInstance: colonyInstance]
    }

    def edit(Long id) {
        def colonyInstance = Colony.get(id)
        if (!colonyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'colony.label', default: 'Colony'), id])
            redirect(action: "list")
            return
        }

        [colonyInstance: colonyInstance]
    }

    def update(Long id, Long version) {
        def colonyInstance = Colony.get(id)
        if (!colonyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'colony.label', default: 'Colony'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (colonyInstance.version > version) {
                colonyInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'colony.label', default: 'Colony')] as Object[],
                          "Another user has updated this Colony while you were editing")
                render(view: "edit", model: [colonyInstance: colonyInstance])
                return
            }
        }

        colonyInstance.properties = params

        if (!colonyInstance.save(flush: true)) {
            render(view: "edit", model: [colonyInstance: colonyInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'colony.label', default: 'Colony'), colonyInstance.id])
        redirect(action: "show", id: colonyInstance.id)
    }

    def delete(Long id) {
        def colonyInstance = Colony.get(id)
        if (!colonyInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'colony.label', default: 'Colony'), id])
            redirect(action: "list")
            return
        }

        try {
            colonyInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'colony.label', default: 'Colony'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'colony.label', default: 'Colony'), id])
            redirect(action: "show", id: id)
        }
    }
}
