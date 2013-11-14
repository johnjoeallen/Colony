package colony



import org.junit.*
import grails.test.mixin.*

@TestFor(FollowerController)
@Mock(Follower)
class FollowerControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/follower/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.followerInstanceList.size() == 0
        assert model.followerInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.followerInstance != null
    }

    void testSave() {
        controller.save()

        assert model.followerInstance != null
        assert view == '/follower/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/follower/show/1'
        assert controller.flash.message != null
        assert Follower.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/follower/list'

        populateValidParams(params)
        def follower = new Follower(params)

        assert follower.save() != null

        params.id = follower.id

        def model = controller.show()

        assert model.followerInstance == follower
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/follower/list'

        populateValidParams(params)
        def follower = new Follower(params)

        assert follower.save() != null

        params.id = follower.id

        def model = controller.edit()

        assert model.followerInstance == follower
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/follower/list'

        response.reset()

        populateValidParams(params)
        def follower = new Follower(params)

        assert follower.save() != null

        // test invalid parameters in update
        params.id = follower.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/follower/edit"
        assert model.followerInstance != null

        follower.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/follower/show/$follower.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        follower.clearErrors()

        populateValidParams(params)
        params.id = follower.id
        params.version = -1
        controller.update()

        assert view == "/follower/edit"
        assert model.followerInstance != null
        assert model.followerInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/follower/list'

        response.reset()

        populateValidParams(params)
        def follower = new Follower(params)

        assert follower.save() != null
        assert Follower.count() == 1

        params.id = follower.id

        controller.delete()

        assert Follower.count() == 0
        assert Follower.get(follower.id) == null
        assert response.redirectedUrl == '/follower/list'
    }
}
