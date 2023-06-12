package org.vaadin.addons.thshsh.progress;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.server.AppShellSettings;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@SuppressWarnings("serial")
@Theme(themeClass = Lumo.class)
//@PWA(name = AddonAppShellConfigurator.APP_NAME, shortName = AddonAppShellConfigurator.APP_NAME_SHORT,iconPath = "icons/clario-icon.png")
@Push()

//@EnableAdminServer
public class AddonAppShellConfigurator implements AppShellConfigurator {


    @Override
	public void configurePage(AppShellSettings settings) {
		//LoadingIndicatorConfiguration conf = settings.getLoadingIndicatorConfiguration().orElseGet(null);
		
	}
}
