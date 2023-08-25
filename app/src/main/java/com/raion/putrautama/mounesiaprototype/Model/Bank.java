package com.raion.putrautama.mounesiaprototype.Model;

import java.io.Serializable;

public class Bank implements Serializable {
    private String NamaBank;

    public Bank(String namaBank) {
        NamaBank = namaBank;
    }

    public Bank() {

    }

    public String getNamaBank() {
        return NamaBank;
    }

    public void setNamaBank(String namaBank) {
        NamaBank = namaBank;
    }
}
