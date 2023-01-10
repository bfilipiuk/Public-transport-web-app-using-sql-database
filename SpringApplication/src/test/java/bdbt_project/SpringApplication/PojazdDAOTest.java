package bdbt_project.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PojazdDAOTest extends Object {

    private PojazdDAO dao;

    @BeforeEach
    void setUp() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        dataSource.setUsername("BDBTGRC13");
        dataSource.setPassword("BDBTGRC13");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new PojazdDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void list() {
        List<Pojazd> listLanguages = dao.list();
        System.out.println(Arrays.toString(listLanguages.toArray()));

        assertFalse(listLanguages.isEmpty());
    }

    @Test
    void save() {
        fail("Not yet implemented");
    }

    @Test
    void get() {
        fail("Not yet implemented");
    }

    @Test
    void update() {
        fail("Not yet implemented");
    }

    @Test
    void delete() {
    }
}