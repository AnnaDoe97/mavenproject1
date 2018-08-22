package com.mycompany.mavenproject1;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vaadin.ui.TabSheet.Tab;
import dao.CompanyDAO;
import dao.DAOFactory;
import object.Company;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        CompanyDAO companyDAO = DAOFactory.getInstance().getCompanyDAO();

        VerticalLayout for1 = new VerticalLayout();
        Button choose = new Button("Выбрать из существующих");




        /**
         * POPUP TEST
         */

        VerticalLayout popupContent = new VerticalLayout();
        popupContent.addComponent(new TestLayout());
        popupContent.addComponent(new Button("Button"));

// The component itself
        PopupView popup = new PopupView("Pop it up", popupContent);


        PopupView companyView = new PopupView(null, new PopUpLauout());
        Button add = new Button("Добавить новую", clickEvent ->
                companyView.setPopupVisible(true));

        for1.addComponents(add, companyView, choose, new CompanyLayout(), popup);


//    grid.addColumn(Person::getDateBirth).setCaption("Year of birth");
        
        setContent(for1);
//        for1.setHeight("100%");



    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
