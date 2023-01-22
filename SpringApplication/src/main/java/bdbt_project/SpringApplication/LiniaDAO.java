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
public class LiniaDAO {
    @Autowired JdbcTemplate jdbcTemplate;

    public LiniaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Linia> list(){
        String sql = "SELECT * FROM LINIE";
        List<Linia> listLinia = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Linia.class));

        return listLinia;
    }

    public List<Linia> listType(char type) {
        String typeSql = "'" + type + "'";

        String sql = "SELECT * FROM linie WHERE rodzaj_linii = " + typeSql + " AND czy_aktywna = 1";
        List<Linia> listLiniaType = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Linia.class));

        return listLiniaType;
    }

    public void saveLinia(Linia linia) {


        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("linie").usingColumns("czy_aktywna, rodzaj_linii, id_bazy");

        System.out.println(linia.toString());

        linia.setRodzajLinii('0');

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(linia);

        System.out.println(param.getParameterNames()[0]);
        System.out.println(param.getParameterNames()[1]);
        System.out.println(param.getParameterNames()[2]);

        System.out.println(param.getValue("czyAktywna"));

        insertActor.execute(param);
    }

    public Linia get(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM LINIE WHERE ID_LINII =" + args[0];
        Linia linia = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Linia.class));

        return linia;
    }

    public void update(Linia linia) {
        String sql = "UPDATE LINIE SET CZY_AKTYWNA=:czyAktywna, RODZAJ_LINII=:rodzajLinii, ID_BAZY=:idBazy" +
                " WHERE ID_LINII=:idLinii";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(linia);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM LINIE WHERE ID_LINII = ?";
        jdbcTemplate.update(sql, id);
    }
}
