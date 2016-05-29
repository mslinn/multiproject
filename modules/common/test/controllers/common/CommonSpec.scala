package controllers.common

import org.scalatestplus.play._
import play.api.test._
import play.api.test.Helpers._
import java.io.File
import play.api.mvc.Results

class CommonSpec extends PlaySpec with Results with OneAppPerSuite {
  val modulePath = new File("./modules/common/")

  "Common" should {
    "send 404 on a bad request" in {
      route(app, FakeRequest(GET, "/boum")).foreach { result =>
        status(result) mustBe NOT_FOUND
      }
    }

    "render the index page" in {
      route(app, FakeRequest(GET, "/")).foreach { result => // always returns status 404, why?
        status(result) must equal(OK)
        contentAsString(result) must contain ("Everything is great")
      }
    }
  }
}
