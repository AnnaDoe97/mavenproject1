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
    private Company selected;
    private EditLayout editLayout = new EditLayout(this);

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
        Button add = new Button("Добавить новую", clickEvent -> {
                companyView.setPopupVisible(true);
        });

        List<Company> allComp = companyDAO.getAllCompany();



//        PopupView upd = new PopupView(null, new UpdDelLayout());
        PopupView upd = new PopupView(null, editLayout);

        Grid<Company> grid = new Grid<>();
        grid.setItems(allComp);
        grid.addColumn(Company::getCompanyName).setCaption("Название \nкомпании");
        grid.addColumn(Company::getAddress).setCaption("Адрес");
        grid.addColumn(Company::getInn).setCaption("ИНН");
        grid.addColumn(Company::getTel).setCaption("Телефон");
        grid.addColumn(Company::getId).setHidden(true).setWidth(0);

        grid.setWidth("100%");



//        CompanyLayout grid1 = new CompanyLayout();
        for1.addComponents(add, companyView, upd, choose, grid, popup);

                grid.addSelectionListener(event -> {
            upd.setPopupVisible(true);
            System.out.println(grid.getSelectedItems());
            Company selectedObj = (Company) grid.getSelectedItems().iterator().next();
//            selected = (Company) selectedObj;
//            System.out.println(event.getAllSelectedItems());
            System.out.println(selectedObj);
            




//            CompanyDAO company = (CompanyDAO) event.getAllSelectedItems();
//                    System.out.println(company.getId());
//            System.out.println(event.getFirstSelectedItem());

        });
        upd.addPopupVisibilityListener(event -> {
            if (!event.isPopupVisible()){
                grid.getDataProvider().refreshAll();
            }
        });


//    grid.addColumn(Person::getDateBirth).setCaption("Year of birth");
        
        setContent(for1);
//        for1.setHeight("100%");



    }
//    public Company getSelected() {
//        return selected;
//    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
