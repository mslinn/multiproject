package controllers.serviceB

import java.io.File
import org.scalatestplus.play._
import play.api.mvc._
import play.api.test.Helpers._
import play.api.test._

class ServiceBSpec extends PlaySpec with Results {
  val modulePath = new File("./modules/serviceB/")

  "ServiceBSpec" should {
    "send 404 on a bad request" in {
      running(FakeApplication(path = modulePath)) {
        route(FakeRequest(GET, "/boum")) match {
          case Some(result) => status(result) mustBe NOT_FOUND
          case None => fail("No response")
        }
      }
    }

    "respond to serviceB specific requests" in {
      running(FakeApplication(path = modulePath)) {
        route(FakeRequest(GET, "/b/serviceB")).foreach { result =>
          status(result) must equal(OK) // fails with index 404
          contentAsString(result) must include ("This is serviceB")
        }
        route(FakeRequest(GET, "/b/serviceB/lottery")).foreach { result =>
          status(result) must equal(OK)
          contentAsString(result) must include ("Your lucky lottery numbers are")
        }
      }
    }
  }
}
