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
    Ok(views.html.main("Service A Greeting")(Html(s"${ views.menu }Hello $name from Service A!")))
  }

  def playHelp = Action {
    Ok(views.html.index(s"Hello from Service A!"))
  }

  def main = Action {
    Ok(views.html.main("Thing A Value")(Html(s"${ views.menu }<p>${ thingA.value }</p>")))
  }
}
