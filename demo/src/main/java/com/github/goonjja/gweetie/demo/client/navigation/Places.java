package com.github.goonjja.gweetie.demo.client.navigation;

import com.github.goonjja.gweetie.core.navigation.GweetiePlace;
import com.github.goonjja.gweetie.demo.client.core.DashboardModule;
import com.github.goonjja.gweetie.demo.client.core.DeeperModule;

/**
 * Mapping beetween mvp4g modules and hisotry tokens (event names). Contains all
 * application places.
 * 
 * @author Ведерников Сергей
 * 
 */
public enum Places implements GweetiePlace {
	Home("", ""),

	Dashboard(DashboardModule.NAME, DashboardModule.MAIN_PAGE),

	// it's important to set module name this way, to make history converter
	// know modules hierarchy
	Deeper(DashboardModule.NAME + "/" + DeeperModule.NAME, DeeperModule.MAIN_PAGE);

	/*
	 * --------------------------------------------------------------------------
	 */
	private String module;
	private String historyName;
	// Required for converting event arguments
	// to semantically "valid" token, e.g.
	// service-administration/serviceId=...
	private String[] argNames;

	Places(String module, String historyName) {
		this.module = module;
		this.historyName = historyName;
	}

	Places(String module, String historyName, String[] argNames) {
		this.module = module;
		this.historyName = historyName;
		this.argNames = argNames;
	}

	@Override
	public String getModule() {
		return module;
	}

	@Override
	public String getHistoryName() {
		return historyName;
	}

	@Override
	public String[] getArgNames() {
		return argNames;
	}

	@Override
	public String toString() {
		return getHistoryName();
	}

}
