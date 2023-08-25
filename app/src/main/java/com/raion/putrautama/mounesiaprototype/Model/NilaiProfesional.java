package com.raion.putrautama.mounesiaprototype.Model;

import java.io.Serializable;

public class NilaiProfesional implements Serializable {
    private int NilaiProfesional;

    public NilaiProfesional(int nilaiProfesional) {
        NilaiProfesional = nilaiProfesional;
    }

    public NilaiProfesional(){

    }

    public int getNilaiProfesional() {
        return NilaiProfesional;
    }

    public void setNilaiProfesional(int nilaiProfesional) {
        NilaiProfesional = nilaiProfesional;
    }
}
