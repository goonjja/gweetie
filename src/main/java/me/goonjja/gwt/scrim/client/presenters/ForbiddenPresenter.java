package me.goonjja.gwt.scrim.client.presenters;


import me.goonjja.gwt.scrim.client.mvp4g.AppEventBus;
import me.goonjja.gwt.scrim.client.views.Forbidden;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view = Forbidden.class)
public class ForbiddenPresenter extends BasePresenter<Forbidden, AppEventBus> {
	public void onLoad(Throwable cause) {
		view.setThrowable(cause);
		eventBus.setView(view.asWidget());
	}
}
