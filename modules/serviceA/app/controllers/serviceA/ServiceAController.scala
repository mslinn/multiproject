package controllers.serviceA

import javax.inject._
import model.{ThingA, ThingB}
import play.api.mvc._
import play.twirl.api.Html

@Singleton
class ServiceAController @Inject() (
  thingA: ThingA,
  thingB: ThingB
) extends Controller {
  def greet(name: String) = Action {
    Ok(Html(s"${ views.menuA }Hello $name from Service A!"))
  }

  def playHelp = Action {
    Ok(views.html.index(s"Hello from Service A!"))
  }

  def main = Action {
    Ok(Html(s"${ views.menuA }<p>${ thingA.value }</p>"))
  }
}
