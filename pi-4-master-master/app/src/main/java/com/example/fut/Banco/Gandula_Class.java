package com.example.fut.Banco;

import java.io.Serializable;

public class Gandula_Class implements Serializable {
    Integer id;
    String txtLoginGand;
    String txtSenhaGand;
    String txtNomeGand;
    String txtIdadeGand;
    String txtBairroGand;
    String txtTelGand;
    private Integer LikeGand;
    private Integer DeslikeGand;

    public Gandula_Class() {
    }



    public Gandula_Class(int id) {
        this.id=id;
    }

    public Gandula_Class(String name, String password) {
        this.txtLoginGand=name;
        this.txtSenhaGand=password;
    }

    public Gandula_Class(String Login, String Senha, String Nome, String Idade,String Bairro, String Telefone, int Like, int Deslike) {
        this.txtLoginGand=Login;
        this.txtSenhaGand = Senha;
        this.txtNomeGand = Nome;
        this.txtIdadeGand = Idade;
        this.txtBairroGand = Bairro;
        this.txtTelGand = Telefone;
        this.LikeGand = Like;
        this.DeslikeGand = Deslike;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTxtLoginGand() {
        return txtLoginGand;
    }

    public void setTxtLoginGand(String txtLoginGand) {
        this.txtLoginGand = txtLoginGand;
    }

    public String getTxtSenhaGand() {
        return txtSenhaGand;
    }

    public void setTxtSenhaGand(String txtSenhaGand) {
        this.txtSenhaGand = txtSenhaGand;
    }

    public String getTxtNomeGand() {
        return txtNomeGand;
    }

    public void setTxtNomeGand(String txtNomeGand) {
        this.txtNomeGand = txtNomeGand;
    }

    public String getTxtIdadeGand() {
        return txtIdadeGand;
    }

    public void setTxtIdadeGand(String txtIdadeGand) {
        this.txtIdadeGand = txtIdadeGand;
    }

    public String getTxtBairroGand() {
        return txtBairroGand;
    }

    public void setTxtBairroGand(String txtBairroGand) {
        this.txtBairroGand = txtBairroGand;
    }

    public String getTxtTelGand() {
        return txtTelGand;
    }

    public void setTxtTelGand(String txtTelGand) {
        this.txtTelGand = txtTelGand;
    }

    public Integer getLikeGand() {
        return LikeGand;
    }

    public void setLikeGand(Integer likeGand) {
        LikeGand = likeGand;
    }

    public Integer getDeslikeGand() {
        return DeslikeGand;
    }

    public void setDeslikeGand(Integer deslikeGand) {
        DeslikeGand = deslikeGand;
    }

}
