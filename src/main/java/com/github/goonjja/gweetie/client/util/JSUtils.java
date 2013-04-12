/**
 * 
 */
package com.github.goonjja.gweetie.client.util;

/**
 * @author Ведерников Сергей
 * @date 13.02.2012
 */
public class JSUtils {

	public static native void initTooltips()
	/*-{
		$wnd.$(function() {
			$wnd.$('a[rel=tooltip]').tooltip();
		});
	}-*/;

	public static native void hideTooltips()/*-{
		$wnd.$('a[rel=tooltip]').tooltip('hide');
	}-*/;

	public static native void copyToClipboardFrom(String data) /*-{
		$wnd.clipboardData.setData('text', data);
	}-*/;

	public static native void setWaitCursor() /*-{
		$wnd.document.body.style.cursor = 'wait';
	}-*/;

	public static native void setDefaultCursor() /*-{
		$wnd.document.body.style.cursor = 'default';
	}-*/;

	public static native void scrollToTop()
	/*-{
		$wnd.scroll(0, 0);
	}-*/;

	public static native void initPopovers()
	/*-{
		$wnd.$(function() {
			$wnd.$("div[rel=popover]").popover({
				offset : 10
			}).click(function(e) {
				e.preventDefault();
			});
		});
	}-*/;

	public static native void hidePopovers()
	/*-{
		$wnd.$(function() {
			$wnd.$("div[rel=popover]").popover('hide');
		});
	}-*/;

}
