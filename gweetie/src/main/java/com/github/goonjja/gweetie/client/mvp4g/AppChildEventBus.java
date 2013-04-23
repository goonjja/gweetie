package com.github.goonjja.gweetie.client.mvp4g;

import com.github.goonjja.gweetie.client.mvp4g.navigation.AppPlace;
import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Event;

/**
 * Base EventBus for all child modules. Simplifying annotating common events
 * 
 * @author Ведерников Сергей
 * 
 */
public interface AppChildEventBus extends AppEventBus {

	@Event(forwardToParent = true)
	void setView(Widget newBody);

	@Event(forwardToParent = true)
	void setViewForwarded(Widget newBody);

	@Event(forwardToParent = true)
	void showProcessing(String title, String message);

	@Event(forwardToParent = true)
	void hideProcessing();

	@Event(forwardToParent = true)
	void showError(String message);

	@Event(forwardToParent = true)
	void showSuccess(String message);

	@Event(forwardToParent = true)
	void hideAlerts();

	@Event(forwardToParent = true)
	void navigated(AppPlace place);

	@Event(forwardToParent = true)
	void forbidden(Throwable cause);

	@Event(forwardToParent = true)
	void applicationError(String message);

	@Event(forwardToParent = true)
	void applicationSuccess(String title, String text);
}
