package com.github.goonjja.gweetie.demo.client.presenters.dashboard.deeper;

import com.github.goonjja.gweetie.demo.client.core.DeeperEventBus;
import com.github.goonjja.gweetie.demo.client.ui.LayoutPlaces;
import com.github.goonjja.gweetie.demo.client.ui.dashboard.deeper.DeepPage;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view = DeepPage.class)
public class DeepPagePresenter extends BasePresenter<DeepPage, DeeperEventBus>{

	public void onDeeper(){
		eventBus.loadView(LayoutPlaces.Content, getView());
	}
}
