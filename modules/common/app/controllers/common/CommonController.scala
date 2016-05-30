package controllers.common

import javax.inject._
import play.api.mvc._
import play.twirl.api.Html

@Singleton
class CommonController @Inject() extends Controller {
  def index = Action {
    Ok(Html(s"Everything is great!  ${ views.menu }"))
  }
}
