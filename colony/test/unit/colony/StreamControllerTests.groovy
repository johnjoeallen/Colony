package colony



import org.junit.*
import grails.test.mixin.*

@TestFor(StreamController)
@Mock(Stream)
class StreamControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/stream/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.streamInstanceList.size() == 0
        assert model.streamInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.streamInstance != null
    }

    void testSave() {
        controller.save()

        assert model.streamInstance != null
        assert view == '/stream/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/stream/show/1'
        assert controller.flash.message != null
        assert Stream.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/stream/list'

        populateValidParams(params)
        def stream = new Stream(params)

        assert stream.save() != null

        params.id = stream.id

        def model = controller.show()

        assert model.streamInstance == stream
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/stream/list'

        populateValidParams(params)
        def stream = new Stream(params)

        assert stream.save() != null

        params.id = stream.id

        def model = controller.edit()

        assert model.streamInstance == stream
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/stream/list'

        response.reset()

        populateValidParams(params)
        def stream = new Stream(params)

        assert stream.save() != null

        // test invalid parameters in update
        params.id = stream.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/stream/edit"
        assert model.streamInstance != null

        stream.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/stream/show/$stream.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        stream.clearErrors()

        populateValidParams(params)
        params.id = stream.id
        params.version = -1
        controller.update()

        assert view == "/stream/edit"
        assert model.streamInstance != null
        assert model.streamInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/stream/list'

        response.reset()

        populateValidParams(params)
        def stream = new Stream(params)

        assert stream.save() != null
        assert Stream.count() == 1

        params.id = stream.id

        controller.delete()

        assert Stream.count() == 0
        assert Stream.get(stream.id) == null
        assert response.redirectedUrl == '/stream/list'
    }
}
