package com.vaadin.flow.component.confirmdialog.test;

import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.elementsbase.Element;
import org.openqa.selenium.WebDriverException;

@Element("vaadin-confirm-dialog")
public class ConfirmDialogElement extends TestBenchElement {

	private TestBenchElement getOverlayContext() {
		return $("vaadin-dialog-overlay").onPage().first().$(TestBenchElement.class).id("content");
	}

	private ButtonElement getButton(String defaultId, String diyId) {
		try {
			ButtonElement button = getOverlayContext().$(ButtonElement.class).id(defaultId);
			if (button.getLocation().getY() != 0) {
				return button;
			}
		} catch (WebDriverException e) {
			//NOOP
		}
		return  getOverlayContext().$(ButtonElement.class).id(diyId);
	}


	public ButtonElement getConfirmButton() {
		return getButton("confirm", "confirmDiy");
	}

	public ButtonElement getRejectButton() {
		return getButton("reject", "rejectDiy");
	}

	public ButtonElement getCancelButton() {
		return getButton("cancel", "cancelDiy");
	}
}
