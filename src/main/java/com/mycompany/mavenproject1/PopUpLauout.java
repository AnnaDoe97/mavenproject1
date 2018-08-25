package com.mycompany.mavenproject1;

import com.vaadin.ui.*;
import dao.CompanyDAO;
import dao.DAOFactory;
import object.Company;

public class PopUpLauout extends CustomComponent {
    private CompanyDAO companyDAO;

    public PopUpLauout(){
        companyDAO = DAOFactory.getInstance().getCompanyDAO();

        TextField cName = new TextField("Company name");
        TextField cInn = new TextField("Inn");
        TextField cAddr = new TextField("Address");
        TextField cTel = new TextField("Phone");

        VerticalLayout popContent = new VerticalLayout();
        popContent.addComponent(cName);
        popContent.addComponent(cInn);
        popContent.addComponent(cAddr);
        popContent.addComponent(cTel);
//        popContent.addComponent(new Button("addCompany"));
        Button addCompany = new Button("addCompany");

        addCompany.addClickListener(clickEvent -> {
            System.out.println(addCompany.getCaption());
            System.out.println(cName.getValue());
            Company company = new Company();
            company.setCompanyName(cName.getValue());
            company.setInn(Integer.parseInt(cInn.getValue()));
            company.setAddress(cAddr.getValue());
            company.setTel(cTel.getValue());
            companyDAO.addCompany(company);
        });

        popContent.addComponent(addCompany);
        setCompositionRoot(popContent);


    }
}
