package com.mycompany.mavenproject1;

import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import dao.CompanyDAO;
import dao.DAOFactory;
import object.Company;

public class UpdDelLayout extends CustomComponent {
    private CompanyDAO companyDAO;

    public UpdDelLayout(){
        companyDAO = DAOFactory.getInstance().getCompanyDAO();

        TextField cName = new TextField("Название компании");
        System.out.println();
        cName.setValue("AAAAA");
        TextField cInn = new TextField("ИНН");
        TextField cAddr = new TextField("Адрес");
        TextField cTel = new TextField("Телефон");

        VerticalLayout updContent = new VerticalLayout();
        updContent.addComponent(cName);
        updContent.addComponent(cInn);
        updContent.addComponent(cAddr);
        updContent.addComponent(cTel);
//        updContent.addComponent(new Button("addCompany"));
        Button updCompany = new Button("Изменить");




        updCompany.addClickListener(clickEvent -> {
            System.out.println(updCompany.getCaption());
            System.out.println(cName.getValue());
            Company company = new Company();
            company.setCompanyName(cName.getValue());
            company.setInn(Integer.parseInt(cInn.getValue()));
            company.setAddress(cAddr.getValue());
            company.setTel(cTel.getValue());
            companyDAO.addCompany(company);
            Page.getCurrent().reload();
        });

        updContent.addComponent(updCompany);
        setCompositionRoot(updContent);


    }
}
