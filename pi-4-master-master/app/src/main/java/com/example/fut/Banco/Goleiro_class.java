package com.example.fut.Banco;

import java.io.Serializable;

public class Goleiro_class implements Serializable {
        private Integer id;
        private String txtLoginGol;
        private String txtSenhaGol;
        private String txtNomeGol;
        private String txtPrecisa;
        private String txtBairroGol;
        private String txtTelGol;
        private String DataJogo;
        private String HoraJogo;
        private Integer LikeGol;
        private Integer DeslikeGol;


    public Goleiro_class(String name, String password) {
        this.txtLoginGol=name;
        this.txtSenhaGol=password;
    }

    public Goleiro_class(int id) {
        this.id=id;
    }

    public Goleiro_class() {

    }

    public Goleiro_class(String Login, String Senha, String Nome, String Bairro, String Telefone, int Like, int Deslike) {
        this.txtLoginGol=Login;
        this.txtSenhaGol = Senha;
        this.txtNomeGol = Nome;
        this.txtBairroGol = Bairro;
        this.txtTelGol = Telefone;
        this.LikeGol = Like;
        this.DeslikeGol = Deslike;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTxtLoginGol() {
        return txtLoginGol;
    }

    public void setTxtLoginGol(String txtLoginGol) {
        this.txtLoginGol = txtLoginGol;
    }

    public String getTxtSenhaGol() {
        return txtSenhaGol;
    }

    public void setTxtSenhaGol(String txtSenhaGol) {
        this.txtSenhaGol = txtSenhaGol;
    }

    public String getTxtNomeGol() {
        return txtNomeGol;
    }

    public void setTxtNomeGol(String txtNomeGol) {
        this.txtNomeGol = txtNomeGol;
    }

    public String getTxtPrecisa() {
        return txtPrecisa;
    }

    public void setTxtPrecisa(String txtPrecisa) {
        this.txtPrecisa = txtPrecisa;
    }

    public String getTxtBairroGol() {
        return txtBairroGol;
    }

    public void setTxtBairroGol(String txtBairroGol) {
        this.txtBairroGol = txtBairroGol;
    }

    public String getTxtTelGol() {
        return txtTelGol;
    }

    public void setTxtTelGol(String txtTelGol) {
        this.txtTelGol = txtTelGol;
    }

    public String getDataJogo() {
        return DataJogo;
    }

    public void setDataJogo(String dataJogo) {
        DataJogo = dataJogo;
    }

    public String getHoraJogo() {
        return HoraJogo;
    }

    public void setHoraJogo(String horaJogo) {
        HoraJogo = horaJogo;
    }

    public Integer getLikeGol() {
        return LikeGol;
    }

    public void setLikeGol(Integer likeGol) {
        LikeGol = likeGol;
    }

    public Integer getDeslikeGol() {
        return DeslikeGol;
    }

    public void setDeslikeGol(Integer deslikeGol) {
        DeslikeGol = deslikeGol;
    }


}
