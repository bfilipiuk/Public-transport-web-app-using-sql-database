package bdbt_project.SpringApplication;

public class Pracownik {
    private int idPracownika;
    private String imie;
    private String nazwisko;
    private String pesel;
    private int telefon;
    private String email;
    private String numerKontaBankowego;
    private String stanowisko;
    private int idBazy;
    private int idAdresu;

    public Pracownik(int idPracownika, String imie, String nazwisko, String pesel, int telefon, String numerKontaBankowego, String stanowisko, int idBazy, int idAdresu, String email) {
        this.idPracownika = idPracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.telefon = telefon;
        this.numerKontaBankowego = numerKontaBankowego;
        this.stanowisko = stanowisko;
        this.idBazy = idBazy;
        this.idAdresu = idAdresu;
        this.email = email;
    }

    public Pracownik(){
    }

    public int getIdPracownika() {
        return idPracownika;
    }

    public void setIdPracownika(int idPracownika) {
        this.idPracownika = idPracownika;
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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public String getNumerKontaBankowego() {
        return numerKontaBankowego;
    }

    public void setNumerKontaBankowego(String numerKontaBankowego) {
        this.numerKontaBankowego = numerKontaBankowego;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public int getIdBazy() {
        return idBazy;
    }

    public void setIdBazy(int idBazy) {
        this.idBazy = idBazy;
    }

    public int getIdAdresu() {
        return idAdresu;
    }

    public void setIdAdresu(int idAdresu) {
        this.idAdresu = idAdresu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "idPracownika=" + idPracownika +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel=" + pesel +
                ", nrTel=" + telefon +
                ", nrKonta=" + numerKontaBankowego +
                ", stanowisko='" + stanowisko + '\'' +
                ", idBazy=" + idBazy +
                ", idAdresu=" + idAdresu +
                '}';
    }
}
