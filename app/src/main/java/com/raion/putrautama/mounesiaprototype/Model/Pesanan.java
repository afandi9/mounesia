package com.raion.putrautama.mounesiaprototype.Model;

import java.io.Serializable;

public class Pesanan implements Serializable {

    private String NamaGunung;
    private String LokasiGunung;
    private String SuhuGunung;
    private String DeskripsiGunung;
    private String BarangGunung;
    private String KetinggianGunung;
    private String RuteGunung;
    private String PaketGunung;
    private int HargaPaket;
    private String FotoGunung;

    private String Nama;
    private String Notlp;
    private String Email;
    private String TglBooking;
    private int JumlahOrang;
    private String CatatanTambahan;
    private Bank NamaBank;

    public Pesanan(String namaGunung, String lokasiGunung, String suhuGunung
            , String deskripsiGunung, String barangGunung, String ketinggianGunung
            , String ruteGunung, String paketGunung,int hargaPaket ,String fotoGunung, String nama
            , String notlp, String email, String tglBooking, int jumlahOrang
            , String catatanTambahan) {
        NamaGunung = namaGunung;
        LokasiGunung = lokasiGunung;
        SuhuGunung = suhuGunung;
        DeskripsiGunung = deskripsiGunung;
        BarangGunung = barangGunung;
        KetinggianGunung = ketinggianGunung;
        RuteGunung = ruteGunung;
        PaketGunung = paketGunung;
        HargaPaket = hargaPaket;
        FotoGunung = fotoGunung;
        Nama = nama;
        Notlp = notlp;
        Email = email;
        TglBooking = tglBooking;
        JumlahOrang = jumlahOrang;
        CatatanTambahan = catatanTambahan;
    }

    public Pesanan(String namaGunung, String lokasiGunung, String suhuGunung
            , String deskripsiGunung, String barangGunung, String ketinggianGunung
            , String ruteGunung, String paketGunung, String fotoGunung
            , String nama, String notlp, String email
            , String tglBooking, int jumlahOrang
            , String catatanTambahan, Bank namaBank) {
        NamaGunung = namaGunung;
        LokasiGunung = lokasiGunung;
        SuhuGunung = suhuGunung;
        DeskripsiGunung = deskripsiGunung;
        BarangGunung = barangGunung;
        KetinggianGunung = ketinggianGunung;
        RuteGunung = ruteGunung;
        PaketGunung = paketGunung;
        FotoGunung = fotoGunung;
        Nama = nama;
        Notlp = notlp;
        Email = email;
        TglBooking = tglBooking;
        JumlahOrang = jumlahOrang;
        CatatanTambahan = catatanTambahan;
        NamaBank = namaBank;
    }

    public Pesanan() {
    }

    public Pesanan(int hargaPaket) {
    }

    public int getHargaPaket() {
        return HargaPaket;
    }

    public void setHargaPaket(int hargaPaket) {
        HargaPaket = hargaPaket;
    }

    public Bank getNamaBank() {
        return NamaBank;
    }

    public void setNamaBank(Bank namaBank) {
        NamaBank = namaBank;
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

    public String getDeskripsiGunung() {
        return DeskripsiGunung;
    }

    public void setDeskripsiGunung(String deskripsiGunung) {
        DeskripsiGunung = deskripsiGunung;
    }

    public String getBarangGunung() {
        return BarangGunung;
    }

    public void setBarangGunung(String barangGunung) {
        BarangGunung = barangGunung;
    }

    public String getKetinggianGunung() {
        return KetinggianGunung;
    }

    public void setKetinggianGunung(String ketinggianGunung) {
        KetinggianGunung = ketinggianGunung;
    }

    public String getRuteGunung() {
        return RuteGunung;
    }

    public void setRuteGunung(String ruteGunung) {
        RuteGunung = ruteGunung;
    }

    public String getPaketGunung() {
        return PaketGunung;
    }

    public void setPaketGunung(String paketGunung) {
        PaketGunung = paketGunung;
    }

    public String getFotoGunung() {
        return FotoGunung;
    }

    public void setFotoGunung(String fotoGunung) {
        FotoGunung = fotoGunung;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getNotlp() {
        return Notlp;
    }

    public void setNotlp(String notlp) {
        Notlp = notlp;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTglBooking() {
        return TglBooking;
    }

    public void setTglBooking(String tglBooking) {
        TglBooking = tglBooking;
    }

    public int getJumlahOrang() {
        return JumlahOrang;
    }

    public void setJumlahOrang(int jumlahOrang) {
        JumlahOrang = jumlahOrang;
    }

    public String getCatatanTambahan() {
        return CatatanTambahan;
    }

    public void setCatatanTambahan(String catatanTambahan) {
        CatatanTambahan = catatanTambahan;
    }
}
