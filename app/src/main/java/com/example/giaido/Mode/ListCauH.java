package com.example.giaido.Mode;

import java.util.List;

public class ListCauH {
    private int cauSo;
    private String cauHoi;
    private List<CauTraLoi> cauTraLois;

    public ListCauH() {
    }

    public ListCauH(int cauSo, String cauHoi, List<CauTraLoi> cauTraLois) {
        this.cauSo = cauSo;
        this.cauHoi = cauHoi;
        this.cauTraLois = cauTraLois;
    }

    public int getCauSo() {
        return cauSo;
    }

    public void setCauSo(int cauSo) {
        this.cauSo = cauSo;
    }

    public String getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }

    public List<CauTraLoi> getCauTraLois() {
        return cauTraLois;
    }

    public void setCauTraLois(List<CauTraLoi> cauTraLois) {
        this.cauTraLois = cauTraLois;
    }
}
