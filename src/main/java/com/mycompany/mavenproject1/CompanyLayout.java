package com.mycompany.mavenproject1;

import com.google.common.collect.Table;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import dao.CompanyDAO;
import dao.DAOFactory;
import object.Company;
import object.Person;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class CompanyLayout extends VerticalLayout {
    CompanyDAO companyDAO = DAOFactory.getInstance().getCompanyDAO();

    Collection<Company> companies = companyDAO.getAllCompany();

    // Have a container of some type to contain the data
//    Table table = new Table("The Brightest Stars");
//
//// Define two columns for the built-in container
//    table.addContainerProperty("Name", String.class, null);
//    table.addContainerProperty("Mag",  Float.class, null);

    List<Company> people = Arrays.asList(
//            new Person("Nicolaus Copernicus", "1543"),
//            new Person("Galileo Galilei", 1564),
//            new Person("Johannes Kepler", 1571)
            companyDAO.getCompanyById(2),
            companyDAO.getCompanyById(3)
    );

    Grid<Company> grid = new Grid<>();

//    grid.setItems(people);
//    grid.addColumn(Person.).setCaption("Name");
//    grid.addColumn(Person::getDateBirth).setCaption("Year of birth");
}
