package com.mamoslab.utils;

import java.awt.Component;
import java.awt.Container;

public class GuiUtils {

	public static void setEverythingEnabled(Component component, boolean enabled) {
		component.setEnabled(enabled);
		if (component instanceof Container) {
			for (Component component_ : ((Container) component).getComponents()) {
				setEverythingEnabled(component_, enabled);
			}
		}
	}
}
