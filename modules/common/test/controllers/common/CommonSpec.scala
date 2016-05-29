package controllers.common

import org.scalatestplus.play._
import play.api.test._
import play.api.test.Helpers._
import java.io.File
import play.api.mvc.Results

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
class CommonSpec extends PlaySpec with Results {
  val modulePath = new File("./modules/common/")

  "CommonSpec" should {
    "send 404 on a bad request" in {
      running(FakeApplication(path = modulePath)) {
        route(FakeRequest(GET, "/boum")).foreach { result =>
          status(result) mustBe NOT_FOUND
        }
      }
    }

    "render the index page" in {
      running(FakeApplication(path = modulePath)) {
        route(FakeRequest(GET, "/")).foreach { result => // always returns status 404, why?
          status(result) must equal(OK)
          contentAsString(result) must contain ("Everything is great")
        }
      }
    }
  }
}
