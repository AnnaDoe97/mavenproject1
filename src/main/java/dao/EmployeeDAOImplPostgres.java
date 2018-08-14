package dao;

import dao.mapper.UserMapper;
import object.Employee;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImplPostgres implements EmployeeDAO {
    private NamedParameterJdbcTemplate jdbcTemplate;

    public EmployeeDAOImplPostgres(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String SQL_SELECT_GET_SEQUENCE = "SELECT nextval('user_id')";

    @Override
    public long getSequence() {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        try {
            return jdbcTemplate.queryForLong(SQL_SELECT_GET_SEQUENCE, parameterSource);
        } catch (Exception e) {
            return -1;
        }
    }

    private final String SQL_SELECT_GET_ALL_USER = "SELECT id, user_name, phone, comp_name, birth_date FROM user_data";

    @Override
    public List<Employee> getAllUser() {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        try {
            return jdbcTemplate.query(SQL_SELECT_GET_ALL_USER, parameterSource, new UserMapper());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private final String SQL_SELECT_GET_USER_BY_ID = SQL_SELECT_GET_ALL_USER + " WHERE id = :ID";


    private final String SQL_UPDATE_BY_ID = "UPDATE user_data SET user_name = :USER_NAME, phone = :PHONE,"+
            " comp_name = :USER_COMPANY WHERE id = :ID";


    @Override
    public int updateById(long id, Employee employee) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("ID", id);
        parameterSource.addValue("USER_NAME", employee.getUserName());
        parameterSource.addValue("PHONE", employee.getPhone());
        parameterSource.addValue("USER_COMPANY", employee.getUserComp());


        try {
            return jdbcTemplate.update(SQL_UPDATE_BY_ID, parameterSource);
        } catch (Exception e){
            return -1;
        }

    }


    @Override
    public Employee getUserById(long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("ID", id);

        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_GET_USER_BY_ID, parameterSource, new UserMapper());
        } catch (Exception e) {
            return null;
        }
    }


    private final String SQL_DELETE_USER_BY_ID = "DELETE FROM user_data WHERE id = :ID";

    @Override
    public int deleteUserById(long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("ID", id);

        try {
            return jdbcTemplate.update(SQL_DELETE_USER_BY_ID, parameterSource);
        } catch (Exception e) {
            return -1;
        }
    }

    private final String SQL_INSERT_USER = "INSERT INTO user_data (id, user_name, phone, comp_name) " +
            "VALUES (:ID, :USER_NAME, :PHONE, :USER_COMPANY)";

    @Override
    public int addUser(Employee user) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        long nextUserId = getSequence();

        if (nextUserId == -1) return -1;

        parameterSource.addValue("ID", nextUserId);
        parameterSource.addValue("USER_NAME", user.getUserName());
        parameterSource.addValue("PHONE", user.getPhone());
        parameterSource.addValue("USER_COMPANY", user.getUserComp());
//        parameterSource.addValue("BIRTH_DATE", user.getUserBirth());

        try {
            return jdbcTemplate.update(SQL_INSERT_USER, parameterSource);
        } catch (Exception e) {
            return -1;
        }
    }

    private final String GET_EMPLOYEE_BY_COMPANY_ID = "SELECT e.id, e.user_name, e.phone, e.comp_name "+
            "FROM user_data e "+
            "JOIN (select * from relation where company_id = :COMPANY_ID) r ON e.id = r.employee_id "+
            "JOIN company c ON c.id = r.company_id";

    @Override
    public List<Employee> getEmployeeByCompanyId(long id) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("COMPANY_ID", id);

        try {
            return jdbcTemplate.query(GET_EMPLOYEE_BY_COMPANY_ID, mapSqlParameterSource, new UserMapper());
        } catch (Exception e) {
            return new ArrayList<>();
        }

    }

}
