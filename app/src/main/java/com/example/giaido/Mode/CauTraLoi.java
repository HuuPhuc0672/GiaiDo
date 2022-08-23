package com.example.giaido.Mode;

public class CauTraLoi {
    private  String dapAn;
    public  boolean dungSai;

    public CauTraLoi() {
    }

    public CauTraLoi(String dapAn, boolean dungSai) {
        this.dapAn = dapAn;
        this.dungSai = dungSai;
    }

    public String getDapAn() {
        return dapAn;
    }

    public void setDapAn(String dapAn) {
        this.dapAn = dapAn;
    }

    public boolean isDungSai() {
        return dungSai;
    }

    public void setDungSai(boolean dungSai) {
        this.dungSai = dungSai;
    }
}
