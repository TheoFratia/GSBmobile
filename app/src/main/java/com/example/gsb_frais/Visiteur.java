package com.example.gsb_frais;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Visiteur  implements Serializable {

    @SerializedName("id")
    private Integer id;
    @SerializedName("email")
    private String email;
    @SerializedName("vis_nom")
    private String vis_nom;
    @SerializedName("vis_prenom")
    private String vis_prenom;
    @SerializedName("vis_tel")
    private String vis_tel;
    @SerializedName("vis_date_embauche")
    private String vis_date_embauche;
    @SerializedName("password")
    private String password;
    @SerializedName("username")
    private String username;

    @SerializedName("vis_praticiens")
    private List<String> praticiens;

    private ArrayList<Praticien> lesPraticiens;

    public Visiteur(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public void add(Praticien unPraticien){
        if(lesPraticiens == null){
            lesPraticiens = new ArrayList<>();
        }
        lesPraticiens.add(unPraticien);
    }
    public ArrayList<Praticien> getLesPraticiens() {
        return lesPraticiens;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVis_nom() {
        return vis_nom;
    }

    public void setVis_nom(String vis_nom) {
        this.vis_nom = vis_nom;
    }

    public String getVis_prenom() {
        return vis_prenom;
    }

    public void setVis_prenom(String vis_prenom) {
        this.vis_prenom = vis_prenom;
    }

    public String getVis_tel() {
        return vis_tel;
    }

    public void setVis_tel(String vis_tel) {
        this.vis_tel = vis_tel;
    }

    public String getVis_date_embauche() {
        return vis_date_embauche;
    }

    public void setVis_date_embauche(String vis_date_embauche) {
        this.vis_date_embauche = vis_date_embauche;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getPraticien() {
        return praticiens;
    }

    public void setPraticien(List<String> praticiens) {
        this.praticiens = praticiens;
    }
}
