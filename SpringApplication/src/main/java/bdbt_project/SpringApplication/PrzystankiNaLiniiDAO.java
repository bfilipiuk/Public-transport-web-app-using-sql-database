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
public class PrzystankiNaLiniiDAO {
    @Autowired JdbcTemplate jdbcTemplate;

    public PrzystankiNaLiniiDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PrzystankiNaLinii> list(int id) {
        String idString = Integer.toString(id);
        String sql = "SELECT * FROM przystanki_na_linii INNER JOIN przystanki USING(id_przystanku) WHERE id_linii = " + idString;
        List<PrzystankiNaLinii> listPrzystankiNaLinii = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(PrzystankiNaLinii.class));

        return listPrzystankiNaLinii;
    }

    public void savePrzystankiNaLinii(PrzystankiNaLinii przystankiNaLinii) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("przystanki_na_linii").usingColumns("id_przystanku", "id_linii");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(przystankiNaLinii);
        insertActor.execute(param);
    }

    public void deletePrzystanekNaLinii(int id) {
        String sql = "DELETE FROM przystanki_na_linii WHERE id_przystanku = ?";
        jdbcTemplate.update(sql, id);
    }
}
