package com.github.goonjja.gweetie.client.util;

import java.util.logging.Logger;

import com.mvp4g.client.event.DefaultMvp4gLogger;

public class Mvp4gLogger extends DefaultMvp4gLogger {
	private final static Logger log = Logger.getLogger("mvp4g");
	static final String INDENT = "    ";

	@Override
	public void log(String message, int depth) {
		// log to dev mode
		super.log(message, depth);
		// log to normal logging
		log.fine(createLogMessage(message, depth));
	}

	private String createLogMessage(String message, int depth) {
		if (depth == 0) {
			return message;
		} else {
			StringBuilder indent = new StringBuilder(message.length() + depth * INDENT.length());
			for (int i = 0; i < depth; ++i) {
				indent.append(INDENT);
			}
			indent.append(message);
			return indent.toString();
		}
	}
}
