package com.raion.putrautama.mounesiaprototype.Model;

import java.io.Serializable;

public class GunungPemula implements Serializable{
    String NamaGunungPemula;
    String LokasiGunungPemula;
    String SuhuGunungPemula;
    String DeskripsiGunungPemula;
    String BarangGunungPemula;
    String KetinggianGunungPemula;
    String RuteGunungPemula;
    String PaketGunungPemula;
    int HargaGunungPemula;
    String FotoGunungPemula;

    public GunungPemula(String namaGunungPemula, String lokasiGunungPemula, String suhuGunungPemula,
                        String deskripsiGunungPemula, String barangGunungPemula,
                        String ketinggianGunungPemula, String ruteGunungPemula, String paketGunungPemula
            ,int hargaGunungPemula, String fotoGunungPemula) {
        NamaGunungPemula = namaGunungPemula;
        LokasiGunungPemula = lokasiGunungPemula;
        SuhuGunungPemula = suhuGunungPemula;
        DeskripsiGunungPemula = deskripsiGunungPemula;
        BarangGunungPemula = barangGunungPemula;
        KetinggianGunungPemula = ketinggianGunungPemula;
        RuteGunungPemula = ruteGunungPemula;
        PaketGunungPemula = paketGunungPemula;
        HargaGunungPemula = hargaGunungPemula;
        FotoGunungPemula = fotoGunungPemula;
    }

//    public GunungPemula(String namaGunungPemula, String lokasiGunungPemula, String ketinggianGunungPemula, String suhuGunungPemula, int fotoGunungPemula){
//        NamaGunungPemula = namaGunungPemula;
//        LokasiGunungPemula = lokasiGunungPemula;
//        SuhuGunungPemula = suhuGunungPemula;
//        KetinggianGunungPemula = ketinggianGunungPemula;
//        FotoGunungPemula = fotoGunungPemula;
//    }


    public String getNamaGunungPemula() {
        return NamaGunungPemula;
    }

    public int getHargaGunungPemula() {
        return HargaGunungPemula;
    }

    public void setHargaGunungPemula(int hargaGunungPemula) {
        HargaGunungPemula = hargaGunungPemula;
    }

    public void setNamaGunungPemula(String namaGunungPemula) {
        NamaGunungPemula = namaGunungPemula;
    }

    public String getLokasiGunungPemula() {
        return LokasiGunungPemula;
    }

    public void setLokasiGunungPemula(String lokasiGunungPemula) {
        LokasiGunungPemula = lokasiGunungPemula;
    }

    public String getSuhuGunungPemula() {
        return SuhuGunungPemula;
    }

    public void setSuhuGunungPemula(String suhuGunungPemula) {
        SuhuGunungPemula = suhuGunungPemula;
    }

    public String getDeskripsiGunungPemula() {
        return DeskripsiGunungPemula;
    }

    public void setDeskripsiGunungPemula(String deskripsiGunungPemula) {
        DeskripsiGunungPemula = deskripsiGunungPemula;
    }

    public String getBarangGunungPemula() {
        return BarangGunungPemula;
    }

    public void setBarangGunungPemula(String barangGunungPemula) {
        BarangGunungPemula = barangGunungPemula;
    }

    public String getKetinggianGunungPemula() {
        return KetinggianGunungPemula;
    }

    public void setKetinggianGunungPemula(String ketinggianGunungPemula) {
        KetinggianGunungPemula = ketinggianGunungPemula;
    }

    public String getRuteGunungPemula() {
        return RuteGunungPemula;
    }

    public void setRuteGunungPemula(String ruteGunungPemula) {
        RuteGunungPemula = ruteGunungPemula;
    }

    public String getPaketGunungPemula() {
        return PaketGunungPemula;
    }

    public void setPaketGunungPemula(String paketGunungPemula) {
        PaketGunungPemula = paketGunungPemula;
    }

    public String getFotoGunungPemula() {
        return FotoGunungPemula;
    }

    public void setFotoGunungPemula(String fotoGunungPemula) {
        FotoGunungPemula = fotoGunungPemula;
    }
}