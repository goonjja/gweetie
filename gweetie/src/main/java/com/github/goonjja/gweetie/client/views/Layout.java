package com.github.goonjja.gweetie.client.views;

import com.github.goonjja.gweetie.client.FrameworkUIMessages;
import com.github.goonjja.gweetie.widgets.client.ModalPopup;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Sample implementation of {@link LayoutView}.
 */
public class Layout extends Composite {
	public static final String PROCESSING_PROGRESSBAR_HTML = "<div class='progress progress-success progress-striped active'><div class='bar' style='width: 100%;'></div></div>";

	interface Binder extends UiBinder<Widget, Layout> {
	}

	private static final Binder binder = GWT.create(Binder.class);
	private static int alertCounter = -9999999;

	@UiField
	HTMLPanel errorPanel;
	@UiField
	HTMLPanel errorContainer;

	@UiField
	SimplePanel content;

	@UiField
	DivElement header;

	@UiField
	HTMLPanel topContainer;

	@UiField
	ModalPopup notificationPopup;

	@UiField
	ModalPopup processingPopup;
	@UiField
	HTMLPanel defaultProcessingMessage;

	public Layout() {
		initWidget(binder.createAndBindUi(this));

		hideAlerts();

		notificationPopup.getOkAnchor().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				notificationPopup.hide();
			}
		});
	}

	public void setContent(Widget view) {
		content.setWidget(view);
	}

	public void setHeader(Widget header) {
		topContainer.addAndReplaceElement(header.asWidget(), this.header);
	}

	public ModalPopup getNotificationPopup() {
		return notificationPopup;
	}

	public ModalPopup getBusyPopup() {
		return processingPopup;
	}

	public void loadDefaultBusyMessage() {
		getBusyPopup().setMessage(
				"<div><p>" + FrameworkUIMessages.INSTANCE.processingRequest() + "</p></div>"
						+ PROCESSING_PROGRESSBAR_HTML);
	}

	public void showError(final String message) {
		HTMLPanel messagePanel = addAlert("error: " + message);
		messagePanel.addStyleName("alert-error");

		errorPanel.setVisible(true);
	}

	public void showSuccess(final String message) {
		HTMLPanel messagePanel = addAlert("success: " + message);
		messagePanel.addStyleName("alert-success");

		errorPanel.setVisible(true);
	}

	private HTMLPanel addAlert(final String message) {
		final HTMLPanel messagePanel = new HTMLPanel("h6", message);
		messagePanel.setStyleName("alert fade in");
		alertCounter++;
		final String id = "alert-" + alertCounter;
		messagePanel.getElement().setId(id);
		Anchor a = new Anchor(SafeHtmlUtils.fromSafeConstant("&times;"));
		a.setStyleName("close");
		a.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				closeAlert(messagePanel);
			}
		});
		messagePanel.add(a);
		errorContainer.add(messagePanel);
		initAlert();
		// scheduled hiding
		// Scheduler.get().scheduleFixedDelay(new RepeatingCommand() {
		//
		// @Override
		// public boolean execute() {
		// closeAlert(messagePanel);
		// return false;
		// }
		// }, 10000);
		return messagePanel;
	}

	public void hideAlerts() {
		errorPanel.setVisible(false);
		errorContainer.clear();
	}

	public native static void initAlert()
	/*-{
		$wnd.$(".alert").alert();
	}-*/;

	public native static void closeAlert(String id)
	/*-{
		$wnd.$("#" + id).alert('close');
	}-*/;

	private void closeAlert(Widget widgetToHide) {
		if (widgetToHide == null || widgetToHide.getParent() == null)
			return;
		closeAlert(widgetToHide.getElement().getId());
		// It's required to remove child from parent! Or exceptions will be
		// thrown later
		errorContainer.remove(widgetToHide);
		widgetToHide = null;
		if (!errorContainer.iterator().hasNext())
			hideAlerts();
	}
}
