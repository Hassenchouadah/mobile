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
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.entities.Reclamation;
import com.mycompany.services.ServiceReclamation;

/**
 *
 * @author Houssem
 */
public class ReclamationForm extends Form {

    
    public ReclamationForm(Form previous) {
        setTitle("Ajouter");
        setLayout(BoxLayout.y());
        
        /*

        TextField tfnbPersonne = new TextField("","Nombre des Personnes");
        TextField tfnbChambre = new TextField("","Nombre des Chambres");
        TextField tfnbSuite = new TextField("","Nombre des Suites");
        Picker pdateArr = new Picker();
        pdateArr.setType(Display.PICKER_TYPE_DATE);
        Picker pdateDep = new Picker();
        pdateDep.setType(Display.PICKER_TYPE_DATE);
        Picker pforfait = new Picker();
            pforfait.setType(Display.PICKER_TYPE_STRINGS);
            pforfait.setStrings("Petit déjeuner", "Demi Pension", "Pension Complete", "All-in");
            pforfait.setSelectedString("All-in");
        TextField tfidVol = new TextField("","idVol");
        //DatePicker dpDateArr = new DatePicker();
        //DatePicker dpDateDep = new DatePicker();
        
        Button btnValider = new Button("Réserver");
        
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if((tfnbPersonne.getText().length()==0)){
                    Dialog.show("Alert","Veuillez Remplir tout les champs correctement",new Command("OK"));
                }else{
                    try {
                        int nbPersonne = Integer.parseInt(tfnbPersonne.getText());
                        int nbChambre = Integer.parseInt(tfnbChambre.getText());
                        int nbSuite = Integer.parseInt(tfnbSuite.getText());
                        
                        Reclamation r = new Reclamation(pforfait.getSelectedString(),11,nbPersonne,nbChambre,nbSuite,
                                pdateArr.getDate(),pdateDep.getDate());
                        //System.out.println(r.getForfait());
                        //System.out.println("before");
                        //Reservation addedReservation = ReservationService.getInstance().addReservation(r);
                        if(new ReservationService().addReservation(r)){
                            Dialog.show("Succes",r.toString(),new Command("OK"));
                        }else{
                            Dialog.show("ERREUR","Erreur Lors d'ajout du réservation",new Command("OK"));
                        }
                        System.out.println(r.toString());
                    }catch (NumberFormatException e){
                        Dialog.show("ERROR","Doit être un numéro", new Command("OK)"));
                    } catch (ParseException ex) {
                        //Logger.getLogger(AddReservationForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        addAll(tfidVol,pforfait,tfnbPersonne,tfnbChambre,tfnbSuite,pdateArr,pdateDep,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
        //new AddPaiementForm().show();
        //AddPaiementForm().setRes();
*/
    }
    
}
