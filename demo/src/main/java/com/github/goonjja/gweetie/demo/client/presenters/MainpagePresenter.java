package com.github.goonjja.gweetie.demo.client.presenters;

import com.github.goonjja.gweetie.demo.client.core.AppEventBus;
import com.github.goonjja.gweetie.demo.client.ui.LayoutPlaces;
import com.github.goonjja.gweetie.demo.client.ui.Mainpage;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view = Mainpage.class)
public class MainpagePresenter extends BasePresenter<Mainpage, AppEventBus> {

	public void onMainpage() {
		eventBus.loadView(LayoutPlaces.Content, getView());
	}
}
