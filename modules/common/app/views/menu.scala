package views

object menu {
  override val toString =
    s"""<p><b>Menu</b> (from Common subproject)</p>
       |<p><a href="${ controllers.common.routes.CommonController.index().url }">Home</a><br/>
       |
       |  Service A: <a href="/a${ controllers.serviceA.routes.ServiceAController.playHelp().url }">playHelp</a>
       |  <a href="/a${ controllers.serviceA.routes.ServiceAController.main().url }">main</a>
       |  <a href="/a${ controllers.serviceA.routes.ServiceAController.greet("Fred").url }">Greet Fred</a><br/>
       |
       |  Service B: <a href="${ controllers.serviceB.routes.ServiceBController.main().url }">main</a>
       |  <a href="${ controllers.serviceB.routes.ServiceBController.lottery().url }">lottery</a>
       |  <i>Why don't the ServiceB routes in <code>modules/common/app/views/menu</code> need to be prefaced with <code>/b</code>?</i>
       |</p>
       |""".stripMargin
}
