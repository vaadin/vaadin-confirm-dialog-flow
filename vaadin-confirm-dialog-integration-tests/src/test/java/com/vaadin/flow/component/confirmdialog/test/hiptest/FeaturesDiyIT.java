package com.vaadin.flow.component.confirmdialog.test.hiptest;

import com.vaadin.flow.component.confirmdialog.examples.FeaturesDiy;

public class FeaturesDiyIT extends FeaturesIT {

	@Override public void setup() throws Exception {
		super.setup();
		actionwords = new Actionwords(this, FeaturesDiy.class);
	}
}
