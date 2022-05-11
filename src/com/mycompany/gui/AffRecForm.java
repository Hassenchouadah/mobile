/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;


import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Reclamation;
import com.mycompany.services.ServiceReclamation;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class AffRecForm extends Form {
    
    public AffRecForm(Form previous) {
        setTitle("Liste Reclamation");
        ArrayList<Reclamation> list = ServiceReclamation.getInstance().getReclamation();
            Form hi = new Form("Liste des réclamations", new TableLayout(80, 1));
        int l = list.size();
        for(int i=0;i<l;i++){
        hi.add(new Label(list.get(i).toString()));
        }
        addAll(hi);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
    }

 }
