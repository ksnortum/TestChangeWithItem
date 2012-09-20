Test Change with Item
=====================

This project sets up a simple Table using [Vaadin](http://vaadin.com) and changes cells based on the values modified in other cells using the Item object.  A ValueChangeListener is added to each cell in the MainFieldFactory to change the number to "42" if the name is changed to "Jeff" and to change the name to "Zero" if the number is changed to "0".

Running
-------

1. Download the project
2. Download [Maven](http://maven.apache.org/download.html) if necessary
3. `cd` into the project home (the folder with the pom.xml in it)
4. Execute `mvn compile tomcat7:run`
5. Open your favorite browser.  The URL will be in the messages, but it should be [http://localhost:9090/test-change](http://localhost:9090/test-change)

_Note:_ You can also run this in the Eclipse IDE by importing the project and running with the [m2e](http://www.eclipse.org/m2e/download/) plugin.

Things To Notice
----------------

* The grid is pre-loaded with data.
* Press the "Add Boris" button to see a row inserted, if you wish.
* Change a name to "Jeff" and tab.  Jeff's number becomes 42.
* Change a number to 0.  It's name becomes "Zero".

Contact
-------

Knute Snortum <ksnortum@catalystitservices.com>