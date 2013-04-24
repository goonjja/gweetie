package com.github.goonjja.gweetie.client.presenters;

import javax.inject.Singleton;

import com.github.goonjja.gweetie.client.FrameworkUIMessages;
import com.github.goonjja.gweetie.client.core.LayoutHandler;
import com.github.goonjja.gweetie.client.core.MessageHandler;
import com.github.goonjja.gweetie.client.core.MessageType;
import com.github.goonjja.gweetie.client.core.NavigationHandler;
import com.github.goonjja.gweetie.client.core.UiLockHandler;
import com.github.goonjja.gweetie.client.mvp4g.RootModuleEventBus;
import com.github.goonjja.gweetie.client.mvp4g.navigation.GweetiePlace;
import com.github.goonjja.gweetie.client.util.JSUtils;
import com.github.goonjja.gweetie.client.views.Layout;
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
public class DefaultLayoutPresenter extends BasePresenter<Layout, RootModuleEventBus> implements MessageHandler,
		UiLockHandler, NavigationHandler, LayoutHandler {

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
		eventBus.unlockScreen();

		JSUtils.initTooltips();
		eventBus.hideMessages();
	}

	public void onNavigated(GweetiePlace place) {
		JSUtils.hidePopovers();
		JSUtils.hideTooltips();
		eventBus.hideMessages();
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

	@Override
	public void onLockScreen() {
		view.loadDefaultBusyMessage();
		view.getBusyPopup().show();
	}

	@Override
	public void onUnlockScreen() {
		view.getBusyPopup().hide();
	}
}
