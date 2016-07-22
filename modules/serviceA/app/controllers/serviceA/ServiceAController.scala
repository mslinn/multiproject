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
  def home = Action {
    Ok(views.html.index(s"Hello from Service A! " + thingA.value + thingB.value))
  }

  def main = Action {
    Ok(Html(s"Only serviceA will respond to this. ${ views.menu }"))
  }

  def greet(name: String) = Action {
    Ok(Html(s"Hello $name from Service A! ${ views.menu }"))
  }
}
