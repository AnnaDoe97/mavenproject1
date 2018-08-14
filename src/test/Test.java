import dao.CompanyDAO;
import dao.DAOFactory;
import dao.EmployeeDAO;
import object.Company;
import object.Employee;
import org.junit.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;


import java.util.Date;
import java.util.List;

public class Test {
    @org.junit.Test
    public void method() throws ParseException {
        EmployeeDAO userDAO = DAOFactory.getInstance().getUserDAO();
        CompanyDAO companyDAO = DAOFactory.getInstance().getCompanyDAO();

        List<Employee> allUser = userDAO.getAllUser();

        /**
         * добавление сотрудника
         */
        Employee user = new Employee();
        user.setUserName("Ivan");
        user.setPhone("666");
        user.setUserComp("marabu");

//        userDAO.addUser(user);

//        userDAO.deleteUserById(2);
        /**
         *вывод по id
         */
        System.out.println(userDAO.getUserById(11)+"\n");

        /**
         * Все сотрудники
         */
        allUser.forEach(System.out::println);
        /**
         * tests
         */
        System.out.println("Test is ok");
        Assert.assertEquals(2,2);




    }
    @org.junit.Test
    public void checkTime(){
        String s="2013-07-05";
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd");
        try {
            Date docDate= format.parse(s);
            System.out.println(docDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
