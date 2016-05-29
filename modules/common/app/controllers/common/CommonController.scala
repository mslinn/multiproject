package controllers.common

import play.api.mvc._
import play.twirl.api.Html

class CommonController extends Controller {
  def index = Action {
    Ok(Html(s"Everything is great!  ${ views.menu }"))
  }
}
