package colony



import org.junit.*
import grails.test.mixin.*

@TestFor(TwitterMemberController)
@Mock(TwitterMember)
class TwitterMemberControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/twitterMember/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.twitterMemberInstanceList.size() == 0
        assert model.twitterMemberInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.twitterMemberInstance != null
    }

    void testSave() {
        controller.save()

        assert model.twitterMemberInstance != null
        assert view == '/twitterMember/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/twitterMember/show/1'
        assert controller.flash.message != null
        assert TwitterMember.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/twitterMember/list'

        populateValidParams(params)
        def twitterMember = new TwitterMember(params)

        assert twitterMember.save() != null

        params.id = twitterMember.id

        def model = controller.show()

        assert model.twitterMemberInstance == twitterMember
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/twitterMember/list'

        populateValidParams(params)
        def twitterMember = new TwitterMember(params)

        assert twitterMember.save() != null

        params.id = twitterMember.id

        def model = controller.edit()

        assert model.twitterMemberInstance == twitterMember
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/twitterMember/list'

        response.reset()

        populateValidParams(params)
        def twitterMember = new TwitterMember(params)

        assert twitterMember.save() != null

        // test invalid parameters in update
        params.id = twitterMember.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/twitterMember/edit"
        assert model.twitterMemberInstance != null

        twitterMember.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/twitterMember/show/$twitterMember.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        twitterMember.clearErrors()

        populateValidParams(params)
        params.id = twitterMember.id
        params.version = -1
        controller.update()

        assert view == "/twitterMember/edit"
        assert model.twitterMemberInstance != null
        assert model.twitterMemberInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/twitterMember/list'

        response.reset()

        populateValidParams(params)
        def twitterMember = new TwitterMember(params)

        assert twitterMember.save() != null
        assert TwitterMember.count() == 1

        params.id = twitterMember.id

        controller.delete()

        assert TwitterMember.count() == 0
        assert TwitterMember.get(twitterMember.id) == null
        assert response.redirectedUrl == '/twitterMember/list'
    }
}
