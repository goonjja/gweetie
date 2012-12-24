package me.goonjja.gwt.scrim.client.presenters;


import me.goonjja.gwt.scrim.client.mvp4g.AppEventBus;
import me.goonjja.gwt.scrim.client.mvp4g.navigation.AppPlace;
import me.goonjja.gwt.scrim.client.util.JSUtils;
import me.goonjja.gwt.scrim.client.views.Header;
import me.goonjja.gwt.scrim.client.views.Layout;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

/**
 * Root layout presenter, controls loading of view's contents
 * 
 * @author Ведерников Сергей
 * 
 */
@Presenter(view = Layout.class)
public class LayoutPresenter extends BasePresenter<Layout, AppEventBus> {
	// private boolean layout_initialized = false;

	public void onStart() {
	}

	public void onPageNotFound() {
		view.getNotificationPopup().setPopupTitle("Page not found");
		view.getNotificationPopup().setMessage("URL specified is invalid, or link is broken");
		view.getNotificationPopup().show();
	}

	public void onSetHeader(Header header) {
		view.setHeader(header);
	}

	public void onSetView(Widget newBody) {
		view.setContent(newBody);
		eventBus.hideProcessing();

		JSUtils.initTooltips();
		eventBus.hideAlerts();
	}

	public void onNavigated(AppPlace place) {
		JSUtils.hidePopovers();
		JSUtils.hideTooltips();
		eventBus.hideAlerts();
	}

	public void onShowProcessing(String title, String message) {
		if (title != null)
			view.getProcessingPopup().setPopupTitle(title);
		else
			view.getProcessingPopup().setPopupTitle("Please wait");
		if (message != null)
			view.getProcessingPopup().setMessage(message);
		else
			view.loadDefaultMessage();
		view.getProcessingPopup().show();
	}

	public void onHideProcessing() {
		view.getProcessingPopup().hide();
	}

	public void onErrorOnLoad(Throwable reason) {
		eventBus.showError("Cannot load child module. Reason: " + reason.getMessage());
	}

	public void onShowError(String message) {
		view.showError(message);
		JSUtils.scrollToTop();
	}

	public void onShowSuccess(String message) {
		view.showSuccess(message);
	}

	public void onHideAlerts() {
		view.hideAlerts();
	}
}
