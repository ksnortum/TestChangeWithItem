package com.catalystitservices.vaadin;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.AbstractField;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;

/**
 * Add listeners to the table columns (properties)
 */
@SuppressWarnings( "serial" )
public class MainFieldFactory extends DefaultFieldFactory {

	public MainFieldFactory() {
		super();
	}

	@Override
	public Field createField( final Container container, final Object itemId,
			Object propertyId, Component uiContext ) {

		// Get the default field
		Field field =
				super.createField( container, itemId, propertyId, uiContext );
		( (AbstractField) field ).setImmediate( true );
		String pid = propertyId.toString();

		// Add listener for name column
		if ( pid.equals( "name" ) ) {
			field.addListener( new Property.ValueChangeListener() {

				@Override
				public void valueChange( ValueChangeEvent event ) {
					Object value = event.getProperty().getValue();

					// Jeff gets the number 42
					if ( value != null && value.toString().equals( "Jeff" ) ) {
						Item item = container.getItem( itemId );
						item.getItemProperty( "number" ).setValue( 42 );
					}
				}
			} );
		}

		// Add listener for number column
		else if ( pid.equals( "number" ) ) {
			field.addListener( new Property.ValueChangeListener() {

				@Override
				public void valueChange( ValueChangeEvent event ) {
					Object value = event.getProperty().getValue();

					// Zero numbers get a name of Zero
					if ( value != null && value.toString().equals( "0" ) ) {
						Item item = container.getItem( itemId );
						item.getItemProperty( "name" ).setValue( "Zero" );
					}
				}
			} );
		}

		return field;
	}
}
