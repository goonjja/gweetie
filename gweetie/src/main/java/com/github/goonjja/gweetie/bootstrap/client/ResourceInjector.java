package com.github.goonjja.gweetie.bootstrap.client;



import com.github.goonjja.gweetie.bootstrap.client.resources.BootstrapResources;
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
		injectJs(BootstrapResources.INSTANCE.bootstrapJs().getText());
		StyleInjector.inject(BootstrapResources.INSTANCE.bootstrapCss().getText());
		StyleInjector.inject(BootstrapResources.INSTANCE.bootstrapResponsiveCss().getText());
		StyleInjector.inject(BootstrapResources.INSTANCE.navBarFixCss().getText());
	}

	private static void injectJs(String javascript) {
		HeadElement head = getHead();
		ScriptElement element = createScriptElement();
		element.setText(javascript);
		head.appendChild(element);
	}

	private static ScriptElement createScriptElement() {
		ScriptElement script = Document.get().createScriptElement();
		script.setAttribute("type", "text/javascript");
		return script;
	}

	private static HeadElement head;

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
}
