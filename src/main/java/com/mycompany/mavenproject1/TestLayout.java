package com.mycompany.mavenproject1;

import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;
import dao.DAOFactory;
import dao.EmployeeDAO;
import object.Employee;

import java.util.List;

public class TestLayout extends VerticalLayout {
    private TextField textField;


    private EmployeeDAO userDAO;

    public TestLayout() {
        userDAO = DAOFactory.getInstance().getUserDAO();
        Design.read("/html/test.html", this);

        textField.addValueChangeListener(valueChangeEvent -> {
            System.out.println(textField.getValue());
//            List<Employee> allUser = userDAO.getAllUser();
//
//            allUser.forEach(System.out::println);
        });
    }
}
