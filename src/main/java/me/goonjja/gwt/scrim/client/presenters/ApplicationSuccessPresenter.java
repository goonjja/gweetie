package me.goonjja.gwt.scrim.client.presenters;


import me.goonjja.gwt.scrim.client.mvp4g.AppEventBus;
import me.goonjja.gwt.scrim.client.views.ApplicationSuccess;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

/**
 * 
 * @author Ведерников Сергей
 * @date 02.02.2012
 */
@Presenter(view = ApplicationSuccess.class)
public class ApplicationSuccessPresenter extends BasePresenter<ApplicationSuccess, AppEventBus> {

	public void onLoad(String title, String text) {
		if (title != null)
			view.setFormTitle(title);
		if (text != null)
			view.setFormText(text);
		eventBus.setView(view.asWidget());
	}
}
