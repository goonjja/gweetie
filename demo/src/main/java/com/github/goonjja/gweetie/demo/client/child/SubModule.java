package com.github.goonjja.gweetie.demo.client.child;

import com.mvp4g.client.Mvp4gModule;
import com.mvp4g.client.annotation.module.HistoryName;

@HistoryName(SubModule.NAME)
public interface SubModule extends Mvp4gModule {
	public final static String NAME = "child";
}
