package com.github.goonjja.gweetie.demo.client.presenters.dashboard;

import com.github.goonjja.gweetie.core.handlers.LayoutPlace;
import com.github.goonjja.gweetie.demo.client.core.DashboardEventBus;
import com.github.goonjja.gweetie.demo.client.ui.LayoutPlaces;
import com.github.goonjja.gweetie.demo.client.ui.dashboard.Dashboard;
import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view = Dashboard.class)
public class DashboardPresenter extends BasePresenter<Dashboard, DashboardEventBus> {

	public void onDashboard() {
		getView().getSubview().clear();
	}

	public void onShowDeeper(Widget deeper) {
		eventBus.loadView(LayoutPlaces.Content, deeper);
	}

	public void onLoadView(LayoutPlace place, Widget view) {
		getView().getSubview().setWidget(view);
	}
}
