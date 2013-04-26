package com.github.goonjja.gweetie.demo.client.core;

import com.mvp4g.client.Mvp4gModule;
import com.mvp4g.client.annotation.module.HistoryName;

@HistoryName(DeeperModule.NAME)
public interface DeeperModule extends Mvp4gModule {
	public static final String NAME = "deeper";
	
	public static final String MAIN_PAGE = "deep";
}
