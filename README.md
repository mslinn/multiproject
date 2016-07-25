# Modular Play Webapp Using Multiple Projects

Heavily modified and updated from the
[Kifi blog post](http://eng.42go.com/multi-project-deployment-in-play-framework),
which is dated and needs to be read with discretion.
This version corrects errors in the original project and adds globally available reverse routes and a non-Play intermediate subproject.

The root project just delegates to `ServiceA`. `ServiceA` and `ServiceB` are Play webapps that each use Google Guice to define modules. 
Unlike the configuration in master, for this git branch `ServiceA` uses `ServiceB`.

Structure is:

`root` webapp (only has `application.conf` and `routes`)
  - `serviceA` webapp (depends on `serviceB`)
    - `serviceB webapp (depends on `nonPlay` and `common`)
      - `nonPlay` subproject (depends on `common`)
  - `common` subproject 
