package controllers

import javax.inject._
import play.api.mvc._

@Singleton
class Application @Inject() extends Controller {
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
}
