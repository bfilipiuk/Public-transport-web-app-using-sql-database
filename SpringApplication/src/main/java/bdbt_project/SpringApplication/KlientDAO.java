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
public class KlientDAO {
    @Autowired JdbcTemplate jdbcTemplate;

    public KlientDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Klient> list() {
        String sql = "SELECT * FROM KLIENCI";
        List<Klient> listKlient = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klient.class));

        return listKlient;
    }

    public Klient get(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM klienci WHERE id_klienta =" + args[0];
        Klient klient = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Klient.class));

        return klient;
    }

//    public void update(Przystanek przystanek) {
//        String sql = "UPDATE PRZYSTANKI SET NAZWA=:nazwa, LOKALIZACJA_X=:lokalizacjaX, LOKALIZACJA_Y=:lokalizacjaY," +
//                " RODZAJ_PRZYSTANKU=:rodzajPrzystanku, ID_BAZY=:idBazy WHERE ID_PRZYSTANKU=:idPrzystanku";
//        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(przystanek);
//        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
//
//        template.update(sql, param);
//    }

    public void update(Klient klient) {
        String sql = "UPDATE klienci SET imie=:imie, nazwisko=:nazwisko, pesel=:PESEL, email=:email, telefon=:telefon WHERE id_klienta=:idKlienta";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klient);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }
}
