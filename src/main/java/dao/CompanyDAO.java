package dao;

import object.Company;
import object.Employee;

import java.util.List;

public interface CompanyDAO {

    /**
     * Получает список компаний
     * @return
     */

    List<Company>getAllCompany();

    /**
     *Удаление
     * @param id
     * @return
     */

    int deleteCompanyById(long id);

    /**
     * Добавление
     * @param company
     * @return
     */
    int addCompany(Company company);

    /**
     * Генерация id
     * @return
     */
    long getSequence();

    /**
     * А нужен ли он нам
     * @param id
     * @return
     */
    Company getCompanyById(long id);

    /**
     * Обновление
     */
    int updateCompany(long id, Company company);


}
