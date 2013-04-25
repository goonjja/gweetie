package com.github.goonjja.gweetie.demo.client.child;

import com.mvp4g.client.Mvp4gModule;
import com.mvp4g.client.annotation.module.HistoryName;

@HistoryName(SubModule2.NAME)
public interface SubModule2 extends Mvp4gModule {
	public final static String NAME = "child2";
}
