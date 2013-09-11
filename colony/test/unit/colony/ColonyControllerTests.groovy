package colony



import org.junit.*
import grails.test.mixin.*

@TestFor(ColonyController)
@Mock(Colony)
class ColonyControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/colony/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.colonyInstanceList.size() == 0
        assert model.colonyInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.colonyInstance != null
    }

    void testSave() {
        controller.save()

        assert model.colonyInstance != null
        assert view == '/colony/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/colony/show/1'
        assert controller.flash.message != null
        assert Colony.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/colony/list'

        populateValidParams(params)
        def colony = new Colony(params)

        assert colony.save() != null

        params.id = colony.id

        def model = controller.show()

        assert model.colonyInstance == colony
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/colony/list'

        populateValidParams(params)
        def colony = new Colony(params)

        assert colony.save() != null

        params.id = colony.id

        def model = controller.edit()

        assert model.colonyInstance == colony
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/colony/list'

        response.reset()

        populateValidParams(params)
        def colony = new Colony(params)

        assert colony.save() != null

        // test invalid parameters in update
        params.id = colony.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/colony/edit"
        assert model.colonyInstance != null

        colony.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/colony/show/$colony.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        colony.clearErrors()

        populateValidParams(params)
        params.id = colony.id
        params.version = -1
        controller.update()

        assert view == "/colony/edit"
        assert model.colonyInstance != null
        assert model.colonyInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/colony/list'

        response.reset()

        populateValidParams(params)
        def colony = new Colony(params)

        assert colony.save() != null
        assert Colony.count() == 1

        params.id = colony.id

        controller.delete()

        assert Colony.count() == 0
        assert Colony.get(colony.id) == null
        assert response.redirectedUrl == '/colony/list'
    }
}
