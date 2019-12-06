package com.example.fut.Banco;

import java.io.Serializable;

public class Juiz_Class implements Serializable {
    Integer id;
    String txtLoginJuiz;
    String txtSenhaJuiz;
    String txtNomeJuiz;
    String txtIdadeJuiz;
    String BairroJuiz;
    String txtTelJuiz;
    Integer LikeJuiz;
    Integer DeslikeJuiz;


    public Juiz_Class(String name, String password) {
        this.txtLoginJuiz=name;
        this.txtSenhaJuiz=password;
    }

    public Juiz_Class(int id) {
        this.id=id;
    }

    public Juiz_Class() {
    }

    public Juiz_Class(String Login, String Senha, String Nome, String Idade,String Bairro, String Telefone, int Like, int Deslike) {
        this.txtLoginJuiz=Login;
        this.txtSenhaJuiz = Senha;
        this.txtNomeJuiz = Nome;
        this.txtIdadeJuiz = Idade;
        this.BairroJuiz = Bairro;
        this.txtTelJuiz = Telefone;
        this.LikeJuiz = Like;
        this.DeslikeJuiz = Deslike;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTxtLoginJuiz() {
        return txtLoginJuiz;
    }

    public void setTxtLoginJuiz(String txtLoginJuiz) {
        this.txtLoginJuiz = txtLoginJuiz;
    }

    public String getTxtSenhaJuiz() {
        return txtSenhaJuiz;
    }

    public void setTxtSenhaJuiz(String txtSenhaJuiz) {
        this.txtSenhaJuiz = txtSenhaJuiz;
    }

    public String getTxtNomeJuiz() {
        return txtNomeJuiz;
    }

    public void setTxtNomeJuiz(String txtNomeJuiz) {
        this.txtNomeJuiz = txtNomeJuiz;
    }

    public String getTxtIdadeJuiz() {
        return txtIdadeJuiz;
    }

    public void setTxtIdadeJuiz(String txtIdadeJuiz) {
        this.txtIdadeJuiz = txtIdadeJuiz;
    }

    public String getBairroJuiz() {
        return BairroJuiz;
    }

    public void setBairroJuiz(String bairroJuiz) {
        BairroJuiz = bairroJuiz;
    }

    public String getTxtTelJuiz() {
        return txtTelJuiz;
    }

    public void setTxtTelJuiz(String txtTelJuiz) {
        this.txtTelJuiz = txtTelJuiz;
    }

    public Integer getLikeJuiz() {
        return LikeJuiz;
    }

    public void setLikeJuiz(Integer likeJuiz) {
        LikeJuiz = likeJuiz;
    }

    public Integer getDeslikeJuiz() {
        return DeslikeJuiz;
    }

    public void setDeslikeJuiz(Integer deslikeJuiz) {
        DeslikeJuiz = deslikeJuiz;
    }


}
