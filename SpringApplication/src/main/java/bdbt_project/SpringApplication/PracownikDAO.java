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
public class PracownikDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PracownikDAO(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    public List<Pracownik> list(){
        String sql = "SELECT * FROM PRACOWNICY";
        List<Pracownik> listPracownik = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownik.class));

        return listPracownik;
    }

    public void save(Pracownik pracownik) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("pracownicy").usingColumns("imie", "nazwisko", "pesel", "telefon",
                "email", "numer_Konta_Bankowego", "stanowisko", "id_Bazy", "id_Adresu");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
        insertActor.execute(param);
    }

    public Pracownik get(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM PRACOWNICY WHERE ID_PRACOWNIKA = " + args[0];
        Pracownik pracownik = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Pracownik.class));

        return pracownik;
    }

    public void update(Pracownik pracownik) {
        String sql = "UPDATE PRACOWNICY SET IMIE=:imie, NAZWISKO=:nazwisko, PESEL=:pesel, TELEFON=:telefon, EMAIL=:email," +
                " NUMER_KONTA_BANKOWEGO=:numerKontaBankowego, STANOWISKO=:stanowisko, ID_BAZY=:idBazy," +
                " ID_ADRESU=:idAdresu WHERE ID_PRACOWNIKA=:idPracownika";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM PRACOWNICY WHERE ID_PRACOWNIKA = ?";
        jdbcTemplate.update(sql, id);

    }
}
