package controllers.common

import org.scalatestplus.play._
import play.api.{Application, Configuration}
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.mvc.Results
import play.api.test.Helpers._
import play.api.test._

class TestCommon extends PlaySpec with Results with OneAppPerSuite {
  private val conf = Configuration("play.http.router" -> "common.Routes")

    implicit override lazy val app: Application = GuiceApplicationBuilder(
      configuration = conf
    ).build()

  "Common" should {
    "send 404 on a bad request" in {
      route(app, FakeRequest(GET, "/boum")).foreach { result =>
        status(result) mustBe NOT_FOUND
      }
    }

    "render the index page" in {
      route(app, FakeRequest(GET, "/")).foreach { result =>
        status(result) mustBe OK
        val x: String = contentAsString(result)
        contentAsString(result) must include ("Everything is great")
      }
    }
  }
}
