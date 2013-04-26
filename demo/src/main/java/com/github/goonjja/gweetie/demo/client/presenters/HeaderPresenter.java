package com.github.goonjja.gweetie.demo.client.presenters;

import javax.inject.Singleton;

import com.github.goonjja.gweetie.core.GweetieRootEventBus;
import com.github.goonjja.gweetie.core.handlers.NavigationHandler;
import com.github.goonjja.gweetie.core.navigation.GweetiePlace;
import com.github.goonjja.gweetie.core.navigation.GweetiePlacesProvider;
import com.github.goonjja.gweetie.demo.client.core.AppEventBus;
import com.github.goonjja.gweetie.demo.client.navigation.Places;
import com.github.goonjja.gweetie.demo.client.ui.Header;
import com.github.goonjja.gweetie.demo.client.ui.LayoutPlaces;
import com.github.goonjja.gweetie.demo.client.ui.UiMessages;
import com.github.goonjja.gweetie.widgets.Nav;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Singleton
@Presenter(view = Header.class)
public class HeaderPresenter extends BasePresenter<Header, GweetieRootEventBus> implements NavigationHandler {
	private boolean headerInitialized = false;
	@Inject
	GweetiePlacesProvider placesProvider;

	@Override
	public void bind() {
		super.bind();

		Nav nav = view.getNav();
		nav.add(GweetiePlace.Util.getLink(Places.Home, placesProvider.isCrawlable()), "Main Page",
				Places.Home.toString());
		nav.add(GweetiePlace.Util.getLink(Places.Dashboard, placesProvider.isCrawlable()), "Dashboard",
				Places.Dashboard.toString());
		nav.add(GweetiePlace.Util.getLink(Places.Deeper, placesProvider.isCrawlable()), "Deep page!",
				Places.Deeper.toString());

		// activate home item by default
		nav.setSelectedItem(0, false);
	}

	/**
	 * Called when application is started in client's browser
	 */
	public void onLoadHeader() {
		if (headerInitialized)
			return;
		headerInitialized = true;
		// send not null place
		eventBus.loadView(LayoutPlaces.Header, view);
	}

	@Override
	public void onNavigated(GweetiePlace place) {
		// activate corresponding link
		if (place == Places.Home) {
			eventBus().mainpage();
			return;
		}
		view.getNav().setSelectedItem(place.toString(), false);
	}

	@Override
	public void onPageNotFound() {
		eventBus().showNotification(UiMessages.INSTANCE.pageNotFoundMessageTitle(),
				UiMessages.INSTANCE.pageNotFoundMessageText());
	}

	private AppEventBus eventBus() {
		return (AppEventBus) eventBus;
	}
}