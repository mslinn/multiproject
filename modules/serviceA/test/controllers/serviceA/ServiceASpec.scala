package controllers.serviceA

import java.io.File
import org.scalatestplus.play._
import play.api.mvc.{Result, Results}
import play.api.test.Helpers._
import play.api.test._
import scala.concurrent.Future

class ServiceASpec extends PlaySpec with Results with OneAppPerSuite {
  val modulePath = new File("./modules/serviceA/")
  val controller = new ServiceAController()

  "ServiceASpec" should {
    "work" in {
      val result: Future[Result] = controller.home().apply(FakeRequest())
      status(result) mustBe 200
      contentAsString(result) must include("Welcome to Play")
    }

    "send 404 on a bad request" in {
      route(/*app, */FakeRequest(GET, "/boum")) match {
        case Some(result) => status(result) mustBe NOT_FOUND
        case None => fail("No response")
      }
    }

    "render the home page" in {
      //val url = controllers.routes.serviceA.ServiceAController().url
      route(/*app, */FakeRequest(GET, "/a")).foreach { result => // fails with status 404, why?
        status(result) must equal(OK)
        contentType(result) mustBe Some("text/html")
        contentAsString(result) must include ("Hello there")
      }
    }

    "respond to serviceA specific requests" in {
      route(/*app, */FakeRequest(GET, "/a/serviceA")).foreach { result => // fails with index 404, why?
        status(result) must equal(OK)
        contentAsString(result) must include ("Only serviceA will respond to this")
      }
      route(FakeRequest(GET, "/a/serviceA/George")).foreach { result =>
        status(result) must equal(OK)
        contentAsString(result) must include ("Hello George")
      }
    }
  }
}
