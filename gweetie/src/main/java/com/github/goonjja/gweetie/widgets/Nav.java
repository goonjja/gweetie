package com.github.goonjja.gweetie.widgets;

import java.util.Iterator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionChangeEvent.Handler;
import com.google.gwt.view.client.SelectionChangeEvent.HasSelectionChangedHandlers;

public class Nav extends Composite implements HasWidgets, HasSelectionChangedHandlers {
	public static enum Type {
		pills, tabs, list, stackedtabs, stackedpills

	}

	private static NavUiBinder uiBinder = GWT.create(NavUiBinder.class);

	interface NavUiBinder extends UiBinder<Widget, Nav> {
	}

	@UiField
	HTMLPanel ul;

	private Type type;
	private boolean unselectable = false;
	private boolean activeItemFiresEvent = false;

	public Nav() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void add(Widget w) {
		if (w instanceof NavItem) {
			ul.add(w);
			((NavItem) w).setNav(this);
		}
		// only nav items allowed
	}

	public void add(String text, String value) {
		add(new NavItem(text, value));
	}

	@Override
	public void clear() {
		ul.clear();
	}

	@Override
	public Iterator<Widget> iterator() {
		return ul.iterator();
	}

	@Override
	public boolean remove(Widget w) {
		return ul.remove(w);
	}

	public NavItem getItemAtIndex(int index) {
		if (index < ul.getWidgetCount() && index >= 0)
			return ((NavItem) ul.getWidget(index));
		return null;
	}

	public NavItem getItemWithValue(String value) {
		for (Iterator<Widget> iterator = iterator(); iterator.hasNext();) {
			NavItem item = (NavItem) iterator.next();
			if (item.getValue() != null && item.getValue().equals(value))
				return item;
		}
		return null;
	}

	/**
	 * Fires SelectionChangeEvent and select item with given index
	 * 
	 * @param index
	 */
	public void setSelectedItem(int index) {
		setSelectedItem(index, true);
	}

	public void setSelectedItem(int index, boolean fireChangeEvent) {
		for (int i = 0; i < ul.getWidgetCount(); i++) {
			((NavItem) ul.getWidget(i)).setActive(false);
		}

		if (index < ul.getWidgetCount() && index >= 0) {
			((NavItem) ul.getWidget(index)).setActive(true);

		}

		if (fireChangeEvent)
			SelectionChangeEvent.fire(this);
	}

	/**
	 * Set item with given item value selected
	 * 
	 * @param itemValue
	 * @param fireChangeEvent
	 */
	public void setSelectedItem(String itemValue, boolean fireChangeEvent) {
		NavItem item = getItemWithValue(itemValue);
		setSelectedItem(item, fireChangeEvent);
	}

	public int getSelectedItemIndex() {
		for (int i = 0; i < ul.getWidgetCount(); i++) {
			Widget _w = ul.getWidget(i);
			if (((NavItem) _w).getActive())
				return i;
		}
		return -1;
	}

	public NavItem getSelectedItem() {
		for (int i = 0; i < ul.getWidgetCount(); i++) {
			Widget _w = ul.getWidget(i);
			if (((NavItem) _w).getActive())
				return ((NavItem) _w);
		}
		return null;
	}

	/**
	 * Fires SelectionChangeEvent and select item
	 * 
	 * @param index
	 */
	public void setSelectedItem(Widget item, boolean fireChangeEvent) {
		int index = ul.getWidgetIndex(item);
		setSelectedItem(index, fireChangeEvent);
	}

	public void itemClicked(Widget item) {
		NavItem nItem = (NavItem) item;
		if (item != null) {
			if (unselectable && nItem.getActive())
				setSelectedItem((Widget) null, true);
			else if (activeItemFiresEvent && nItem.getActive())
				SelectionChangeEvent.fire(this);
			else if (!nItem.getActive())
				setSelectedItem(item, true);
		} else {
			setSelectedItem((Widget) null, true);
		}
	}

	public String getType() {
		return type.name();
	}

	public void setType(String _type) {
		Type realType = Type.pills;
		try {
			realType = Type.valueOf(_type);
		} catch (IllegalArgumentException e) {
		}
		if (realType == Type.pills) {
			ul.setStyleName("nav nav-pills");
		} else if (realType == Type.tabs) {
			ul.setStyleName("nav nav-tabs");
		} else if (realType == Type.list) {
			ul.setStyleName("nav nav-list");
		} else if (realType == Type.stackedpills) {
			ul.setStyleName("nav nav-pills nav-stacked");
		} else if (realType == Type.stackedtabs) {
			ul.setStyleName("nav nav-tabs nav-stacked");
		}
		this.type = realType;
	}

	public boolean getUnselectable() {
		return unselectable;
	}

	public void setUnselectable(boolean unselectable) {
		this.unselectable = unselectable;
	}

	public boolean getActiveItemFiresEvent() {
		return activeItemFiresEvent;
	}

	public void setActiveItemFiresEvent(boolean activeItemFiresEvent) {
		this.activeItemFiresEvent = activeItemFiresEvent;
	}

	@Override
	public HandlerRegistration addSelectionChangeHandler(Handler handler) {
		return addHandler(handler, SelectionChangeEvent.getType());
	}
}
