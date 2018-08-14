package dao;
import dao.DAOFactory;
import object.Employee;

import org.junit.Assert;

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
//        List<Employee> allUser = employeeDAO.getAllUser();
//        allUser.forEach(System.out::println);

        /**
         * изменение по id компании
         */
         List<Employee> byId = employeeDAO.getEmployeeByCompanyId(2);
         byId.forEach(System.out::println);
//        System.out.println(employeeDAO.getEmployeeByCompanyId(3));

    }

}
