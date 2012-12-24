package me.goonjja.gwt.scrim.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @author vedernikov
 * @date 21.12.2012
 */
public class ApplicationSuccess extends Composite {
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	interface MyUiBinder extends UiBinder<Widget, ApplicationSuccess> {
	}

	@UiField
	public HTML titleHTML;
	@UiField
	public HTML textHTML;
	@UiField
	public Anchor redirectAnchor;

	public ApplicationSuccess() {
		initWidget(uiBinder.createAndBindUi(this));
		redirectAnchor.setHref("#");
		redirectAnchor.setText("Go to main page");
	}

	public void setFormTitle(String title) {
		titleHTML.setHTML("<h2>" + title + "</h2>");
	}

	public void setFormText(String text) {
		textHTML.setHTML(text);
	}
}