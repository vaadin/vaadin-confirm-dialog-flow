package com.vaadin.flow.component.confirmdialog.test.hiptest;

import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.flow.component.dialog.testbench.DialogElement;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.elementsbase.Element;

@Element("vaadin-confirm-dialog")
public class ConfirmDialogElement extends TestBenchElement {

	private DialogElement getDialog() {
		return $(DialogElement.class).first();
	}

	public ButtonElement getConfirmButton() {
		return getDialog().$(ButtonElement.class).id("confirm");
	}

	public ButtonElement getRejectButton() {
		return getDialog().$(ButtonElement.class).id("reject");
	}

	public ButtonElement getCancelButton() {
		return getDialog().$(ButtonElement.class).id("cancel");
	}
}
