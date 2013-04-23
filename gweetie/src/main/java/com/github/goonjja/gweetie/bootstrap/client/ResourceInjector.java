package com.github.goonjja.gweetie.bootstrap.client;

import com.github.goonjja.gweetie.bootstrap.client.resources.BootstrapResources;
import com.google.gwt.dom.client.BodyElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.HeadElement;
import com.google.gwt.dom.client.ScriptElement;
import com.google.gwt.dom.client.StyleInjector;

/**
 * Injects bootstrap resources (css, js) to host page
 * 
 * @author Ведерников Сергей
 * @date 11.05.2012
 */
public class ResourceInjector {
	public static void configure() {
		injectJs(getBody(), BootstrapResources.INSTANCE.jqueryJs().getText(), true);
		injectJs(getBody(), BootstrapResources.INSTANCE.bootstrapJs().getText(), true);
		StyleInjector.inject(BootstrapResources.INSTANCE.bootstrapCss().getText());
		StyleInjector.inject(BootstrapResources.INSTANCE.bootstrapResponsiveCss().getText());
		StyleInjector.inject(BootstrapResources.INSTANCE.navBarFixCss().getText());
	}

	private static void injectJs(Element container, String javascript, boolean insertFirst) {
		ScriptElement element = createScriptElement();
		element.setText(javascript);
		if (insertFirst)
			container.insertFirst(element);
		else
			container.appendChild(element);
	}

	private static ScriptElement createScriptElement() {
		ScriptElement script = Document.get().createScriptElement();
		script.setAttribute("type", "text/javascript");
		return script;
	}

	private static HeadElement head;
	private static BodyElement body;

	/**
	 * Gets the document header.
	 * 
	 * @return the document header
	 */
	protected static HeadElement getHead() {
		if (head == null) {
			Element element = Document.get().getElementsByTagName("head").getItem(0);
			assert element != null : "HTML Head element required";
			HeadElement head = HeadElement.as(element);
			ResourceInjector.head = head;
		}
		return ResourceInjector.head;
	}

	protected static BodyElement getBody() {
		if (body == null) {
			Element element = Document.get().getElementsByTagName("body").getItem(0);
			assert element != null : "HTML body element required";
			BodyElement body = BodyElement.as(element);
			ResourceInjector.body = body;
		}
		return ResourceInjector.body;
	}
}
