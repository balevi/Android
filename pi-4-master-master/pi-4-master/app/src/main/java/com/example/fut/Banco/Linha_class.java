package com.example.fut.Banco;

import java.io.Serializable;

public class Linha_class implements Serializable {
    private  Integer id;
    private String txtLoginLinha;
    private String txtSenhaLinha;
    private String txtNomeLinha;
    private String txtIdadeLinha;
    private String txtAlturaLinha;
    private String txtPesoLinha;
    private String txtBairroLinha;
   private String spinLinha;
   private String txtTelLinha;
    private Integer LikeLinha;
    private Integer DeslikeLinha;

    public Linha_class(String name, String password) {
        this.txtLoginLinha=name;
        this.txtSenhaLinha=password;
    }

    public Linha_class() {
    }

    public Linha_class(int id) {
        this.id=id;
    }

    public Linha_class(String Login, String Senha, String Nome, String Idade, String Altura, String Peso, String Bairro,String Posicao, String Telefone, int Like, int Deslike) {
        this.txtLoginLinha=Login;
        this.txtSenhaLinha = Senha;
        this.txtNomeLinha = Nome;
        this.txtIdadeLinha = Idade;
        this.txtAlturaLinha= Altura;
        this.txtPesoLinha = Peso;
        this.txtBairroLinha = Bairro;
        this.spinLinha = Posicao;
        this.txtTelLinha = Telefone;
        this.LikeLinha = Like;
        this.DeslikeLinha = Deslike;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTxtLoginLinha() {
        return txtLoginLinha;
    }

    public void setTxtLoginLinha(String txtLoginLinha) {
        this.txtLoginLinha = txtLoginLinha;
    }

    public String getTxtSenhaLinha() {
        return txtSenhaLinha;
    }

    public void setTxtSenhaLinha(String txtSenhaLinha) {
        this.txtSenhaLinha = txtSenhaLinha;
    }

    public String getTxtNomeLinha() {
        return txtNomeLinha;
    }

    public void setTxtNomeLinha(String txtNomeLinha) {
        this.txtNomeLinha = txtNomeLinha;
    }

    public String getTxtIdadeLinha() {
        return txtIdadeLinha;
    }

    public void setTxtIdadeLinha(String txtIdadeLinha) {
        this.txtIdadeLinha = txtIdadeLinha;
    }

    public String getTxtAlturaLinha() {
        return txtAlturaLinha;
    }

    public void setTxtAlturaLinha(String txtAlturaLinha) {
        this.txtAlturaLinha = txtAlturaLinha;
    }

    public String getTxtPesoLinha() {
        return txtPesoLinha;
    }

    public void setTxtPesoLinha(String txtPesoLinha) {
        this.txtPesoLinha = txtPesoLinha;
    }

    public String getTxtBairroLinha() {
        return txtBairroLinha;
    }

    public void setTxtBairroLinha(String txtBairroLinha) {
        this.txtBairroLinha = txtBairroLinha;
    }

    public String getSpinLinha() {
        return spinLinha;
    }

    public void setSpinLinha(String spinLinha) {
        this.spinLinha = spinLinha;
    }

    public String getTxtTelLinha() {
        return txtTelLinha;
    }

    public void setTxtTelLinha(String txtTelLinha) {
        this.txtTelLinha = txtTelLinha;
    }

    public Integer getLikeLinha() {
        return LikeLinha;
    }

    public void setLikeLinha(Integer likeLinha) {
        LikeLinha = likeLinha;
    }

    public Integer getDeslikeLinha() {
        return DeslikeLinha;
    }

    public void setDeslikeLinha(Integer deslikeLinha) {
        DeslikeLinha = deslikeLinha;
    }


}
