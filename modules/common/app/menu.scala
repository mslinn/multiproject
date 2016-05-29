package views

object menu {
  // The URLs are hard-coded because there is no way to access the combined routing table for the entire app
  override def toString =
    """<p><a href="/">Home</a> <br/>
      |Service A: <a href="/a">home</a>
      |<a href="/a/serviceA">main</a>
      |<a href="/a/serviceA/Fred">Greet Fred</a><br/>
      |Service B: <a href="/b/serviceB">main</a>
      |<a href="/b/serviceB/lottery">lottery</a>
      |</p>
      |""".stripMargin
}
