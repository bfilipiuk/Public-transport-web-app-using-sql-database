package bdbt_project.SpringApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class PrzystanekDAO {
    @Autowired
    public JdbcTemplate jdbcTemplate;

    public PrzystanekDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Przystanek> list() {
        String sql = "SELECT * FROM PRZYSTANKI";
        List<Przystanek> listPrzystanek = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Przystanek.class));

        return listPrzystanek;
    }

    public List<Przystanek> listType(char type) {

        String typeSql = "'" + type + "'";

        String sql ="SELECT * FROM przystanki WHERE rodzaj_przystanku = " + typeSql ;
        List<Przystanek> listTypePrzystanek = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Przystanek.class));

        return listTypePrzystanek;
    }
    public void savePrzystanek(Przystanek przystanek) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("przystanki").usingColumns("nazwa", "lokalizacja_x", "lokalizacja_y", "rodzaj_przystanku", "id_bazy");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(przystanek);
        insertActor.execute(param);
    }

    public Przystanek get(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM PRZYSTANKI WHERE ID_PRZYSTANKU =" + args[0];
        Przystanek przystanek = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Przystanek.class));

        return przystanek;
    }

    public void update(Przystanek przystanek) {
        String sql = "UPDATE PRZYSTANKI SET NAZWA=:nazwa, LOKALIZACJA_X=:lokalizacjaX, LOKALIZACJA_Y=:lokalizacjaY," +
                " RODZAJ_PRZYSTANKU=:rodzajPrzystanku, ID_BAZY=:idBazy WHERE ID_PRZYSTANKU=:idPrzystanku";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(przystanek);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void deleteStop(int id) {
        String sql = "DELETE FROM PRZYSTANKI WHERE ID_PRZYSTANKU = ?";
        jdbcTemplate.update(sql, id);
    }
}
