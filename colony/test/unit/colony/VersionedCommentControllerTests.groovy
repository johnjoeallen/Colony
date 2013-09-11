package colony



import org.junit.*
import grails.test.mixin.*

@TestFor(VersionedCommentController)
@Mock(VersionedComment)
class VersionedCommentControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/versionedComment/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.versionedCommentInstanceList.size() == 0
        assert model.versionedCommentInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.versionedCommentInstance != null
    }

    void testSave() {
        controller.save()

        assert model.versionedCommentInstance != null
        assert view == '/versionedComment/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/versionedComment/show/1'
        assert controller.flash.message != null
        assert VersionedComment.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/versionedComment/list'

        populateValidParams(params)
        def versionedComment = new VersionedComment(params)

        assert versionedComment.save() != null

        params.id = versionedComment.id

        def model = controller.show()

        assert model.versionedCommentInstance == versionedComment
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/versionedComment/list'

        populateValidParams(params)
        def versionedComment = new VersionedComment(params)

        assert versionedComment.save() != null

        params.id = versionedComment.id

        def model = controller.edit()

        assert model.versionedCommentInstance == versionedComment
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/versionedComment/list'

        response.reset()

        populateValidParams(params)
        def versionedComment = new VersionedComment(params)

        assert versionedComment.save() != null

        // test invalid parameters in update
        params.id = versionedComment.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/versionedComment/edit"
        assert model.versionedCommentInstance != null

        versionedComment.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/versionedComment/show/$versionedComment.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        versionedComment.clearErrors()

        populateValidParams(params)
        params.id = versionedComment.id
        params.version = -1
        controller.update()

        assert view == "/versionedComment/edit"
        assert model.versionedCommentInstance != null
        assert model.versionedCommentInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/versionedComment/list'

        response.reset()

        populateValidParams(params)
        def versionedComment = new VersionedComment(params)

        assert versionedComment.save() != null
        assert VersionedComment.count() == 1

        params.id = versionedComment.id

        controller.delete()

        assert VersionedComment.count() == 0
        assert VersionedComment.get(versionedComment.id) == null
        assert response.redirectedUrl == '/versionedComment/list'
    }
}
