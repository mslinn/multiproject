package controllers.serviceA

import java.io.File
import org.scalatest.concurrent.ScalaFutures
import org.scalatestplus.play._
import play.api.mvc.Results
import play.api.test._
import play.api.test.Helpers._
import play.api.mvc.Result
import scala.concurrent.Future

class ServiceASpec extends PlaySpec with Results with OneAppPerSuite with ScalaFutures {
  val modulePath = new File("./modules/serviceA/")
  val controller = new ServiceAController()

  "ServiceASpec" should {
    "work" in {
      val result: Future[Result] = controller.home().apply(FakeRequest())
      status(result) mustBe 200
      contentAsString(result) must include("Welcome to Play")
    }

    "send 404 on a bad request" in {
      running(FakeApplication(path = modulePath)) {
        route(FakeRequest(GET, "/boum")) match {
          case Some(result) => status(result) mustBe NOT_FOUND
          case None => fail("No response")
        }
      }
    }

    "render the home page" in {
      running(FakeApplication(path = modulePath)) {
        //val url = controllers.routes.serviceA.ServiceAController().url
        route(FakeRequest(GET, "/a")).foreach { result => // fails with index 404, why?
          status(result) must equal(OK)
          contentType(result) mustBe Some("text/html")
          contentAsString(result) must include ("Hello there")
        }
      }
    }

    "respond to serviceA specific requests" in {
      running(FakeApplication(path = modulePath)) {
        route(FakeRequest(GET, "/a/serviceA")).foreach { result => // fails with index 404, why?
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
}
