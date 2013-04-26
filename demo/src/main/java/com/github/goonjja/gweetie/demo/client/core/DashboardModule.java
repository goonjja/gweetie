package com.github.goonjja.gweetie.demo.client.core;

import com.mvp4g.client.Mvp4gModule;
import com.mvp4g.client.annotation.module.HistoryName;

@HistoryName(DashboardModule.NAME)
public interface DashboardModule extends Mvp4gModule{
	public static final String NAME = "dashboard";
	
	public final static String MAIN_PAGE = "dashboard";
}
