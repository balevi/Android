package com.example.fut.Banco;

import java.io.Serializable;

public class ContratanteClass implements Serializable {
    Integer id;
    String txtLoginCont;
    String txtSenhaCont;


    public ContratanteClass() {
    }

    public ContratanteClass(String name, String password) {
        this.txtLoginCont=name;
        this.txtSenhaCont=password;
    }

    public ContratanteClass(int id) {
        this.id=id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTxtLoginCont() {
        return txtLoginCont;
    }

    public void setTxtLoginCont(String txtLoginCont) {
        this.txtLoginCont = txtLoginCont;
    }

    public String getTxtSenhaCont() {
        return txtSenhaCont;
    }

    public void setTxtSenhaCont(String txtSenhaCont) {
        this.txtSenhaCont = txtSenhaCont;
    }
}
