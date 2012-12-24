/**
 * 
 */
package me.goonjja.gwt.scrim.widgets.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Ведерников Сергей
 * @date 10.02.2012
 */
public class ProgressBar extends Composite {

	private static ProgressBarUiBinder uiBinder = GWT
			.create(ProgressBarUiBinder.class);

	interface ProgressBarUiBinder extends UiBinder<Widget, ProgressBar> {
	}

	@UiField
	HTMLPanel progressBar;

	@UiField
	DivElement progressBarValueDiv;

	@UiField
	InlineLabel progressText;

	public ProgressBar() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setValue(int percent) {
		if (percent > 100) {
			setValue(100);
			return;
		}
		if (percent < 0) {
			setValue(0);
			return;
		}
		progressBarValueDiv.setAttribute("style", "width:" + percent + "%");
	}

	public void setProgressText(String text) {
		progressText.setText(text);
	}

	public void setType(String type) {
		progressBar.removeStyleName("progress-danger");
		progressBar.removeStyleName("progress-info");
		progressBar.removeStyleName("progress-success");
		if (type.equals("danger"))
			progressBar.addStyleName("progress-danger");
		else if (type.equals("info"))
			progressBar.addStyleName("progress-info");
		else if (type.equals("success"))
			progressBar.addStyleName("progress-success");

	}
}
