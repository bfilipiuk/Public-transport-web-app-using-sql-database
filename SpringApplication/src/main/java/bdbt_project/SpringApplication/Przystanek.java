package bdbt_project.SpringApplication;

public class Przystanek {
    private int idPrzystanku;
    private String nazwa;
    private int lokalizacjaX;
    private int lokalizacjaY;
    private char rodzajPrzystanku;
    private int idBazy;

    public Przystanek(int idPrzystanku, String nazwa, int lokalizacjaX, int lokalizacjaY, char rodzajPrzystanku, int idBazy) {
        this.idPrzystanku = idPrzystanku;
        this.nazwa = nazwa;
        this.lokalizacjaX = lokalizacjaX;
        this.lokalizacjaY = lokalizacjaY;
        this.rodzajPrzystanku = rodzajPrzystanku;
        this.idBazy = idBazy;
    }

    public Przystanek(){}

    public int getIdPrzystanku() {
        return idPrzystanku;
    }

    public void setIdPrzystanku(int idPrzystanku) {
        this.idPrzystanku = idPrzystanku;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getLokalizacjaX() {
        return lokalizacjaX;
    }

    public void setLokalizacjaX(int lokalizacjaX) {
        this.lokalizacjaX = lokalizacjaX;
    }

    public int getLokalizacjaY() {
        return lokalizacjaY;
    }

    public void setLokalizacjaY(int lokalizacjaY) {
        this.lokalizacjaY = lokalizacjaY;
    }

    public char getRodzajPrzystanku() {
        return rodzajPrzystanku;
    }

    public void setRodzajPrzystanku(char rodzajPrzystanku) {
        this.rodzajPrzystanku = rodzajPrzystanku;
    }

    public int getIdBazy() {
        return idBazy;
    }

    public void setIdBazy(int idBazy) {
        this.idBazy = idBazy;
    }

    @Override
    public String toString() {
        return "Przystanek{" +
                "idPrzystanku=" + idPrzystanku +
                ", nazwa='" + nazwa + '\'' +
                ", lokalizacjaX=" + lokalizacjaX +
                ", lokalizacjaY=" + lokalizacjaY +
                ", rodzajPrzystanku=" + rodzajPrzystanku +
                ", idBazy=" + idBazy +
                '}';
    }
}
