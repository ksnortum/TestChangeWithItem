package com.catalystitservices.vaadin;

import com.vaadin.Application;
import com.vaadin.ui.Window;

/**
 * Start the application 
 */
@SuppressWarnings( "serial" )
public class MainApp extends Application {

	@Override
	public void init() {
		setMainWindow( new MainWindow() );
	}

	public class MainWindow extends Window {
		
		public MainWindow() {
			setContent( new MainTable() );
		}
	}

}
