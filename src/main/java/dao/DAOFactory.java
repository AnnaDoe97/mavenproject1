package dao;

import utils.Commons;

public class DAOFactory {
    private static DAOFactory ourInstance = new DAOFactory();

    private EmployeeDAO userDAO;
    private CompanyDAO companyDAO;

    public static DAOFactory getInstance() {
        return ourInstance;
    }

    private DAOFactory() {
        userDAO = new EmployeeDAOImplPostgres(Commons.getJDBCTemplate());
        companyDAO = new CompanyDAOImplPostgres(Commons.getJDBCTemplate());

    }

    public EmployeeDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(EmployeeDAO userDAO) {
        this.userDAO = userDAO;
    }

    public CompanyDAO getCompanyDAO() {
        return companyDAO;
    }


}
