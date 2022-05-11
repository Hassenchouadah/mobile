/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.table.DefaultTableModel;
import com.codename1.ui.table.Table;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.table.TableModel;
import com.mycompany.entities.Reclamation;
import com.mycompany.services.ServiceReclamation;
import java.util.ArrayList;

/**
 *
 * @author Houssem
 */
public class ListReclamation extends Form {

    public ListReclamation(Form previous) {
        setTitle("Liste Des Reclamation");
        /*
        ArrayList<Reservation> list = ReservationService.getInstance().getAllReservations(99);
        Form hi = new Form("Table Layout 2x2", new TableLayout(80, 1));
        int l = list.size();
        for(int i=0;i<l;i++){
        hi.add(new Label(list.get(i).toString()));
        }
        //hi.show();
        addAll(hi);*/
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
    }
    
}
