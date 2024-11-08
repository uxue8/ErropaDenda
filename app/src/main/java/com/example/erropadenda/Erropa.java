package com.example.erropadenda;

public class Erropa {
    private int kodea;
    private String izena;
    private String mota;
    private String talla;
    private String kolorea;
    private String prezioa;
    private String eskuragarritasuna;


    public int getKodea() {
        return kodea;
    }

    public void setKodea(int kodea) {
        this.kodea = kodea;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getKolorea() {
        return kolorea;
    }

    public void setKolorea(String kolorea) {
        this.kolorea = kolorea;
    }

    public String getPrezioa() {
        return prezioa;
    }

    public void setPrezioa(String prezioa) {
        this.prezioa = prezioa;
    }

    public String getEskuragarritasuna() {
        return eskuragarritasuna;
    }

    public void setEskuragarritasuna(String eskuragarritasuna) {
        this.eskuragarritasuna = eskuragarritasuna;
    }

    @Override
    public String toString() {
        return "Erropa{" +
                "izena='" + izena + '\'' +
                ", mota='" + mota + '\'' +
                ", talla='" + talla + '\'' +
                ", kolorea='" + kolorea + '\'' +
                ", prezioa='" + prezioa + '\'' +
                ", eskuragarritasuna='" + eskuragarritasuna + '\'' +
                '}';
    }

    public Erropa(int kodea,String izena,String mota, String talla, String kolorea,String prezioa,String eskuragarritasuna) {
        this.kodea=kodea;
        this.izena = izena;
        this.mota=mota;
        this.kolorea=kolorea;
        this.prezioa=prezioa;
        this.eskuragarritasuna=eskuragarritasuna;
    }
}
