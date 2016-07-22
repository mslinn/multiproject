import javax.inject.Inject
import com.google.inject.AbstractModule
import net.codingwell.scalaguice.ScalaModule

package model {
  class ThingB @Inject() () {
    def value = "Thing B here"
  }
}

class ModuleB extends AbstractModule with ScalaModule {
  def configure() {
    bind[model.ThingB].asEagerSingleton
  }
}
