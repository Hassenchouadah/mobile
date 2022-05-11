/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.entities.Reclamation;
import com.mycompany.services.ServiceReclamation;


/**
 *
 * @author LENOVO
 */
public class AddRecForm extends Form {
    public AddRecForm(Form previous) {
        
    setTitle("Add Reclamation");
    setLayout(BoxLayout.y());
    
    TextField tfDescAvis = new TextField("","Description");
    Button btnValider = new Button ("Add Reclamation");
    
     btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if((tfDescAvis.getText().length()==0)){
                    Dialog.show("Alert","Veuillez Remplir tout les champs correctement",new Command("OK"));
                }else{
                        Reclamation r = new Reclamation(tfDescAvis.getText());
                        ServiceReclamation.getInstance().ajouterReclamation(r);
                    }}
                });
    
     
        
        addAll(tfDescAvis,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
        //new AddPaiementForm().show();
        //AddPaiementForm().setRes();
        
    }

}
