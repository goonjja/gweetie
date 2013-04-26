package com.github.goonjja.gweetie.demo.client.presenters;

import javax.inject.Singleton;

import com.github.goonjja.gweetie.core.GweetieRootEventBus;
import com.github.goonjja.gweetie.core.handlers.LayoutPlace;
import com.github.goonjja.gweetie.core.handlers.MessageHandler;
import com.github.goonjja.gweetie.core.handlers.MessageType;
import com.github.goonjja.gweetie.core.handlers.ModuleLoadingHandler;
import com.github.goonjja.gweetie.core.handlers.ViewManager;
import com.github.goonjja.gweetie.core.util.JSUtils;
import com.github.goonjja.gweetie.demo.client.core.AppEventBus;
import com.github.goonjja.gweetie.demo.client.ui.Layout;
import com.github.goonjja.gweetie.demo.client.ui.LayoutPlaces;
import com.github.goonjja.gweetie.demo.client.ui.UiMessages;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
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
public class LayoutPresenter extends BasePresenter<Layout, GweetieRootEventBus> implements MessageHandler, ViewManager,
		ModuleLoadingHandler {

	private AppEventBus eventBus() {
		return (AppEventBus) eventBus;
	}

	public void onShowNotification(String title, String message) {
		view.getNotificationPopup().setPopupTitle(title);
		view.getNotificationPopup().setMessage(message);
		view.getNotificationPopup().show();
	}

	public void onLoadView(LayoutPlace place, Widget view) {
		if (place == LayoutPlaces.Header)
			this.view.setHeader(view);
		else if (place == LayoutPlaces.Content)
			this.view.setContent(view);
		// eventBus().hideProcessing();
		// eventBus.hideMessages();
	}

	public void onShowProcessing(String title, String message) {
		if (title != null)
			view.getBusyPopup().setPopupTitle(title);
		else
			view.getBusyPopup().setPopupTitle(UiMessages.INSTANCE.pleaseWait());
		if (message != null)
			view.getBusyPopup().setMessage(message);
		else
			view.loadDefaultBusyMessage();
		view.getBusyPopup().show();
	}

	public void onHideProcessing() {
		view.getBusyPopup().hide();
	}

	public void onShowMessage(final MessageType type, final String message) {
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				if (type == MessageType.ERROR) {
					view.showError(message);
					JSUtils.scrollToTop();
				} else {
					view.showSuccess(message);
				}
			}
		});
	}

	public void onHideMessages() {
		view.hideAlerts();
	}

	public void onBeforeChildModuleLoaded() {
	}

	public void onErrorOnLoadChildModule(Throwable reason) {
		eventBus().showNotification(UiMessages.INSTANCE.childModuleLoadingError(), reason.getMessage());
	}

	public void onShowDashboard(Widget dashboard) {
		eventBus.loadView(LayoutPlaces.Content, dashboard);
	}
}
