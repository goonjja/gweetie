/**
 * 
 */
package com.github.goonjja.gweetie.core.util;

/**
 * @author Ведерников Сергей
 * @date 13.02.2012
 */
public class JSUtils {
	public static native void scrollToTop()
	/*-{
		$wnd.scroll(0, 0);
	}-*/;

	public static native void initTooltips()
	/*-{
		$wnd.$(function() {
			$wnd.$('*[rel=tooltip]').tooltip();
		});
	}-*/;

	public static native void hideTooltips()
	/*-{
		$wnd.$('*[rel=tooltip]').tooltip('hide');
	}-*/;

	public static native void initPopovers()
	/*-{
		$wnd.$(function() {
			$wnd.$("*[rel=popover]").popover({
				offset : 10
			}).click(function(e) {
				e.preventDefault();
			});
		});
	}-*/;

	public static native void hidePopovers()
	/*-{
		$wnd.$(function() {
			$wnd.$("*[rel=popover]").popover('hide');
		});
	}-*/;

}
