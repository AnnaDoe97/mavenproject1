package com.mycompany.mavenproject1;

import com.vaadin.ui.*;
import dao.CompanyDAO;
import dao.DAOFactory;
import object.Company;

public class EditLayout extends FormLayout {
    private TextField cName = new TextField("Название компании");
    private TextField cInn = new TextField("ИНН");
    private TextField cAddr = new TextField("Адрес");
    private TextField cTel = new TextField("Телефон");
    private Button save = new Button("Сохранить");
    private Button delete = new Button("Удалить");
    private MyUI myUI;
    private CompanyDAO companyDAO = DAOFactory.getInstance().getCompanyDAO();
    private Company company;

    public EditLayout(MyUI myUI){
        this.myUI = myUI;

        HorizontalLayout buttons = new HorizontalLayout(save, delete);
        buttons.setSpacing(true);
        addComponents(cName, cInn, cAddr, cTel, buttons);
    }

    public void setCompany(Company company){
        this.company = company;
//        cName.setValue(company.getCompanyName());
//        cAddr.setValue(company.getAddress());
//        cTel.setValue(company.getTel());
        

    }

}
