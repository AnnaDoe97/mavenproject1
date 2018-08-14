package dao.mapper;

import object.Company;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyMapper implements RowMapper<Company> {
    @Override
    public Company mapRow(ResultSet result, int i) throws SQLException{
        Company company = new Company();

        company.setId(result.getLong("id"));
        company.setCompanyName(result.getString("company_name"));
        company.setInn(result.getInt("inn"));
        company.setAddress(result.getString("address"));
        company.setTel(result.getString("company_tel"));

        return company;
    }
}
