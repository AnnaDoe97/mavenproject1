package com.mycompany.mavenproject1;

import com.google.common.collect.Table;
import com.sun.webkit.ContextMenuItem;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import com.vaadin.ui.renderers.ButtonRenderer;
import com.vaadin.ui.themes.ValoTheme;
import dao.CompanyDAO;
import dao.DAOFactory;
import object.Company;

import java.util.Collection;
import java.util.List;


public class CompanyLayout extends CustomComponent {

    private CompanyDAO companyDAO;
    private Button deleteButton;

//    private Button buildDeleteButton(Company c) {
//        Button button = new Button();
//        button.addStyleName(ValoTheme.BUTTON_SMALL);
//        return button;
//    }

    public CompanyLayout(){
        companyDAO = DAOFactory.getInstance().getCompanyDAO();

        Collection<Company> companies = companyDAO.getAllCompany();


        List<Company> allComp = companyDAO.getAllCompany();




        Grid<Company> grid = new Grid<>();
        grid.setItems(allComp);
        grid.addColumn(Company::getCompanyName).setCaption("Название \nкомпании");
        grid.addColumn(Company::getAddress).setCaption("Адрес");
        grid.addColumn(Company::getInn).setCaption("ИНН");
        grid.addColumn(Company::getTel).setCaption("Телефон");
//        grid.getColumn("del").setRenderer(new ContextMenu());
//        grid.addColumn(new NativeButtonRenderer<>("Remove", item -> {
//            ListDataProvider<Item> dataProvider = (ListDataProvider<Item>) grid.getDataProvider();
//            dataProvider.getItems().remove(item);
//            dataProvider.refreshAll();
//        }))
//                .setHeader("Action");
//        grid.addColumn(remove)

        /**
         * TRY F*****G CONTEXT MENU
         */



        grid.setWidth("100%");

//        PopupView companyView = new PopupView(null, new PopUpLauout());
//
//        grid.addSelectionListener(event -> {
//            companyView.setPopupVisible(true);
//            System.out.println("ere");
//        });
        setCompositionRoot(grid);

//        List<Company> allComp = companyDAO.getAllCompany();
//        allComp.forEach(System.out::println);


    }

}
