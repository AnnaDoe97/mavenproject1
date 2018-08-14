package dao;

import dao.mapper.CompanyMapper;
import dao.mapper.UserMapper;
import object.Company;
import object.Employee;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class CompanyDAOImplPostgres implements CompanyDAO {
    private NamedParameterJdbcTemplate jdbcCompanyTemplate;
    public CompanyDAOImplPostgres(NamedParameterJdbcTemplate jdbcCompanyTemplate) {
        this.jdbcCompanyTemplate = jdbcCompanyTemplate;
    }

    private final String SQL_GET_COMPANY_SEQUENCE = "SELECT nextval('company_id')";

    @Override
    public long getSequence() {
        MapSqlParameterSource mapSource = new MapSqlParameterSource();
        try {
            return jdbcCompanyTemplate.queryForLong(SQL_GET_COMPANY_SEQUENCE, mapSource);
        } catch (Exception e) {
            return -1;
        }
    }

    private final String SQL_COMPANY_LIST = "SELECT id, company_name, inn, address, company_tel FROM company";

    @Override
    public List<Company> getAllCompany() {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        try {
            return jdbcCompanyTemplate.query(SQL_COMPANY_LIST, mapSqlParameterSource, new CompanyMapper());
        } catch (Exception e){
            return new ArrayList<>();
        }
    }

    public final String DELETE_COMPANY = "DELETE FROM company WHERE id = :COMPANY_ID";

    @Override
    public int deleteCompanyById(long id) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();

        mapSqlParameterSource.addValue("COMPANY_ID", id);

        try {
            return jdbcCompanyTemplate.update(DELETE_COMPANY,mapSqlParameterSource);
        } catch (Exception e) {
            return -1;
        }
    }

    public final String INSERT_INTO_COMPANY = "INSERT INTO company (id, company_name, inn, address, company_tel)"+
            "VALUES (:COMPANY_ID, :COMPANY_NAME, :INN, :ADDRESS, :COMPANY_TEL)";
    @Override
    public int addCompany(Company company) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        long nextCompanyId = getSequence();

        if (nextCompanyId == -1) return -1;

        mapSqlParameterSource.addValue("COMPANY_ID", nextCompanyId);
        mapSqlParameterSource.addValue("COMPANY_NAME", company.getCompanyName());
        mapSqlParameterSource.addValue("INN", company.getInn());
        mapSqlParameterSource.addValue("ADDRESS", company.getAddress());
        mapSqlParameterSource.addValue("COMPANY_TEL", company.getTel());

        try {
            return jdbcCompanyTemplate.update(INSERT_INTO_COMPANY, mapSqlParameterSource);
        } catch (Exception e){
            return -1;
        }
    }



    @Override
    public Company getCompanyById(long id) {
        return null;
    }

    public final String UPDATE_COMPANY_INF = "UPDATE company SET company_name = :COMPANY_NAME, inn = :INN," +
            " address = :ADDRESS, company_tel = :COMPANY_TEL WHERE id = :COMPANY_ID";
    @Override
    public int updateCompany(long id, Company company) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();

        mapSqlParameterSource.addValue("COMPANY_ID", id);
        mapSqlParameterSource.addValue("COMPANY_NAME", company.getCompanyName());
        mapSqlParameterSource.addValue("INN", company.getInn());
        mapSqlParameterSource.addValue("ADDRESS", company.getAddress());
        mapSqlParameterSource.addValue("COMPANY_TEL", company.getTel());

        try {
            return jdbcCompanyTemplate.update(UPDATE_COMPANY_INF, mapSqlParameterSource);
        } catch (Exception e){
            return -1;
        }
    }


}
//INSERT INTO `company` (`company_name`, `inn`, `address`, `address`) VALUES


