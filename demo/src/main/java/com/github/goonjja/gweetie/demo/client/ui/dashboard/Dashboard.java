package com.github.goonjja.gweetie.demo.client.ui.dashboard;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class Dashboard extends Composite {

	private static DashboardUiBinder uiBinder = GWT.create(DashboardUiBinder.class);

	interface DashboardUiBinder extends UiBinder<Widget, Dashboard> {
	}

	@UiField
	SimplePanel subview;

	public Dashboard() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public SimplePanel getSubview() {
		return subview;
	}

}
