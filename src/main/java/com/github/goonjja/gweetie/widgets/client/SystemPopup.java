package com.github.goonjja.gweetie.widgets.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.DecoratedPopupPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;

/**
 * Всплывающее окно системы
 * 
 * @author ashuiskov
 * @date 18.06.2010
 */
@Deprecated
public class SystemPopup extends DecoratedPopupPanel {
	private static SystemPopup INSTANCE;

	private static final String SENDING_REQUEST_MESSAGE = "Отправка запроса, пожалуйста подождите...";
	private HTML text = new HTML();

	public static SystemPopup getInstance() {
		if (INSTANCE == null)
			INSTANCE = GWT.create(SystemPopup.class);
		return INSTANCE;
	}

	private SystemPopup() {
		this(SENDING_REQUEST_MESSAGE);
		setVisible(false);
	}

	private SystemPopup(String html) {
		super();
		HorizontalPanel hPanel = new HorizontalPanel();
		text.setText(html);
		hPanel.add(text);
		setWidget(hPanel);
		setGlassEnabled(true);
		setAnimationEnabled(true);
		center();
		setAutoHideEnabled(false);
		setVisible(false);
	}

	public void setText(String html) {
		text.setHTML(html);
	}

	public void show(String html) {
		setText(html);
		super.show();
		setVisible(true);
	}
}
