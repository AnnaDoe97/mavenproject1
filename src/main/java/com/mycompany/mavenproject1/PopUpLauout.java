package com.mycompany.mavenproject1;

import com.vaadin.server.Page;
import com.vaadin.ui.*;
import dao.CompanyDAO;
import dao.DAOFactory;
import object.Company;

public class PopUpLauout extends CustomComponent {
    private CompanyDAO companyDAO;

    public PopUpLauout(){
        companyDAO = DAOFactory.getInstance().getCompanyDAO();

        TextField cName = new TextField("Название компании");
        TextField cInn = new TextField("ИНН");
        TextField cAddr = new TextField("Адрес");
        TextField cTel = new TextField("Телефон");

        VerticalLayout popContent = new VerticalLayout();
        popContent.addComponent(cName);
        popContent.addComponent(cInn);
        popContent.addComponent(cAddr);
        popContent.addComponent(cTel);
//        popContent.addComponent(new Button("addCompany"));
        Button addCompany = new Button("Добавить");

        addCompany.addClickListener(clickEvent -> {
            System.out.println(addCompany.getCaption());
            System.out.println(cName.getValue());
            Company company = new Company();
            company.setCompanyName(cName.getValue());
            company.setInn(Integer.parseInt(cInn.getValue()));
            company.setAddress(cAddr.getValue());
            company.setTel(cTel.getValue());
            companyDAO.addCompany(company);
//            Page.getCurrent().reload();

        });

        popContent.addComponent(addCompany);
        setCompositionRoot(popContent);


    }
}
