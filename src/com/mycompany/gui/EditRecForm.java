/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
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
public class EditRecForm extends Form {
    public EditRecForm(Form previous) {
        
    setTitle("Edit Reclamation");
    setLayout(BoxLayout.y());
    
    TextField tfDescAvis = new TextField("","Description");
    Button btnValider = new Button ("Edit Reclamation");
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
        
     btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if((tfDescAvis.getText().length()==0)){
                    Dialog.show("Alert","Veuillez Remplir tout les champs correctement",new Command("OK"));
                }else{
                    Reclamation nr = new Reclamation();
                    String idrec = reclamationVal.getSelectedString();
                    idrec = idrec.substring(1, idrec.indexOf("\"",2) );
                    nr.setIdRec(Integer.parseInt(idrec));
                    nr.setDescrec(tfDescAvis.getText());
                    ServiceReclamation.getInstance().EditReclamation(nr);
                    }}
                });
     
        
        addAll(reclamationVal,tfDescAvis,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
        //new AddPaiementForm().show();
        //AddPaiementForm().setRes();
        
    }

}
