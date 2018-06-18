package com.vaadin.flow.component.confirmdialog.examples;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.router.Route;

@Route("Features")
@BodySize
public class Features extends Div {

    static final String CONFIRM_DIALOG = "SampleConfirmDialog";
    static final String CONFIRM_DELETE_DIALOG = "SampleConfirmDeleteDialog";
    static final String CONFIRM_PUBLISH_DIALOG = "SampleConfirmPublishDialog";
    static final String UNSAVED_CHANGES_DIALOG = "SampleUnsavedChangesDialog";

    private Div status = new Div(new Text(""));

    public Features() {
        add(status);
        Map<String, Function<String, ConfirmDialog>> samples = new HashMap<>();
        samples.put(CONFIRM_DIALOG, this::createConfirmDialog);
        samples.put(CONFIRM_DELETE_DIALOG, this::createConfirmDeleteDialog);
        samples.put(CONFIRM_PUBLISH_DIALOG, this::createConfirmPublishDialog);
        samples.put(UNSAVED_CHANGES_DIALOG, this::createUnsavedChangesDialog);
        samples.entrySet().forEach(
                entry -> createSample(entry.getKey(), entry.getValue()));
    }

    private void createSample(String sample,
            Function<String, ConfirmDialog> creator) {
        Button button = new Button(sample);
        button.setId(sample);
        button.addClickListener(event -> openSample(creator.apply(sample)));
        add(button);
    }

    private ConfirmDialog createConfirmDialog(String sample) {
        ConfirmDialog dialog = new ConfirmDialog("Meeting starting",
                "Your next meeting starts in 5 minutes", "OK", this::onOK);
        dialog.setId(sample);
        return dialog;
    }

    private ConfirmDialog createConfirmDeleteDialog(String sample) {
        ConfirmDialog dialog = new ConfirmDialog("Delete product",
                "Are you sure you want to delete? This operation can not be undone.",
                "Delete", this::onDelete, "Cancel", this::onCancel);
        dialog.setConfirmButtonTheme("error primary");
        dialog.setId(sample);
        return dialog;
    }

    private ConfirmDialog createConfirmPublishDialog(String sample) {
        ConfirmDialog dialog = new ConfirmDialog("Ready to publish?",
                "Do you want to publish this post?", "Publish", this::onPublish,
                "Cancel", this::onCancel);
        dialog.setId(sample);
        return dialog;
    }

    private ConfirmDialog createUnsavedChangesDialog(String sample) {
        ConfirmDialog dialog = new ConfirmDialog("Usaved changes",
                "Do you want to save or discard your changes before navigating away?",
                "Save", this::onSave, "Discard", this::onDiscard, "Cancel",
                this::onCancel);
        dialog.setId(sample);
        return dialog;
    }

    private void openSample(ConfirmDialog dialog) {
        status.setText("");
        dialog.open();
    }

    private void onOK(Object event) {
        status.add(new Text("Ok clicked"));
    }

    private void onPublish(Object event) {
        status.add(new Text("Publish clicked"));
    }

    private void onSave(Object event) {
        status.add(new Text("Save clicked"));
    }

    private void onDelete(Object event) {
        status.add(new Text("Delete clicked"));
    }

    private void onDiscard(Object event) {
        status.add(new Text("Discard clicked"));
    }

    private void onCancel(Object event) {
        status.add(new Text("Cancel clicked"));
    }

}
