package controllers.serviceA

import javax.inject.Inject
import org.scalatestplus.play._
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.{Application, Configuration}
import play.api.mvc.{Result, Results}
import play.api.test.Helpers._
import play.api.test._
import scala.concurrent.Future

class TestServiceA extends PlaySpec with Results with OneAppPerSuite {
  private val conf = Configuration("play.http.router" -> "serviceA.Routes")

  implicit override lazy val app: Application = GuiceApplicationBuilder(
    configuration = conf
  ).build()

  "ServiceASpec" should {
    "work" in {
      route(app, FakeRequest(routes.ServiceAController.playHelp())) match {
        case Some(result) =>
          status(result) mustBe OK
          contentAsString(result) must include("Welcome to Play")
      }
    }

    "render the greeting page" in {
      route(app, FakeRequest(routes.ServiceAController.greet("George"))) match {
        case Some(result) =>
          status(result) mustBe OK
          contentType(result) mustBe Some("text/html")
          contentAsString(result) must include("Hello George")
      }
    }

    "send 404 on a bad request" in {
      route(app, FakeRequest(GET, "/boum")) match {
        case Some(result) => status(result) mustBe NOT_FOUND
        case None => fail("No response")
      }
    }

    "respond to serviceA specific requests" in {
      route(app, FakeRequest(GET, "/a/serviceA")) match {
        case Some(result) =>
          status(result) mustBe OK
          contentAsString(result) must include ("Only serviceA will respond to this")
      }

      route(app, FakeRequest(GET, "/a/serviceA/George")) match {
        case Some(result) =>
          status(result) mustBe OK
          contentAsString(result) must include ("Hello George")
      }
    }
  }
}
