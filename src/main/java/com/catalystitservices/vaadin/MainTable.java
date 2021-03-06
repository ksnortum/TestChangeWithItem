package com.catalystitservices.vaadin;

import com.vaadin.ui.Button;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

/**
 * Setup the table and container 
 */
@SuppressWarnings( "serial" )
public class MainTable extends VerticalLayout {
	
	public MainTable() {
		
		// Table
		Table table = new Table();
		table.setContainerDataSource( MainContainer.createContainer() );
		
		// If you don't set the table width, it will shrink to fit
		//table.setWidth( "40%" );
		
		table.setVisibleColumns( new Object[] { "id", "name", "number" } );
		
		// Ratios between the cells
		//table.setColumnExpandRatio( "id", 1 );
		//table.setColumnExpandRatio( "name", 4 );
		//table.setColumnExpandRatio( "number", 4 );
		
		// Actual pixel widths of the cells
		table.setColumnWidth( "id", 10 );
		table.setColumnWidth( "name", 135 );
		table.setColumnWidth( "number", 135 );
		
		table.setEditable( true );
		table.setImmediate( true );
		table.setPageLength( 8 );
		table.setTableFieldFactory( new MainFieldFactory() );
		addComponent( table );
		
		// Button
		Button borisButton = new Button( "Add Borris" );

		// Add a listener so that we can see the insertion of an item
		borisButton.addListener( new ClickListener() {

			@Override
			public void buttonClick( ClickEvent event ) {
				MainContainer.insertItem( "Boris", 12 );
			}
		} );

		addComponent( borisButton );
	}

}
