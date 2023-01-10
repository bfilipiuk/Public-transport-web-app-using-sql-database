package bdbt_project.SpringApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PojazdDAO {
    @Autowired
    private  JdbcTemplate jdbcTemplate;

    public PojazdDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pojazd> list(){
        String sql = "SELECT * FROM POJAZDY";

        List<Pojazd> listPojazd = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pojazd.class));

        return listPojazd;
    }

    public void save(Pojazd pojazd) {

    }

    public Pojazd get(int id) {
        return null;
    }

    public void update(Pojazd pojazd) {

    }

    public void delete(int id) {

    }
}
