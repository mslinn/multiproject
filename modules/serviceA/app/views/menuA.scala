package views

object menuA {
  override val toString =
    s"""<p><b>Service A Menu</b></p>
       |<p><a href="${ controllers.common.routes.CommonController.index().url }">Home</a><br/>
       |
       |  Service A: <a href="${ controllers.serviceA.routes.ServiceAController.playHelp().url }">playHelp</a>
       |  <a href="${ controllers.serviceA.routes.ServiceAController.main().url }">main</a>
       |  <a href="${ controllers.serviceA.routes.ServiceAController.greet("Fred").url }">Greet Fred</a><br/>
       |
       |  Service B: <a href="${ controllers.serviceB.routes.ServiceBController.main().url }">main</a>
       |  <a href="${ controllers.serviceB.routes.ServiceBController.lottery().url }">lottery</a>
       |</p>
       |""".stripMargin
}
