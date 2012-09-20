package com.catalystitservices.vaadin;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;

/**
 * Setup the data container. It's static to make it easier to call insertItem()
 */
public class MainContainer {

	private static IndexedContainer container;
	private static int itemId;
	private static int insertItemId;

	// Don't instantiate
	private MainContainer() {}

	public static IndexedContainer createContainer() {
		if ( container != null ) {
			return container;
		}

		// Add properties
		container = new IndexedContainer();
		container.addContainerProperty( "name", String.class, null );
		container.addContainerProperty( "number", Integer.class, null );
		container.addContainerProperty( "id", String.class, null );

		// Add items (rows)
		addItem( "Bob", 10 );
		insertItemId = itemId;
		addItem( "Harry", 0 );
		insertItem( "Margaret", 13 );
		insertItemId = itemId;
		addItem( "Glenda", 22 );
		addItem( "Jessica", 24 );
		addItem( null, 99 );
		addItem( "Knute", null );

		return container;
	}

	/**
	 * Add an item on the bottom
	 * 
	 * @param name
	 * @param number
	 */
	private static void addItem( String name, Integer number ) {
		Item item = container.addItem( itemId );
		setValues( name, number, item );
	}

	/**
	 * Add an item after another item
	 * 
	 * @param name
	 * @param number
	 */
	public static void insertItem( String name, Integer number ) {
		Item item = container.addItemAfter( insertItemId, itemId );
		setValues( name, number, item );
	}

	/**
	 * Set the properties for an item
	 * 
	 * @param name
	 * @param number
	 * @param item
	 */
	private static void setValues( String name, Integer number, Item item ) {
		item.getItemProperty( "name" ).setValue( name );
		item.getItemProperty( "number" ).setValue( number );
		item.getItemProperty( "id" ).setValue( itemId );
		item.getItemProperty( "id" ).setReadOnly( true );
		itemId++;
	}

}
