package com.raion.putrautama.mounesiaprototype.Model;

import java.io.Serializable;

public class GunungProfesional implements Serializable{
    String NamaGunungProfesional;
    String LokasiGunungProfesional;
    String SuhuGunungProfesional;
    String DeskripsiGunungProfesional;
    String BarangGunungProfesional;
    String KetinggianGunungProfesional;
    String RuteGunungProfesional;
    String PaketGunungProfesional;
    int HargaGunungProfesional;
    String FotoGunungProfesional;

    public GunungProfesional(String namaGunungProfesional, String lokasiGunungProfesional, String suhuGunungProfesional,
                             String deskripsiGunungProfesional, String barangGunungProfesional,
                             String ketinggianGunungProfesional, String ruteGunungProfesional,
                             String paketGunungProfesional,int hargaGunungProfesional, String fotoGunungProfesional) {
        NamaGunungProfesional = namaGunungProfesional;
        LokasiGunungProfesional = lokasiGunungProfesional;
        SuhuGunungProfesional = suhuGunungProfesional;
        DeskripsiGunungProfesional = deskripsiGunungProfesional;
        BarangGunungProfesional = barangGunungProfesional;
        KetinggianGunungProfesional = ketinggianGunungProfesional;
        RuteGunungProfesional = ruteGunungProfesional;
        PaketGunungProfesional = paketGunungProfesional;
        HargaGunungProfesional = hargaGunungProfesional;
        FotoGunungProfesional = fotoGunungProfesional;
    }
    public GunungProfesional(String namaGunungProfesional, String lokasiGunungProfesional,
                             String ketinggianGunungProfesional, String suhuGunungProfesional,
                             String fotoGunungProfesional) {
        NamaGunungProfesional = namaGunungProfesional;
        LokasiGunungProfesional = lokasiGunungProfesional;
        SuhuGunungProfesional = suhuGunungProfesional;
        KetinggianGunungProfesional = ketinggianGunungProfesional;
        FotoGunungProfesional = fotoGunungProfesional;
    }


    public String getNamaGunungProfesional() {
        return NamaGunungProfesional;
    }

    public int getHargaGunungProfesional() {
        return HargaGunungProfesional;
    }

    public void setHargaGunungProfesional(int hargaGunungProfesional) {
        HargaGunungProfesional = hargaGunungProfesional;
    }

    public void setNamaGunungProfesional(String namaGunungProfesional) {
        NamaGunungProfesional = namaGunungProfesional;
    }

    public String getLokasiGunungProfesional() {
        return LokasiGunungProfesional;
    }

    public void setLokasiGunungProfesional(String lokasiGunungProfesional) {
        LokasiGunungProfesional = lokasiGunungProfesional;
    }

    public String getSuhuGunungProfesional() {
        return SuhuGunungProfesional;
    }

    public void setSuhuGunungProfesional(String suhuGunungProfesional) {
        SuhuGunungProfesional = suhuGunungProfesional;
    }

    public String getDeskripsiGunungProfesional() {
        return DeskripsiGunungProfesional;
    }

    public void setDeskripsiGunungProfesional(String deskripsiGunungProfesional) {
        DeskripsiGunungProfesional = deskripsiGunungProfesional;
    }

    public String getBarangGunungProfesional() {
        return BarangGunungProfesional;
    }

    public void setBarangGunungProfesional(String barangGunungProfesional) {
        BarangGunungProfesional = barangGunungProfesional;
    }

    public String getKetinggianGunungProfesional() {
        return KetinggianGunungProfesional;
    }

    public void setKetinggianGunungProfesional(String ketinggianGunungProfesional) {
        KetinggianGunungProfesional = ketinggianGunungProfesional;
    }

    public String getRuteGunungProfesional() {
        return RuteGunungProfesional;
    }

    public void setRuteGunungProfesional(String ruteGunungProfesional) {
        RuteGunungProfesional = ruteGunungProfesional;
    }

    public String getPaketGunungProfesional() {
        return PaketGunungProfesional;
    }

    public void setPaketGunungProfesional(String paketGunungProfesional) {
        PaketGunungProfesional = paketGunungProfesional;
    }

    public String getFotoGunungProfesional() {
        return FotoGunungProfesional;
    }

    public void setFotoGunungProfesional(String fotoGunungProfesional) {
        FotoGunungProfesional = fotoGunungProfesional;
    }
}
