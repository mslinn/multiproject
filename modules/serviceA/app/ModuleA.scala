import com.google.inject.AbstractModule
import net.codingwell.scalaguice.ScalaModule
import javax.inject.Inject
import com.google.inject.{Guice, Injector}

package object model {
  val injectorB: Injector = Guice.createInjector(new ModuleB)
}

package model {
  class ThingA @Inject() () {
    // Demonstrates how to access objects in a dependent SBT subproject
    def value = "Thing A here; using Guice injector to access ThingB instance: " + injectorB.getInstance(classOf[ThingB]).value
  }
}

class ModuleA extends AbstractModule with ScalaModule {
  def configure() {
    bind[model.ThingA].asEagerSingleton
  }
}
