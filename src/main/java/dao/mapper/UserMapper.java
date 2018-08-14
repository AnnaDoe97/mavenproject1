package dao.mapper;

import object.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<Employee> {
    /**
     *
     * @param resultSet - строка результата
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee user = new Employee();

        user.setId(resultSet.getLong("id"));
        user.setUserName(resultSet.getString("user_name"));
        user.setPhone(resultSet.getString("phone"));
        user.setUserComp(resultSet.getString("comp_name"));
        user.setUserBirth(resultSet.getDate("birth_date"));

        return user;
    }
}
