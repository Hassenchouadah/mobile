/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;



/**
 *
 * @author LENOVO
 */
public class Avis {
    
      private int idavis;
    private String descavis;
    private String dateajoutavis;
    private int etoile;

    public Avis() {
    }

    public Avis(int idavis, String descavis, String dateajoutavis, int etoile) {
        this.idavis = idavis;
        this.descavis = descavis;
        this.dateajoutavis = dateajoutavis;
        this.etoile = etoile;
    }

    public Avis(String descavis, String dateajoutavis, int etoile) {
        this.descavis = descavis;
        this.dateajoutavis = dateajoutavis;
        this.etoile = etoile;
    }

    public Avis(String text) {
    }

    public int getId_avis() {
        return idavis;
    }

    public void setIdAvis(int id_avis) {
        this.idavis = id_avis;
    }

    public String getDescavis() {
        return descavis;
    }

    public void setDescavis(String descavis) {
        this.descavis = descavis;
    }

    public String getDateajoutavis() {
        return dateajoutavis;
    }

    public void setDateajoutavis(String dateajoutavis) {
        this.dateajoutavis = dateajoutavis;
    }

    public int getEtoile() {
        return etoile;
    }

    public void setEtoile(int etoile) {
        this.etoile = etoile;
    }
    
    
    


    
    
    
    
    
}
