package com.mycompany.mavenproject1;

import com.google.common.collect.Table;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import dao.CompanyDAO;
import dao.DAOFactory;
import object.Company;
import object.Person;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class CompanyLayout extends CustomComponent {

    private CompanyDAO companyDAO;

    public CompanyLayout(){
        companyDAO = DAOFactory.getInstance().getCompanyDAO();

        Collection<Company> companies = companyDAO.getAllCompany();

        // Have a container of some type to contain the data
//    Table table = new Table("The Brightest Stars");
//
//// Define two columns for the built-in container
//    table.addContainerProperty("Name", String.class, null);
//    table.addContainerProperty("Mag",  Float.class, null);

//        List<Company> people = Arrays.asList(
////            new Person("Nicolaus Copernicus", "1543"),
////            new Person("Galileo Galilei", 1564),
////            new Person("Johannes Kepler", 1571)
//                companyDAO.getCompanyById(2),
//                companyDAO.getCompanyById(3)
//        );

        List<Company> allComp = companyDAO.getAllCompany();

        Grid<Company> grid = new Grid<>();
        //        grid.setItems();
        grid.setItems(allComp);
        grid.addColumn(Company::getCompanyName).setCaption("Название \nкомпании");
        grid.addColumn(Company::getAddress).setCaption("Адрес");
        grid.addColumn(Company::getInn).setCaption("ИНН");
        grid.addColumn(Company::getTel).setCaption("Телефон");


        setCompositionRoot(grid);

//        List<Company> allComp = companyDAO.getAllCompany();
//        allComp.forEach(System.out::println);


    }

}
