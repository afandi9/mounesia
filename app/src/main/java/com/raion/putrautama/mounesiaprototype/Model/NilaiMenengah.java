package com.raion.putrautama.mounesiaprototype.Model;

import java.io.Serializable;

public class NilaiMenengah implements Serializable {

    private int NilaiMenengah;

    public NilaiMenengah(int nilaiMenengah) {
        NilaiMenengah = nilaiMenengah;
    }

    public NilaiMenengah(){

    }

    public int getNilaiMenengah() {
        return NilaiMenengah;
    }

    public void setNilaiMenengah(int nilaiMenengah) {
        NilaiMenengah = nilaiMenengah;
    }
}
