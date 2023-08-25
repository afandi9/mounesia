package com.raion.putrautama.mounesiaprototype.Model;

import java.io.Serializable;

public class NilaiPemula implements Serializable {
    private int NilaiPemula;

    public NilaiPemula(int nilaiPemula) {
        NilaiPemula = nilaiPemula;
    }

    public NilaiPemula(){

    }

    public int getNilaiPemula() {
        return NilaiPemula;
    }

    public void setNilaiPemula(int nilaiPemula) {
        NilaiPemula = nilaiPemula;
    }
}
