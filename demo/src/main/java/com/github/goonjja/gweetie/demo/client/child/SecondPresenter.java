package com.github.goonjja.gweetie.demo.client.child;

import com.github.goonjja.gweetie.core.handlers.MessageType;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view = View2.class)
public class SecondPresenter extends BasePresenter<View2, ChildBus2> {

	public void onGoToView2(String param) {
		eventBus.loadView(null, getView());
		eventBus.showMessage(MessageType.INFO, "Param:" + param);
	}
}
