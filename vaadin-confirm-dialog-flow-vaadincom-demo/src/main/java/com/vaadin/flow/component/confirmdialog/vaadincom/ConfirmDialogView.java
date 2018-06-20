package com.vaadin.flow.component.confirmdialog.vaadincom;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.demo.DemoView;
import com.vaadin.flow.router.Route;

@Route("vaadin-confirm-dialog")
public class ConfirmDialogView extends DemoView {

    @Override
    protected void initView() {
        meetingStartingAlert();
        confirmDeleteDialog();
        confirmPublishDialog();
        unsavedChangesDialog();
    }

    private void createCard(String heading, String buttonText, ConfirmDialog dialog) {
        Button button = new Button(buttonText);
        button.addClickListener(event -> dialog.open());
        addCard(heading, button);
    }

    private void meetingStartingAlert() {
        // @formatter:off
        // begin-source-example
        // source-example-heading: Basic Alert Dialog Example
        ConfirmDialog dialog = new ConfirmDialog("Meeting starting",
                "Your next meeting starts in 5 minutes", "OK", this::onOK);
        // end-source-example
        // @formatter:on

        createCard("Basic Alert Dialog Example", "Show alert", dialog);
    }

    private void confirmDeleteDialog() {
        // @formatter:off
        // begin-source-example
        // source-example-heading: Confirm Delete Dialog Example
        ConfirmDialog dialog = new ConfirmDialog("Delete product",
                "Are you sure you want to delete? This operation can not be undone.",
                "Delete", this::onDelete, "Cancel", this::onCancel);
        dialog.setConfirmButtonTheme("error primary");
        // end-source-example
        // @formatter:on

        createCard("Confirm Delete Dialog Example", "Delete item", dialog);
    }

    private void confirmPublishDialog() {
        // @formatter:off
        // begin-source-example
        // source-example-heading: Confirmation Dialog Example
        ConfirmDialog dialog = new ConfirmDialog("Ready to publish?",
                "Do you want to publish this post?", "Publish", this::onPublish,
                "Cancel", this::onCancel);
        // end-source-example
        // @formatter:on

        createCard("Confirmation Dialog Example", "Publish", dialog);
    }

    private void unsavedChangesDialog() {
        // @formatter:off
        // begin-source-example
        // source-example-heading: Save or Discard Dialog Example
        ConfirmDialog dialog = new ConfirmDialog("Unsaved changes",
                "Do you want to save or discard your changes before navigating away?",
                "Save", this::onSave, "Discard", this::onDiscard, "Cancel",
                this::onCancel);
        // end-source-example
        // @formatter:on

        createCard("Save or Discard Dialog Example", "Close", dialog);
    }

    // @formatter:off
    // begin-source-example
    // source-example-heading: Basic Alert Dialog Example
    private void showNotification(String buttonPressed, Object eventGenerated) {
        Notification notification = new Notification(buttonPressed + " button was pressed and "
                + eventGenerated.getClass().getSimpleName()
                + " event was fired", 3000,
                Notification.Position.MIDDLE);
        notification.open();
    }

    private void onOK(Object event) {
        showNotification("OK", event);
    }
    // end-source-example
    // @formatter:on

    private void onPublish(Object event) {
        showNotification("Publish", event);
    }

    private void onSave(Object event) {
        showNotification("Save", event);
    }

    private void onDiscard(Object event) {
        showNotification("Discard", event);
    }

    private void onDelete(Object event) {
        showNotification("Delete", event);
    }

    private void onCancel(Object event) {
        showNotification("Cancel", event);
    }

}
