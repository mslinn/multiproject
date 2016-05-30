object NonPlay {
  // shows how to access a route from a non-Play subproject
  val homeUrl: String = controllers.serviceA.routes.ServiceAController.home().url
}
