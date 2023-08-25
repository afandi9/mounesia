package com.raion.putrautama.mounesiaprototype.Model;

import java.io.Serializable;

public class GunungMenengah implements Serializable{
    String NamaGunungMenengah;
    String LokasiGunungMenengah;
    String SuhuGunungMenengah;
    String DeskripsiGunungMenengah;
    String BarangGunungMenengah;
    String KetinggianGunungMenengah;
    String RuteGunungMenengah;
    String PaketGunungMenengah;
    int HargaGunungMenengah;
    String FotoGunungMenengah;

    public GunungMenengah(String namaGunungMenengah, String lokasiGunungMenengah, String suhuGunungMenengah,
                          String deskripsiGunungMenengah, String barangGunungMenengah, String ketinggianGunungMenengah,
                          String ruteGunungMenengah, String paketGunungMenengah,int hargaGunungMenengah, String fotoGunungMenengah) {
        NamaGunungMenengah = namaGunungMenengah;
        LokasiGunungMenengah = lokasiGunungMenengah;
        SuhuGunungMenengah = suhuGunungMenengah;
        DeskripsiGunungMenengah = deskripsiGunungMenengah;
        BarangGunungMenengah = barangGunungMenengah;
        KetinggianGunungMenengah = ketinggianGunungMenengah;
        RuteGunungMenengah = ruteGunungMenengah;
        PaketGunungMenengah = paketGunungMenengah;
        HargaGunungMenengah = hargaGunungMenengah;
        FotoGunungMenengah = fotoGunungMenengah;
    }

    public GunungMenengah(String namaGunungMenengah, String lokasiGunungMenengah,
                          String ketinggianGunungMenengah, String suhuGunungMenengah,
                           String fotoGunungMenengah) {
        NamaGunungMenengah = namaGunungMenengah;
        LokasiGunungMenengah = lokasiGunungMenengah;
        SuhuGunungMenengah = suhuGunungMenengah;
        KetinggianGunungMenengah = ketinggianGunungMenengah;
        FotoGunungMenengah = fotoGunungMenengah;
    }

    public int getHargaGunungMenengah() {
        return HargaGunungMenengah;
    }

    public void setHargaGunungMenengah(int hargaGunungMenengah) {
        HargaGunungMenengah = hargaGunungMenengah;
    }

    public String getNamaGunungMenengah() {
        return NamaGunungMenengah;
    }

    public void setNamaGunungMenengah(String namaGunungMenengah) {
        NamaGunungMenengah = namaGunungMenengah;
    }

    public String getLokasiGunungMenengah() {
        return LokasiGunungMenengah;
    }

    public void setLokasiGunungMenengah(String lokasiGunungMenengah) {
        LokasiGunungMenengah = lokasiGunungMenengah;
    }

    public String getSuhuGunungMenengah() {
        return SuhuGunungMenengah;
    }

    public void setSuhuGunungMenengah(String suhuGunungMenengah) {
        SuhuGunungMenengah = suhuGunungMenengah;
    }

    public String getDeskripsiGunungMenengah() {
        return DeskripsiGunungMenengah;
    }

    public void setDeskripsiGunungMenengah(String deskripsiGunungMenengah) {
        DeskripsiGunungMenengah = deskripsiGunungMenengah;
    }

    public String getBarangGunungMenengah() {
        return BarangGunungMenengah;
    }

    public void setBarangGunungMenengah(String barangGunungMenengah) {
        BarangGunungMenengah = barangGunungMenengah;
    }

    public String getKetinggianGunungMenengah() {
        return KetinggianGunungMenengah;
    }

    public void setKetinggianGunungMenengah(String ketinggianGunungMenengah) {
        KetinggianGunungMenengah = ketinggianGunungMenengah;
    }

    public String getRuteGunungMenengah() {
        return RuteGunungMenengah;
    }

    public void setRuteGunungMenengah(String ruteGunungMenengah) {
        RuteGunungMenengah = ruteGunungMenengah;
    }

    public String getPaketGunungMenengah() {
        return PaketGunungMenengah;
    }

    public void setPaketGunungMenengah(String paketGunungMenengah) {
        PaketGunungMenengah = paketGunungMenengah;
    }

    public String getFotoGunungMenengah() {
        return FotoGunungMenengah;
    }

    public void setFotoGunungMenengah(String fotoGunungMenengah) {
        FotoGunungMenengah = fotoGunungMenengah;
    }
}
