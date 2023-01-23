package bdbt_project.SpringApplication;

public class Linia {
    private int id_linii;

    private boolean czy_aktywna;

    private char rodzaj_linii;

    private int id_bazy;

    public Linia(boolean czy_aktywna, char rodzaj_linii, int id_bazy, int id_linii) {
        this.id_linii = id_linii;
        this.czy_aktywna = czy_aktywna;
        this.rodzaj_linii = rodzaj_linii;
        this.id_bazy = id_bazy;
    }

    public Linia() {}

    public int getId_linii() {
        return id_linii;
    }

    public void setId_linii(int id_linii) {
        this.id_linii = id_linii;
    }

    public boolean getCzy_aktywna() {
        return czy_aktywna;
    }

    public void setCzy_aktywna(boolean czy_aktywna) {
        this.czy_aktywna = czy_aktywna;
    }

    public char getRodzaj_linii() {
        return rodzaj_linii;
    }

    public void setRodzaj_linii(char rodzaj_linii) {
        this.rodzaj_linii = rodzaj_linii;
    }

    public int getId_bazy() {
        return id_bazy;
    }

    public void setId_bazy(int id_bazy) {
        this.id_bazy = id_bazy;
    }

    @Override
    public String toString() {
        return "Linia{" +
                "idLinii=" + id_linii +
                ", czyAktywna=" + czy_aktywna +
                ", rodzajLinii=" + rodzaj_linii +
                ", idBazy=" + id_bazy +
                '}';
    }
}
