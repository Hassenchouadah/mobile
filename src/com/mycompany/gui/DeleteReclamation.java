/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.l10n.ParseException;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.mycompany.entities.Reclamation;
import com.mycompany.services.ServiceReclamation;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class DeleteReclamation extends Form {
    
    public DeleteReclamation(Form previous){
        setTitle("Suppriler");
        setLayout(BoxLayout.y());
            
            
        Picker reclamationVal = new Picker();
        //String[] stringArray = null;
        ArrayList<String> sstringArray = new ArrayList<String>();
            reclamationVal.setType(Display.PICKER_TYPE_STRINGS);
        ArrayList<Reclamation> reclamations = ServiceReclamation.getInstance().getReclamation();
            //System.out.println(reclamations);
        for (Reclamation i : reclamations) {
            //System.out.println(i);
            sstringArray.add("\""+(i.getIdRec())+"\" "+i.getDescrec());
        }
        System.out.println(sstringArray);
        String[] pickerList= new String[sstringArray.size()];
        for(int i=0;i<sstringArray.size();i++){
            pickerList[i]=sstringArray.get(i);
        }
        //String[] stringArray = sstringArray.stream().toArray(String[]::new);

        //String[] stringArray = reservations.toArray(new String[0]);

        //String[] stringArray = Arrays.copyOf(reservations, reservations.size(), String[].class);


            reclamationVal.setStrings(pickerList);
            reclamationVal.setSelectedString("Pick One..");
            Button btnAnnuler = new Button("Supprimer");

                btnAnnuler.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (reclamationVal.getSelectedString()=="Pick One..") {
                            Dialog.show("Erreur","Merci de choisir",new Command("OK"));
                        } else {
                            String idrec = reclamationVal.getSelectedString();
                            idrec = idrec.substring(1, idrec.indexOf("\"",2) );
                            System.out.println(idrec);
                            //int idRes = reservationVal.getSelectedString()
                            ServiceReclamation.getInstance().deleteReclamation(Integer.parseInt(idrec));
                            Dialog.show("Succées","Réclamation Annulée Avec Succées",new Command("OK"));
                        } //Logger.getLogger(ValidateReservation.class.getName()).log(Level.SEVERE, null, ex);
                        //Logger.getLogger(AddReservationForm.class.getName()).log(Level.SEVERE, null, ex);
                        //Logger.getLogger(AddReservationForm.class.getName()).log(Level.SEVERE, null, ex);

                }
                });
            
            
        addAll(reclamationVal,btnAnnuler);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
        }

    }
    

