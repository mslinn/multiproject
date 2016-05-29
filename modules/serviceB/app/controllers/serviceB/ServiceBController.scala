package controllers.serviceB

import play.api.mvc._
import play.twirl.api.Html
import scala.util.Random

class ServiceBController extends Controller {
  def main = Action {
    Ok(Html(s"This is serviceB! ${ views.menu }"))
  }

  def lottery = Action {
    val lotteryNumbers = Seq.fill(5)(Random.nextInt(40)).mkString(" ")
    Ok(Html(s"Service B says your lucky lottery numbers are $lotteryNumbers ${ views.menu }"))
  }
}
