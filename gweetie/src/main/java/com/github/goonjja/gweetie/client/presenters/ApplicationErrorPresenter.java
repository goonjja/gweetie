package com.github.goonjja.gweetie.client.presenters;



import com.github.goonjja.gweetie.client.mvp4g.AppEventBus;
import com.github.goonjja.gweetie.client.views.ApplicationError;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view = ApplicationError.class)
public class ApplicationErrorPresenter extends BasePresenter<ApplicationError, AppEventBus> {

	public void onLoad(String message) {
		view.setMessage(message);
		eventBus.setView(view.asWidget());
	}
}
