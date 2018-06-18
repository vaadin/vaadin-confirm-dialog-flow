package com.vaadin.flow.component.confirmdialog.test.hiptest;

import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.flow.component.dialog.testbench.DialogElement;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.elementsbase.Element;

@Element("vaadin-confirm-dialog")
public class ConfirmDialogElement extends TestBenchElement {

	private TestBenchElement getOverlayContext() {
		return $("vaadin-dialog-overlay").onPage().first().$("div").id("content");
	}

	private ButtonElement getButton(String defaultId, String diyId) {
		ButtonElement button = getOverlayContext().$(ButtonElement.class).id(defaultId);
		if (button.isDisplayed()) {
			return button;
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
