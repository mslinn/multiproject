package controllers.serviceB

import javax.inject._
import model.ThingB
import play.api.mvc._
import play.twirl.api.Html
import scala.util.Random

@Singleton
class ServiceBController @Inject() (thingB: ThingB) extends Controller {
  def main = Action {
    Ok(Html(s"${ views.menu }This is serviceB! ${ thingB.value }."))
  }

  def lottery = Action {
    val lotteryNumbers = Seq.fill(5)(Random.nextInt(40)).mkString(" ")
    Ok(Html(s"${ views.menu }Service B says your lucky lottery numbers are $lotteryNumbers."))
  }
}
