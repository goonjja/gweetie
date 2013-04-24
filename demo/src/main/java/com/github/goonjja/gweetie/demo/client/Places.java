package com.github.goonjja.gweetie.demo.client;

import com.github.goonjja.gweetie.client.mvp4g.navigation.GweetiePlace;

/**
 * Mapping beetween mvp4g modules and hisotry tokens (event names). Contains all
 * application places.
 * 
 * @author Ведерников Сергей
 * 
 */
public enum Places implements GweetiePlace {
	Home(Names.ROOT_MODULE, Names.MAIN_PAGE_PLACE), ChildRoot(Names.CHILD_MODULE, Names.CHILD_ROOT_PLACE);

	public static final class Names {
		private Names() {
		}

		public final static String ROOT_MODULE = "";

		public final static String CHILD_MODULE = "child";

		public final static String MAIN_PAGE_PLACE = "";

		public final static String CHILD_ROOT_PLACE = "root";
	}

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
