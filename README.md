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

## SASS
The `sbt-sass` plugin is mostly working the way I expected. 
After you run the webapp you will be able to view a combined and minified CSS document at
[http://localhost:9000/a/assets/stylesheets/main.css](http://localhost:9000/a/assets/stylesheets/main.css).
That document is created by `modules/serviceA/app/assets/stylesheets/main.scss`. The top of that file starts with:

```
//@import "lib/compass-mixins/lib/compass";
@import "lib/jquery-ui-themes/redmond/jquery-ui";
@import "lib/jquery-ui-themes/redmond/jquery.ui.theme";
//@import "lib/bootstrap-sass/assets/stylesheets/bootstrap";
@import "lib/bootstrap/css/bootstrap";
//@import "lib/bootstrap-datepicker/css/bootstrap-datepicker"; // don't know why this is not found
@import "lib/dropzone/dropzone";
```

... the rest of `main.sccs` is actually a CSS file that I use in another project. It is just here to give SASS something to chew on.
I commented out the problem files. Uncomment them and you'll see the problems. Any help with solutions would be appreciated.
