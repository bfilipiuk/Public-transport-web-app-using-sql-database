package bdbt_project.SpringApplication;

public class Pojazd {
    private int idPojazdu;
    private String marka;
    private String model;
    private int rokProdukcji;
    private int idBazy;

    public Pojazd(int idPojazdu, String marka, String model, int rokProdukcji, int idBazy) {
        this.idPojazdu = idPojazdu;
        this.marka = marka;
        this.model = model;
        this.rokProdukcji = rokProdukcji;
        this.idBazy = idBazy;
    }

    public Pojazd() {
    }

    public int getIdPojazdu() {
        return idPojazdu;
    }

    public void setIdPojazdu(int idPojazdu) {
        this.idPojazdu = idPojazdu;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRokProdukcji() {
        return rokProdukcji;
    }

    public void setRokProdukcji(int rokProdukcji) {
        this.rokProdukcji = rokProdukcji;
    }

    public int getIdBazy() {
        return idBazy;
    }

    public void setIdBazy(int idBazy) {
        this.idBazy = idBazy;
    }

    @Override
    public String toString() {
        return "Pojazd{" +
                "id_pojazdu=" + idPojazdu +
                ", marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", rok_produkcji=" + rokProdukcji +
                ", id_bazy=" + idBazy +
                '}';
    }
}
