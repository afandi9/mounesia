package com.raion.putrautama.mounesiaprototype.Model;

public class HistoryGunung {
    String NamaGunung;
    String LokasiGunung;
    String SuhuGunung;
    String KetinggianGunung;
    int FotoGunung;

    public HistoryGunung(String namaGunung, String lokasiGunung, String suhuGunung, String ketinggianGunung, int fotoGunung) {
        NamaGunung = namaGunung;
        LokasiGunung = lokasiGunung;
        SuhuGunung = suhuGunung;
        KetinggianGunung = ketinggianGunung;
        FotoGunung = fotoGunung;
    }

    public String getNamaGunung() {
        return NamaGunung;
    }

    public void setNamaGunung(String namaGunung) {
        NamaGunung = namaGunung;
    }

    public String getLokasiGunung() {
        return LokasiGunung;
    }

    public void setLokasiGunung(String lokasiGunung) {
        LokasiGunung = lokasiGunung;
    }

    public String getSuhuGunung() {
        return SuhuGunung;
    }

    public void setSuhuGunung(String suhuGunung) {
        SuhuGunung = suhuGunung;
    }

    public String getKetinggianGunung() {
        return KetinggianGunung;
    }

    public void setKetinggianGunung(String ketinggianGunung) {
        KetinggianGunung = ketinggianGunung;
    }

    public int getFotoGunungProfesional() {
        return FotoGunung;
    }

    public void setFotoGunungProfesional(int fotoGunungProfesional) {
        FotoGunung = fotoGunungProfesional;
    }
}
