package com.raion.putrautama.mounesiaprototype.Model;

import java.io.Serializable;

public class Users implements Serializable {

    private String Username;
    private String NamaLengkap;
    private String NoTlp;
    private String Email;
    private String Password;
    private String UniqueId;
    private String Foto;
    private Pesanan Pesanan;
    private NilaiPemula NilaiPemula;
    private NilaiMenengah NilaiMenengah;
    private NilaiProfesional NilaiProfesional;

    public Users(String username, String namaLengkap, String noTlp, String email, String password,String uniqueId, String foto, Pesanan pesanan, NilaiPemula nilaiPemula, NilaiMenengah nilaiMenengah,NilaiProfesional nilaiProfesional) {
        Username = username;
        NamaLengkap = namaLengkap;
        NoTlp = noTlp;
        Email = email;
        Password = password;
        UniqueId = uniqueId;
        Foto = foto;
        Pesanan = pesanan;
        NilaiPemula = nilaiPemula;
        NilaiMenengah = nilaiMenengah;
        NilaiProfesional = nilaiProfesional;
    }

    public Users(){

    }

    public String getUniqueId() {
        return UniqueId;
    }

    public void setUniqueId(String uniqueId) {
        UniqueId = uniqueId;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    public Pesanan getPesanan() {
        return Pesanan;
    }

    public void setPesanan(Pesanan pesanan) {
        Pesanan = pesanan;
    }

    public NilaiPemula getNilaiPemula() {
        return NilaiPemula;
    }

    public void setNilaiPemula(NilaiPemula nilaiPemula) {
        NilaiPemula = nilaiPemula;
    }

    public NilaiMenengah getNilaiMenengah() {
        return NilaiMenengah;
    }

    public void setNilaiMenengah(NilaiMenengah nilaiMenengah) {
        NilaiMenengah = nilaiMenengah;
    }

    public NilaiProfesional getNilaiProfesional() {
        return NilaiProfesional;
    }

    public void setNilaiProfesional(NilaiProfesional nilaiProfesional) {
        NilaiProfesional = nilaiProfesional;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getNamaLengkap() {
        return NamaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        NamaLengkap = namaLengkap;
    }

    public String getNoTlp() {
        return NoTlp;
    }

    public void setNoTlp(String noTlp) {
        NoTlp = noTlp;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
