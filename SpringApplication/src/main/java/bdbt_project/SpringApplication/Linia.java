package bdbt_project.SpringApplication;

public class Linia {
    private int idLinii;

    private boolean czyAktywna;

    private char rodzajLinii;

    private int idBazy;

    public Linia(boolean czyAktywna, char rodzajLinii, int idBazy) {
//        this.idLinii = idLinii;
        this.czyAktywna = czyAktywna;
        this.rodzajLinii = rodzajLinii;
        this.idBazy = idBazy;
    }

    public Linia() {}

    public int getIdLinii() {
        return idLinii;
    }

    public void setIdLinii(int idLinii) {
        this.idLinii = idLinii;
    }

    public boolean isCzyAktywna() {
        return czyAktywna;
    }

    public void setCzyAktywna(boolean czyAktywna) {
        this.czyAktywna = czyAktywna;
    }

    public char getRodzajLinii() {
        return rodzajLinii;
    }

    public void setRodzajLinii(char rodzajLinii) {
        this.rodzajLinii = rodzajLinii;
    }

    public int getIdBazy() {
        return idBazy;
    }

    public void setIdBazy(int idBazy) {
        this.idBazy = idBazy;
    }

    @Override
    public String toString() {
        return "Linia{" +
                "idLinii=" + idLinii +
                ", czyAktywna=" + czyAktywna +
                ", rodzajLinii=" + rodzajLinii +
                ", idBazy=" + idBazy +
                '}';
    }
}
