package dao;
import dao.DAOFactory;
import object.Employee;

import org.junit.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class EmployeeDAOImplTest {
    @org.junit.Test
    public void testEmployee(){
        EmployeeDAO employeeDAO = DAOFactory.getInstance().getUserDAO();
        Employee employee = new Employee();
        employee.setUserName("Fnna");
        employee.setPhone("1488");
        employee.setUserComp("TBWC");

        employeeDAO.updateById(10, employee);


        /**
         * вывод всех сотрудников
         */
        List<Employee> allUser = employeeDAO.getAllUser();
        allUser.forEach(System.out::println);


    }

    @org.junit.Test
    public void byUserID(){
        EmployeeDAO employeeDAO = DAOFactory.getInstance().getUserDAO();

        /**
         * вывод по id компании
         */
        List<Employee> byId = employeeDAO.getEmployeeByCompanyId(2);
        byId.forEach(System.out::println);

    }

    @org.junit.Test
    public void addWithDate() throws ParseException {
        EmployeeDAO employeeDAO = DAOFactory.getInstance().getUserDAO();
        Employee employee = new Employee();

        String s="2013-07-05";
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd");

        employee.setUserName("Rick");
        employee.setPhone("84685");
        employee.setUserComp("DOCTOR");
        employee.setUserBirth(format.parse(s));
        employeeDAO.addUser(employee);

        List<Employee> allUser = employeeDAO.getAllUser();
        allUser.forEach(System.out::println);
    }

}
