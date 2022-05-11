/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import Services.hebergmentService;
import com.codename1.components.InfiniteProgress;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entity.Hebergement;

/**
 *
 * @author User
 */
public class Addhbg extends Inbox1Form {

    String fileNameInServer;
    String ipath;
    String filePath = "";

   /* protected String saveFileToDevice(String hi, String ext) throws IOException {
        URI uri;
        try {
            uri = new URI(hi);
            String path = uri.getPath();
            int index = hi.lastIndexOf("/");
            hi = hi.substring(index + 1);
            return hi;
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        }
        return "error";
    }*/

    public Addhbg(Resources res) {
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Add hebegergement", "Title")
                )
        );
        setLayout(BoxLayout.y());

        setLayout(BoxLayout.y());

         TextField tnom=new TextField("", "nom");
        TextField tcity=new TextField("", "city");
        ////Date aujourdhui = new Date();
        //Picker datePicker = new Picker();
        //datePicker.setType(Display.PICKER_TYPE_DATE);
        TextField tadress=new TextField("", "adress");
        TextField tnom_hotel=new TextField("", "nom_hotel");
        TextField tnb_chambres=new TextField("", "nb_chambres");
        TextField tnb_suites=new TextField("", "nb_suites");
        TextField tpiscine=new TextField("", "piscine");
        TextField tprix=new TextField("", "prix");

        Button btnValider = new Button("Add");
        btnValider.setUIID("InboxNumber3");

       // Button img1 = new Button("select an image");
        CheckBox multiSelect = new CheckBox("multi");
        
                   
                    
                               
                               
                                
                                btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tnom.getText().length()==0)||(tcity.getText().length()==0)||(tadress.getText().length()==0)||(tnom_hotel.getText().length()==0)||(tnb_chambres.getText().length()==0)||(tnb_suites.getText().length()==0)||(tpiscine.getText().length()==0)||(tprix.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                                            InfiniteProgress ip = new InfiniteProgress();
                                            final Dialog iDialog = ip.showInfiniteBlocking();
                                            Hebergement t  = new Hebergement (tnom.getText(),tcity.getText(),tadress.getText(),tnom_hotel.getText(),Integer.parseInt(tnb_chambres.getText()),Integer.parseInt(tnb_suites.getText()),Integer.parseInt(tpiscine.getText()),Integer.parseInt(tprix.getText()));


                                            if( hebergmentService.getInstance().addhbg(t))
                        {
                           Dialog.show("Success","Connection accepted",new Command("OK"));
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                                            refreshTheme();
                                        
            
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                
                            revalidate();
                        }
                    }
                });
                                addAll(tnom,tcity,tadress,tnom_hotel,tnb_chambres,tnb_suites,tpiscine,tprix,btnValider);

                                
                                
            
    }
        


    }

   

