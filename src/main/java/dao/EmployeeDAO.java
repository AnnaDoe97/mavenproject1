package dao;

import object.Employee;

import java.util.List;

public interface EmployeeDAO {
    /**
     * Получает всех пользователей
     *
     * @return
     */
    List<Employee> getAllUser();

    /**
     * Удаляет пользователя
     *
     * @param id
     * @return
     */
    int deleteUserById(long id);

    /**
     * Добавляет пользователя
     *
     * @param user
     * @return
     */
    int addUser(Employee user);

    /**
     * Получает новый id для пользователя
     *
     * @return
     */
    long getSequence();

    /**
     * Возвращает user по id
     *
     * @param id
     * @return
     */
    Employee getUserById(long id);

    int updateById(long id, Employee employee);

    List<Employee> getEmployeeByCompanyId(long id);

}