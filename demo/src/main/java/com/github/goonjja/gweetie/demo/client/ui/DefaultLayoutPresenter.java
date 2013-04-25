package com.github.goonjja.gweetie.demo.client.ui;

import javax.inject.Singleton;

import com.github.goonjja.gweetie.core.GweetieRootEventBus;
import com.github.goonjja.gweetie.core.handlers.LayoutPlace;
import com.github.goonjja.gweetie.core.handlers.MessageHandler;
import com.github.goonjja.gweetie.core.handlers.MessageType;
import com.github.goonjja.gweetie.core.handlers.ModuleLoadingHandler;
import com.github.goonjja.gweetie.core.handlers.NavigationHandler;
import com.github.goonjja.gweetie.core.handlers.ViewManager;
import com.github.goonjja.gweetie.core.navigation.GweetiePlace;
import com.github.goonjja.gweetie.core.util.JSUtils;
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
public class DefaultLayoutPresenter extends BasePresenter<Layout, GweetieRootEventBus> implements MessageHandler,
		NavigationHandler, ViewManager, ModuleLoadingHandler {

	public void onPageNotFound() {
		view.getNotificationPopup().setPopupTitle(UiMessages.INSTANCE.pageNotFoundMessageTitle());
		view.getNotificationPopup().setMessage(UiMessages.INSTANCE.pageNotFoundMessageText());
		view.getNotificationPopup().show();
	}

	public void onSetHeader(Widget header) {
		view.setHeader(header);
	}

	public void onLoadView(LayoutPlace place, Widget view) {
		if (place != null)
			this.view.setHeader(view);
		else
			this.view.setContent(view);
		onUnlockScreen();

		eventBus.hideMessages();
	}

	public void onNavigated(GweetiePlace place) {
		// eventBus.hideMessages();
	}

	// public void onShowProcessing(String title, String message) {
	// if (title != null)
	// view.getBusyPopup().setPopupTitle(title);
	// else
	// view.getBusyPopup().setPopupTitle(FrameworkUIMessages.INSTANCE.pleaseWait());
	// if (message != null)
	// view.getBusyPopup().setMessage(message);
	// else
	// view.loadDefaultBusyMessage();
	// view.getBusyPopup().show();
	// }
	//
	// public void onHideProcessing() {
	// view.getBusyPopup().hide();
	// }

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

	public void onLockScreen() {
		view.loadDefaultBusyMessage();
		view.getBusyPopup().show();
	}

	public void onUnlockScreen() {
		view.getBusyPopup().hide();
	}

	public void onBeforeChildModuleLoaded() {
	}

	public void onErrorOnLoadChildModule(Throwable reason) {
		eventBus.showMessage(MessageType.ERROR,
				UiMessages.INSTANCE.childModuleLoadingError() + " " + reason.getMessage());
	}
}
