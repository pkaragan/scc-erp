package mx.mintik.mbs.core.ui.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import mx.mintik.mbs.core.backend.services.AppUserDetailsService;

@Route("login")
@PageTitle("Login | Mintik MBS")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

    private LoginForm login = new LoginForm();

    public LoginView() {
        addClassName("login-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        add(configureLoginLayout());
    }

    public Component configureLoginLayout()
    {
        VerticalLayout loginLayout = new VerticalLayout();
        loginLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        loginLayout.setId("login-layout");

        Image logo = new Image("images/mintik-logo-black-small.png", "Mintik MBS logo");
        loginLayout.add(logo);
        loginLayout.add(new Html("<h1>MBS <b>Machine Builder Suite</b></h1>"));
        
        login.setAction("login");
        loginLayout.add(login);

        return loginLayout;
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if(beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            login.setError(true);
        }
    }
}
