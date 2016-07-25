/** Demonstrates accessing routes from a non-Play subproject */
object NonPlay {
  val indexUrl: String = controllers.common.routes.CommonController.index().url
  val homeUrl: String = controllers.serviceA.routes.ServiceAController.playHelp().url
  val lotteryUrl: String = controllers.serviceB.routes.ServiceBController.lottery().url
}
