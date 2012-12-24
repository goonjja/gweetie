package me.goonjja.gwt.scrim.client.presenters;


import me.goonjja.gwt.scrim.client.mvp4g.AppEventBus;
import me.goonjja.gwt.scrim.client.views.ApplicationError;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view = ApplicationError.class)
public class ApplicationErrorPresenter extends BasePresenter<ApplicationError, AppEventBus> {

	public void onLoad(String message) {
		view.setMessage(message);
		eventBus.setView(view.asWidget());
	}
}
