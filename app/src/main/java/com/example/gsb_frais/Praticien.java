package com.example.gsb_frais;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Praticien implements Serializable {

    @SerializedName("id")
    private Integer id;
    @SerializedName("pra_nom")
    private String pra_nom;
    @SerializedName("pra_prenom")
    private String pra_prenom;
    @SerializedName("pra_tel")
    private String pra_tel;
    @SerializedName("pra_mail")
    private String pra_mail;
    @SerializedName("pra_rue")
    private String pra_rue;
    @SerializedName("pra_code_postale")
    private String pra_code_postale;
    @SerializedName("pra_ville")
    private String pra_ville;
    @SerializedName("pra_coef_notoriete")
    private Integer pra_coef_notoriete;
    @SerializedName("pra_visites")
    private List<String> visites;
    private ArrayList<Visites> lesVisites;

    public Praticien(Integer id, String pra_nom, String pra_prenom, String pra_tel, String pra_mail, String pra_rue, String pra_code_postale, String pra_ville, Integer pra_coef_notoriete) {
        this.id = id;
        this.pra_nom = pra_nom;
        this.pra_prenom = pra_prenom;
        this.pra_tel = pra_tel;
        this.pra_mail = pra_mail;
        this.pra_rue = pra_rue;
        this.pra_code_postale = pra_code_postale;
        this.pra_ville = pra_ville;
        this.pra_coef_notoriete = pra_coef_notoriete;
    }

    public void add(Visites uneVisite){
        if(lesVisites == null){
            lesVisites = new ArrayList<>();
        }
        lesVisites.add(uneVisite);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPra_nom() {
        return pra_nom;
    }

    public void setPra_nom(String pra_nom) {
        this.pra_nom = pra_nom;
    }

    public String getPra_prenom() {
        return pra_prenom;
    }

    public void setPra_prenom(String pra_prenom) {
        this.pra_prenom = pra_prenom;
    }

    public String getPra_tel() {
        return pra_tel;
    }

    public void setPra_tel(String pra_tel) {
        this.pra_tel = pra_tel;
    }

    public String getPra_mail() {
        return pra_mail;
    }

    public void setPra_mail(String pra_mail) {
        this.pra_mail = pra_mail;
    }

    public String getPra_rue() {
        return pra_rue;
    }

    public void setPra_rue(String pra_rue) {
        this.pra_rue = pra_rue;
    }

    public String getPra_code_postale() {
        return pra_code_postale;
    }

    public void setPra_code_postale(String pra_code_postale) {
        this.pra_code_postale = pra_code_postale;
    }

    public String getPra_ville() {
        return pra_ville;
    }

    public void setPra_ville(String pra_ville) {
        this.pra_ville = pra_ville;
    }

    public Integer getPra_coef_notoriete() {
        return pra_coef_notoriete;
    }

    public void setPra_coef_notoriete(Integer pra_coef_notoriete) {
        this.pra_coef_notoriete = pra_coef_notoriete;
    }

    public List<String> getVisites() {
        return visites;
    }

    public ArrayList<Visites> getLesVisites() {
        return lesVisites;
    }

    public void setVisites(List<String> visites) {
        this.visites = visites;
    }
}
