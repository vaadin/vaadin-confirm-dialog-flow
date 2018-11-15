package com.vaadin.flow.component.confirmdialog.test.hiptest;

import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.flow.component.confirmdialog.examples.Features;
import com.vaadin.flow.component.confirmdialog.testbench.ConfirmDialogElement;
import org.junit.Assert;
import org.junit.Test;

import com.vaadin.flow.component.confirmdialog.test.AbstractParallelTest;

public class FeaturesIT extends AbstractParallelTest {

    public Actionwords actionwords = new Actionwords(this);

    public void reminderDialog(String sampleName) throws Exception {
        actionwords.iHaveSampleDialog(sampleName);
        actionwords.iOpenDialogDialog(sampleName);
        actionwords.iCompareTheDialogToReferenceImage(sampleName);
        actionwords.iClickConfirm();
        actionwords.dialogDialogIsClosed(sampleName);
        actionwords.confirmEventIsFired();
    }

    @Test
    public void testReminderDialogBasicUid56bdf3b7f1a14bec8a6691ab5acd8c82() throws Exception {
        reminderDialog("SampleConfirmDialog");
    }


    public void confirmDeleteDialog(String sampleName) throws Exception {
        actionwords.iHaveSampleDialog(sampleName);
        actionwords.iOpenDialogDialog(sampleName);
        actionwords.iCompareTheDialogToReferenceImage(sampleName);
        actionwords.iClickConfirm();
        actionwords.dialogDialogIsClosed(sampleName);
        actionwords.confirmEventIsFired();
        actionwords.iOpenDialogDialog(sampleName);
        actionwords.iClickCancel();
        actionwords.dialogDialogIsClosed(sampleName);
        actionwords.cancelEventIsFired();
    }

    @Test
    public void testConfirmDeleteDialogBasicUid73a333b73ac94e83a079bdb9725411ce() throws Exception {
        confirmDeleteDialog("SampleConfirmDeleteDialog");
    }


    public void areYouSureYouWantToPublishDialog(String sampleName) throws Exception {
        actionwords.iHaveSampleDialog(sampleName);
        actionwords.iOpenDialogDialog(sampleName);
        actionwords.iCompareTheDialogToReferenceImage(sampleName);
        actionwords.iClickConfirm();
        actionwords.dialogDialogIsClosed(sampleName);
        actionwords.confirmEventIsFired();
        actionwords.iOpenDialogDialog(sampleName);
        actionwords.iClickCancel();
        actionwords.dialogDialogIsClosed(sampleName);
        actionwords.cancelEventIsFired();
    }

    @Test
    public void testAreYouSureYouWantToPublishDialogBasicUid4eb6bd3dd8bc4324b05c1d96c4972ca8() throws Exception {
        areYouSureYouWantToPublishDialog("SampleConfirmPublishDialog");
    }


    public void unsavedChangesDialog(String sampleName) throws Exception {
        actionwords.iHaveSampleDialog(sampleName);
        actionwords.iOpenDialogDialog(sampleName);
        actionwords.iCompareTheDialogToReferenceImage(sampleName);
        actionwords.iClickConfirm();
        actionwords.dialogDialogIsClosed(sampleName);
        actionwords.confirmEventIsFired();
        actionwords.iOpenDialogDialog(sampleName);
        actionwords.iClickReject();
        actionwords.dialogDialogIsClosed(sampleName);
        actionwords.rejectEventIsFired();
        actionwords.iOpenDialogDialog(sampleName);
        actionwords.iClickCancel();
        actionwords.dialogDialogIsClosed(sampleName);
        actionwords.cancelEventIsFired();
    }

    @Test
    public void testUnsavedChangesDialogBasicUid6064e2706c3d4e8993a17c07bcc49f7f() throws Exception {
        unsavedChangesDialog("SampleUnsavedChangesDialog");
    }

    @Test
    public void testDialogStrings() {
        open(Features.class, AbstractParallelTest.WINDOW_SIZE_MEDIUM);
        $(ButtonElement.class).id("SampleUnsavedChangesDialog").click();
        ConfirmDialogElement dialog = $(ConfirmDialogElement.class).waitForFirst();
        // TODO: uncomment when https://github.com/vaadin/vaadin-confirm-dialog-flow/issues/52 fixed
        // Assert.assertEquals("Unsaved changes", dialog.getHeaderText());
        Assert.assertEquals("Do you want to save or discard your changes before navigating away?",
                dialog.getMessageText());
        Assert.assertEquals("Save", dialog.getConfirmButton().getText());
        Assert.assertEquals("Discard", dialog.getRejectButton().getText());
        Assert.assertEquals("Cancel", dialog.getCancelButton().getText());
    }
}
