package dao;


import dao.CompanyDAO;
import dao.DAOFactory;
import object.Company;

import object.Employee;
import org.junit.Assert;

import java.util.List;

public class CompanyDAOImplTest {
    @org.junit.Test
    public void testMethod(){
        CompanyDAO companyDAO = DAOFactory.getInstance().getCompanyDAO();
//        Company company = new Company();
//        company.setCompanyName("unicorn");
//        company.setInn(1235467585);
//        company.setAddress("Lenina, 15");
//        company.setTel("48888");

        /**
         * добавление новой компании
         */
//        companyDAO.addCompany(company);

        /**
         * удаление
         */
//        companyDAO.deleteCompanyById(1);


        /**
         * изменение  компании
         */
        Company company = new Company();
        company.setCompanyName("sumsung");
        company.setInn(457345899);
        company.setAddress("Kalinina, 5");
        company.setTel("822999");

//        companyDAO.updateCompany(4,company);

        List<Company> allCompanies = companyDAO.getAllCompany();
//        allCompanies.forEach(System.out::println);


    }
}
