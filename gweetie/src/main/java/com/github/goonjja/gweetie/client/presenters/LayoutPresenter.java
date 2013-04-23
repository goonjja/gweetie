package com.github.goonjja.gweetie.client.presenters;

import javax.inject.Singleton;

import com.github.goonjja.gweetie.client.FrameworkUIMessages;
import com.github.goonjja.gweetie.client.events.MessageHandler;
import com.github.goonjja.gweetie.client.events.MessageType;
import com.github.goonjja.gweetie.client.mvp4g.AppEventBus;
import com.github.goonjja.gweetie.client.mvp4g.navigation.AppPlace;
import com.github.goonjja.gweetie.client.util.JSUtils;
import com.github.goonjja.gweetie.client.views.Layout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

/**
 * Root layout presenter, controls loading of view's contents
 * 
 * @author Ведерников Сергей
 * 
 */
@Singleton
@Presenter(view = Layout.class, multiple = false)
public class LayoutPresenter extends BasePresenter<Layout, AppEventBus> implements MessageHandler {
	// private boolean layout_initialized = false;

	public LayoutPresenter() {
		super();
		GWT.log("New instance of layout presenter");
	}

	public void onStart() {
	}

	public void onPageNotFound() {
		view.getNotificationPopup().setPopupTitle(FrameworkUIMessages.INSTANCE.pageNotFoundMessageTitle());
		view.getNotificationPopup().setMessage(FrameworkUIMessages.INSTANCE.pageNotFoundMessageText());
		view.getNotificationPopup().show();
	}

	public void onSetHeader(Widget header) {
		view.setHeader(header);
	}

	public void onSetView(Widget newBody) {
		view.setContent(newBody);
		eventBus.hideProcessing();

		JSUtils.initTooltips();
		eventBus.hideMessages();
	}

	public void onNavigated(AppPlace place) {
		JSUtils.hidePopovers();
		JSUtils.hideTooltips();
		eventBus.hideMessages();
	}

	public void onShowProcessing(String title, String message) {
		if (title != null)
			view.getProcessingPopup().setPopupTitle(title);
		else
			view.getProcessingPopup().setPopupTitle(FrameworkUIMessages.INSTANCE.pleaseWait());
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
		eventBus.showMessage(MessageType.ERROR,
				FrameworkUIMessages.INSTANCE.childModuleLoadingError() + " " + reason.getMessage());
	}

	@Override
	public void onShowMessage(MessageType type, String message) {
		if (type == MessageType.ERROR) {
			view.showError(message);
			JSUtils.scrollToTop();
		} else {
			view.showSuccess(message);
		}
	}

	@Override
	public void onHideMessages() {
		view.hideAlerts();
	}
}
