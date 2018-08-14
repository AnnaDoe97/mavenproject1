package utils;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.io.IOException;
import java.util.Properties;

public class Commons {
    private static NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * Подключает настройки при сборке проекта
     *
     * @param property
     * @return
     */
    public static String getProperties(String property) {
        Properties prop = new Properties();
        try {
            prop.load(Commons.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            return prop.getProperty(property);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static NamedParameterJdbcTemplate getJDBCTemplate() {
        if (jdbcTemplate == null) {
            BasicDataSource ds = new BasicDataSource();
            ds.setDriverClassName("org.postgresql.Driver");
            ds.setUrl(Commons.getProperties("db"));
            ds.setUsername(Commons.getProperties("login"));
            ds.setPassword(Commons.getProperties("pass"));

            jdbcTemplate = new NamedParameterJdbcTemplate(ds);
        }
        return jdbcTemplate;
    }
}
