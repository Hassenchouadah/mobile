package com.mycompany.myapp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Services.hebergmentService;
import com.codename1.components.SpanLabel;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entity.Hebergement;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Showhbg extends Inbox1Form {

    Container c = new Container(BoxLayout.x());
    Container cxx = new Container(BoxLayout.xCenter());
    Resources res;

    public Showhbg(Resources res) {
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("hebergment List", "Title")
                )
        );
        setLayout(BoxLayout.y());

         SpanLabel sp = new SpanLabel();
        //sp.setText(ServiceCollaborateur.getInstance().getAllCollaborateurs().toString);
        
         ArrayList<Hebergement> list;
        list = new ArrayList<>();
        
        list = hebergmentService.getInstance().showhbgs();
         for ( Hebergement ev : list) {
              
             
             
              SpanLabel spl = new SpanLabel("nom: " + "  " + ev.getNom());
              SpanLabel sp2 = new SpanLabel("city: " + "  " + ev.getCity());
              SpanLabel sp3 = new SpanLabel("adress: " + "  " + ev.getAdress());
              SpanLabel sp4 = new SpanLabel("nom_hotel: " + "  " + ev.getNom_hotel());
                SpanLabel sp5 = new SpanLabel("nb_chambres: " + "  " + ev.getNb_chambres());
                SpanLabel sp6 = new SpanLabel("description: " + "  " + ev.getNb_suites());
                SpanLabel sp7 = new SpanLabel("lieuid: " + "  " + ev.getPiscine());
                SpanLabel sp8 = new SpanLabel("email: " + "  " + ev.getPrix());
       
             
 Label lSupprimer = new Label(" ");
        lSupprimer.setUIID("NewsTopLine");
        Style supprmierStyle = new Style(lSupprimer.getUnselectedStyle());
        supprmierStyle.setFgColor(0xf21f1f);
        
        FontImage suprrimerImage = FontImage.createMaterial(FontImage.MATERIAL_DELETE, supprmierStyle);
        lSupprimer.setIcon(suprrimerImage);
        lSupprimer.setTextPosition(RIGHT);
        
        //click delete icon
        lSupprimer.addPointerPressedListener(l -> {
            
            Dialog dig = new Dialog("Suppression");
            
            if(dig.show("Suppression","Vous voulez supprimer ce reclamation ?","Annuler","Oui")) {
                dig.dispose();
            }
            else {
                dig.dispose();
                 }
                //n3ayto l suuprimer men service Reclamation
                if(hebergmentService.getInstance().deletehbg(ev.getId_hbg())) {
                  
                    new Showhbg(res).show();
                }
           
        });
        
        
        //Update icon 
        Label lModifier = new Label(" ");
        lModifier.setUIID("NewsTopLine");
        Style modifierStyle = new Style(lModifier.getUnselectedStyle());
        modifierStyle.setFgColor(0xf7ad02);
        
        FontImage mFontImage = FontImage.createMaterial(FontImage.MATERIAL_MODE_EDIT, modifierStyle);
        lModifier.setIcon(mFontImage);
        lModifier.setTextPosition(LEFT);
        
        
        lModifier.addPointerPressedListener(l -> {
            //System.out.println("hello update");
            new Edithbg(res,ev).show();
        });
        
        
      
          addAll(spl,sp2,sp3,sp4,sp5,sp6,sp7,sp8,lSupprimer,lModifier);
        
    }


    }
}
