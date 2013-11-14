package colony



import org.junit.*
import grails.test.mixin.*

@TestFor(ContributorController)
@Mock(Contributor)
class ContributorControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/contributor/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.contributorInstanceList.size() == 0
        assert model.contributorInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.contributorInstance != null
    }

    void testSave() {
        controller.save()

        assert model.contributorInstance != null
        assert view == '/contributor/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/contributor/show/1'
        assert controller.flash.message != null
        assert Contributor.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/contributor/list'

        populateValidParams(params)
        def contributor = new Contributor(params)

        assert contributor.save() != null

        params.id = contributor.id

        def model = controller.show()

        assert model.contributorInstance == contributor
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/contributor/list'

        populateValidParams(params)
        def contributor = new Contributor(params)

        assert contributor.save() != null

        params.id = contributor.id

        def model = controller.edit()

        assert model.contributorInstance == contributor
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/contributor/list'

        response.reset()

        populateValidParams(params)
        def contributor = new Contributor(params)

        assert contributor.save() != null

        // test invalid parameters in update
        params.id = contributor.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/contributor/edit"
        assert model.contributorInstance != null

        contributor.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/contributor/show/$contributor.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        contributor.clearErrors()

        populateValidParams(params)
        params.id = contributor.id
        params.version = -1
        controller.update()

        assert view == "/contributor/edit"
        assert model.contributorInstance != null
        assert model.contributorInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/contributor/list'

        response.reset()

        populateValidParams(params)
        def contributor = new Contributor(params)

        assert contributor.save() != null
        assert Contributor.count() == 1

        params.id = contributor.id

        controller.delete()

        assert Contributor.count() == 0
        assert Contributor.get(contributor.id) == null
        assert response.redirectedUrl == '/contributor/list'
    }
}
