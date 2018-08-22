package com.mycompany.mavenproject1;

import com.google.common.collect.Table;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import dao.CompanyDAO;
import dao.DAOFactory;
import object.Company;

import java.util.Collection;
import java.util.List;


public class CompanyLayout extends CustomComponent {

    private CompanyDAO companyDAO;

    public CompanyLayout(){
        companyDAO = DAOFactory.getInstance().getCompanyDAO();

        Collection<Company> companies = companyDAO.getAllCompany();


        List<Company> allComp = companyDAO.getAllCompany();

        Grid<Company> grid = new Grid<>();
        //        grid.setItems();
        grid.setItems(allComp);
        grid.addColumn(Company::getCompanyName).setCaption("Название \nкомпании");
        grid.addColumn(Company::getAddress).setCaption("Адрес");
        grid.addColumn(Company::getInn).setCaption("ИНН");
        grid.addColumn(Company::getTel).setCaption("Телефон");
        grid.setWidth("100%");

        setCompositionRoot(grid);

//        List<Company> allComp = companyDAO.getAllCompany();
//        allComp.forEach(System.out::println);


    }

}
