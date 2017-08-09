# Modular Play Webapp Using Multiple Projects

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

Heavily modified and updated from the
[Kifi blog post](http://eng.42go.com/multi-project-deployment-in-play-framework),
which is dated and needs to be read with discretion.
This version corrects errors in the original project and adds globally available reverse routes and a non-Play intermediate subproject.

Structure is:

`root` webapp (only has `application.conf` and `routes`)
  - `serviceA` webapp (depends on `common`)
  - `serviceB` webapp (depends on `common`)
  - `nonPlay` subproject (depends on `common`)
  - `common` subproject 

`root` webapp displays a webpage and a menu is displayed that allows the user to navigate the entire collection of webapps.

