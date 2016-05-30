package views

object menu {
  override def toString =
    s"""<p><a href="${ controllers.common.routes.CommonController.index().url }">Home</a> <br/>
       |  Service A: <a href="${ controllers.serviceA.routes.ServiceAController.home().url }">home</a>
       |  <a href="${ controllers.serviceA.routes.ServiceAController.main().url }">main</a>
       |  <a href="${ controllers.serviceA.routes.ServiceAController.greet("Fred").url }">Greet Fred</a><br/>
       |  Service B: <a href="${ controllers.serviceB.routes.ServiceBController.main().url }">main</a>
       |  <a href="${ controllers.serviceB.routes.ServiceBController.lottery().url }">lottery</a>
       |</p>
       |""".stripMargin
}
