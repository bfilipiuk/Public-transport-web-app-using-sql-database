package bdbt_project.SpringApplication;

import java.util.Date;

public class Klient {
    private int idKlienta;
    private String imie;
    private String nazwisko;
    private String PESEL;
    private String email;
    private int telefon;
    private int idBazy;

    public Klient(int idKlienta, String imie, String nazwisko, String PESEL, String email, int telefon, int idBazy) {
        this.idKlienta = idKlienta;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.PESEL = PESEL;
        this.email = email;
        this.telefon = telefon;
        this.idBazy = idBazy;
    }

    public Klient() {}

    public int getIdKlienta() {
        return idKlienta;
    }

    public void setIdKlienta(int idKlienta) {
        this.idKlienta = idKlienta;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public int getIdBazy() {
        return idBazy;
    }

    public void setIdBazy(int idBazy) {
        this.idBazy = idBazy;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "idKlienta=" + idKlienta +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", PESEL=" + PESEL +
                ", email='" + email + '\'' +
                ", telefon=" + telefon +
                ", idBazy=" + idBazy +
                '}';
    }
}
