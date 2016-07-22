# Modular Play Webapp Using Multiple Projects

Heavily modified and updated from the
[Kifi blog post](http://eng.42go.com/multi-project-deployment-in-play-framework),
which is dated and needs to be read with discretion.
This version corrects errors in the original project and adds globally available reverse routes and a non-Play intermediate subproject.

The root project just delegates to Service A. ServiceA and ServiceB are Play webapps that each use Google Guice to define modules. ServiceA uses ServiceB.
