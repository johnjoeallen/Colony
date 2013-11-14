package colony



import org.junit.*
import grails.test.mixin.*

@TestFor(SubscriberController)
@Mock(Member)
class SubscriberControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/subscriber/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.subscriberInstanceList.size() == 0
        assert model.subscriberInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.subscriberInstance != null
    }

    void testSave() {
        controller.save()

        assert model.subscriberInstance != null
        assert view == '/subscriber/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/subscriber/show/1'
        assert controller.flash.message != null
        assert Member.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/subscriber/list'

        populateValidParams(params)
        def subscriber = new Member(params)

        assert subscriber.save() != null

        params.id = subscriber.id

        def model = controller.show()

        assert model.subscriberInstance == subscriber
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/subscriber/list'

        populateValidParams(params)
        def subscriber = new Member(params)

        assert subscriber.save() != null

        params.id = subscriber.id

        def model = controller.edit()

        assert model.subscriberInstance == subscriber
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/subscriber/list'

        response.reset()

        populateValidParams(params)
        def subscriber = new Member(params)

        assert subscriber.save() != null

        // test invalid parameters in update
        params.id = subscriber.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/subscriber/edit"
        assert model.subscriberInstance != null

        subscriber.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/subscriber/show/$subscriber.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        subscriber.clearErrors()

        populateValidParams(params)
        params.id = subscriber.id
        params.version = -1
        controller.update()

        assert view == "/subscriber/edit"
        assert model.subscriberInstance != null
        assert model.subscriberInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/subscriber/list'

        response.reset()

        populateValidParams(params)
        def subscriber = new Member(params)

        assert subscriber.save() != null
        assert Member.count() == 1

        params.id = subscriber.id

        controller.delete()

        assert Member.count() == 0
        assert Member.get(subscriber.id) == null
        assert response.redirectedUrl == '/subscriber/list'
    }
}
