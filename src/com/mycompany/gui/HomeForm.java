/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author Mohamed
 */
public class HomeForm extends Form{
Form current;
    public HomeForm(){
        current=this;
        setTitle("Home");
        setLayout(BoxLayout.y());
        
        add(new Label("Choisir"));
        Button btnAjout = new Button("Ajouter une réclamation");
        Button btnAff = new Button("Afficher les réclamation");
        Button btnEdit = new Button("Modifier Une Réclamation");
        Button btnCancel = new Button("Annuler Une Réclamation");
        
         Button btnAjoutAvis = new Button("Ajouter une Avis");
                
        btnAjout.addActionListener(e->new AddRecForm(current).show());
        btnAff.addActionListener(e->new AffRecForm(current).show());
        btnEdit.addActionListener(e->new EditRecForm(current).show());
        btnCancel.addActionListener(e->new DeleteReclamation(current).show());
        
        btnAjoutAvis.addActionListener(e->new AddAvisFrom(current).show());

        addAll(btnAff,btnAjout,btnEdit,btnCancel,btnAjoutAvis);
    }
    
}
