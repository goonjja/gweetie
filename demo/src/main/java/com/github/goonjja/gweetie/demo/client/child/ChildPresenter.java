package com.github.goonjja.gweetie.demo.client.child;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view = ChildView.class)
public class ChildPresenter extends BasePresenter<ChildView, ChildBus> {

	public void onShowChild() {
		eventBus.loadView(null, getView());
	}
}
