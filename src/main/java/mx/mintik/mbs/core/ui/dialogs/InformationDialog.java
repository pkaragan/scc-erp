package mx.mintik.mbs.core.ui.dialogs;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.shared.Registration;

public class InformationDialog extends Dialog {

    public InformationDialog(String text) {
        Div dialogText = new Div();
        dialogText.add(new Text(text));
        dialogText.addClassName("dialog-text");

        Button okButton = new Button("Ok");
        okButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        okButton.addClickShortcut(Key.ENTER);
        okButton.addClickListener(event -> {
            fireEvent(new OkEvent(this));
            close();
        });

        HorizontalLayout buttonsLayout = new HorizontalLayout(okButton);
        buttonsLayout.addClassName("dialog-buttons");
        buttonsLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.END);

        add(dialogText, buttonsLayout);
    }

    public static abstract class InformationDialogEvent extends ComponentEvent<InformationDialog> {
        public InformationDialogEvent(InformationDialog source) {
            super(source, false);
        }
    }

    public static class OkEvent extends InformationDialogEvent {
        public OkEvent(InformationDialog source) {
            super(source);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType, ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}
