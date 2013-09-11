package colony



import org.junit.*
import grails.test.mixin.*

@TestFor(VersionedPostController)
@Mock(VersionedPost)
class VersionedPostControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/versionedPost/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.versionedPostInstanceList.size() == 0
        assert model.versionedPostInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.versionedPostInstance != null
    }

    void testSave() {
        controller.save()

        assert model.versionedPostInstance != null
        assert view == '/versionedPost/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/versionedPost/show/1'
        assert controller.flash.message != null
        assert VersionedPost.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/versionedPost/list'

        populateValidParams(params)
        def versionedPost = new VersionedPost(params)

        assert versionedPost.save() != null

        params.id = versionedPost.id

        def model = controller.show()

        assert model.versionedPostInstance == versionedPost
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/versionedPost/list'

        populateValidParams(params)
        def versionedPost = new VersionedPost(params)

        assert versionedPost.save() != null

        params.id = versionedPost.id

        def model = controller.edit()

        assert model.versionedPostInstance == versionedPost
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/versionedPost/list'

        response.reset()

        populateValidParams(params)
        def versionedPost = new VersionedPost(params)

        assert versionedPost.save() != null

        // test invalid parameters in update
        params.id = versionedPost.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/versionedPost/edit"
        assert model.versionedPostInstance != null

        versionedPost.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/versionedPost/show/$versionedPost.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        versionedPost.clearErrors()

        populateValidParams(params)
        params.id = versionedPost.id
        params.version = -1
        controller.update()

        assert view == "/versionedPost/edit"
        assert model.versionedPostInstance != null
        assert model.versionedPostInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/versionedPost/list'

        response.reset()

        populateValidParams(params)
        def versionedPost = new VersionedPost(params)

        assert versionedPost.save() != null
        assert VersionedPost.count() == 1

        params.id = versionedPost.id

        controller.delete()

        assert VersionedPost.count() == 0
        assert VersionedPost.get(versionedPost.id) == null
        assert response.redirectedUrl == '/versionedPost/list'
    }
}
