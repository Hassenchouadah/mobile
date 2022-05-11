/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class Reclamation {
    
    private int idRec;
    private String descrec;
    private String dateajoutrec;
    private Date datetraitrec;
    private String dateee;

    public String getDateee() {
        return dateee;
    }

    public void setDateee(String dateee) {
        this.dateee = dateee;
    }
    private int traite;

    public Reclamation() {
    }
    
     public Reclamation( String descrec) {
        this.descrec = descrec;
       
    }

    public Reclamation(int idRec, String descrec, String dateajoutrec, Date datetraitrec, int traite) {
        this.idRec = idRec;
        this.descrec = descrec;
        this.dateajoutrec = dateajoutrec;
        this.datetraitrec = datetraitrec;
        this.traite = traite;
    }

    public Reclamation(String descrec, String dateajoutrec, Date datetraitrec, int traite) {
        this.descrec = descrec;
        this.dateajoutrec = dateajoutrec;
        this.datetraitrec = datetraitrec;
        this.traite = traite;
    }

    public int getIdRec() {
        return idRec;
    }

    public void setIdRec(int idRec) {
        this.idRec = idRec;
    }

    public String getDescrec() {
        return descrec;
    }

    public void setDescrec(String descrec) {
        this.descrec = descrec;
    }

    public String getDateajoutrec() {
        return dateajoutrec;
    }

    public void setDateajoutrec(String dateajoutrec) {
        this.dateajoutrec = dateajoutrec;
    }

    public Date getDatetraitrec() {
        return datetraitrec;
    }

    public void setDatetraitrec(Date datetraitrec) {
        this.datetraitrec = datetraitrec;
    }

    public int getTraite() {
        return traite;
    }

    public void setTraite(int traite) {
        this.traite = traite;
    }

    @Override
    public String toString() {
        String ch="";
        if(traite==0){
            ch="Non traité";
        }else{
            ch="Traité";
        }
        return "Reclamation " + idRec + ": " + descrec + " Ajoutée Le " + dateajoutrec.substring(0, 10) + "("+ ch +")";
    }
    
    
}
