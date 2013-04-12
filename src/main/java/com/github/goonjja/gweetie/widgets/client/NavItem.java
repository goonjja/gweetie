package com.github.goonjja.gweetie.widgets.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class NavItem extends Composite implements HasText {

	private static PillUiBinder uiBinder = GWT.create(PillUiBinder.class);

	interface PillUiBinder extends UiBinder<Widget, NavItem> {
	}

	@UiField
	HTMLPanel li;
	@UiField
	Anchor a;

	private Nav nav;
	private String value;

	public NavItem() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public NavItem(String text, String value) {
		this();
		setText(text);
		setValue(value);
	}

	@Override
	public String getText() {
		return a.getText();
	}

	@Override
	public void setText(String text) {
		a.setText(text);
	}

	public boolean getActive() {
		return li.getStyleName().equals("active");
	}

	public void setActive(boolean active) {
		if (active)
			li.setStyleName("active");
		else
			li.removeStyleName("active");
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@UiHandler("a")
	public void onClick(ClickEvent event) {
		if (nav != null)
			nav.itemClicked(this);
	}

	public Nav getNav() {
		return nav;
	}

	public void setNav(Nav nav) {
		this.nav = nav;
	}
}
