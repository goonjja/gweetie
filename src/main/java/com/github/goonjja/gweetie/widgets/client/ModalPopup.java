/**
 * 
 */
package com.github.goonjja.gweetie.widgets.client;

import java.util.Iterator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Ведерников Сергей
 * @date 06.02.2012
 */
public class ModalPopup extends Composite implements HasWidgets.ForIsWidget {
	private static int instanceCounter = 0;

	private static ModalPopupUiBinder uiBinder = GWT.create(ModalPopupUiBinder.class);

	interface ModalPopupUiBinder extends UiBinder<Widget, ModalPopup> {
	}

	private String rootId = "modal-popupp-" + instanceCounter;
	private boolean modal = false;
	private boolean loaded = false;
	private boolean shown = false;

	@UiField
	HTMLPanel root;
	@UiField
	DivElement header;
	@UiField
	HTMLPanel body;
	@UiField
	HTMLPanel footer;
	@UiField
	HeadingElement title;
	@UiField
	Anchor closeAnchor;
	@UiField
	Anchor okAnchor;
	HTML defaultMessage = new HTML();

	private void init() {
		initWidget(uiBinder.createAndBindUi(this));
		root.getElement().setId(rootId);
		instanceCounter++;
	}

	public ModalPopup() {
		init();
	}

	public ModalPopup(SafeHtml title, SafeHtml message) {
		init();

		setPopupTitle(title.asString());
		setMessage(message.asString());
	}

	public ModalPopup(String title, String message) {
		init();

		setPopupTitle(SafeHtmlUtils.fromString(title).asString());
		setMessage(SafeHtmlUtils.fromString(message).asString());
	}

	@Override
	protected void onLoad() {
		super.onLoad();
		loaded = true;
		reconfigure();
	}

	public void setPopupTitle(String title) {
		this.title.setInnerHTML(title);
	}

	public void setMessage(String message) {
		clear();
		defaultMessage.setHTML(message);
		add(defaultMessage);
	}

	public void setFooterVisible(boolean visible) {
		footer.setVisible(visible);
	}

	public void setCloseButtonVisible(boolean visible) {
		closeAnchor.setVisible(visible);
	}

	public void setModal(boolean modal) {
		this.modal = modal;
		reconfigure();
	}

	public HTMLPanel getFooter() {
		return footer;
	}

	public Anchor getOkAnchor() {
		return okAnchor;
	}

	public void show() {
		if (!shown)
			changeVisibility(rootId, "show");
	}

	public void hide() {
		changeVisibility(rootId, "hide");
	}

	private void reconfigure() {
		if (loaded) {
			if (modal) {
				configure(rootId, "static", false);
			} else {
				configure(rootId, true, true);
			}
		}
	}

	private native void configure(String id, String _backdrop, boolean _keyboard)/*-{
		$wnd.$("#" + id).modal({
			backdrop : _backdrop,
			keyboard : _keyboard,
			show : false
		});
	}-*/;

	private native void configure(String id, boolean _backdrop, boolean _keyboard)/*-{
		$wnd.$("#" + id).modal({
			backdrop : _backdrop,
			keyboard : _keyboard,
			show : false
		});
	}-*/;

	private native void changeVisibility(String id, String visibility)/*-{
		$wnd.$("#" + id).modal(visibility);
	}-*/;

	@UiHandler("closeAnchor")
	public void onCloseClicked(ClickEvent event) {
		hide();
	}

	@Override
	public void add(Widget w) {
		body.add(w);
	}

	@Override
	public void clear() {
		body.clear();
	}

	@Override
	public Iterator<Widget> iterator() {
		return body.iterator();
	}

	@Override
	public boolean remove(Widget w) {
		return body.remove(w);
	}

	@Override
	public void add(IsWidget w) {
		body.add(w);
	}

	@Override
	public boolean remove(IsWidget w) {
		return body.remove(w);
	}

	/**
	 * This method is called once the widget is completely hidden.
	 */
	protected void onHidden() {
		shown = false;
	}

	/**
	 * This method is called once the widget is completely shown.
	 */
	protected void onShown() {
		shown = true;
	}

	private native void setHandlerFunctions(Element e) /*-{
		var that = this;
		$wnd.jQuery(e).on('hidden', function() {
			that.@com.github.goonjja.gweetie.widgets.client.ModalPopup::onHidden()();
		});
		$wnd.jQuery(e).on('shown', function() {
			that.@com.github.goonjja.gweetie.widgets.client.ModalPopup::onShown()();
		});
	}-*/;
}
