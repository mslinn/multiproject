package controllers.serviceB

import java.io.File
import org.scalatestplus.play._
import play.api.mvc._
import play.api.test.Helpers._
import play.api.test._

class TestServiceB extends PlaySpec with Results with OneAppPerSuite {
  override lazy val app = FakeApplication(new File("./modules/serviceB/"))

  "ServiceBSpec" should {
    "respond to valid requests" in {
      route(app, FakeRequest(GET, "/b/serviceB")).foreach { result =>
        status(result) mustBe OK  // not sure why this fails with status 404
        contentAsString(result) must include ("This is serviceB")
      }
    }

    "respond to another valid request" in {
      route(app, FakeRequest(GET, "/b/serviceB/lottery")).foreach { result =>
        status(result) mustBe OK  // not sure why this fails with status 404
        contentAsString(result) must include ("Your lucky lottery numbers are")
      }}

    "handle invalid requests" in {
      route(app, FakeRequest(GET, "/boum")) match {
        case Some(result) => status(result) mustBe NOT_FOUND
        case None => fail("No response")
      }
    }
  }
}
