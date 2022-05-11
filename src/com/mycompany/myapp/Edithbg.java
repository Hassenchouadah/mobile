/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp;

import Services.hebergmentService;
import com.codename1.components.InfiniteProgress;
import com.codename1.ext.filechooser.FileChooser;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.CN;
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
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author User
 */
public class Edithbg extends Inbox1Form {

    String fileNameInServer;
    String ipath;
    String filePath = "";

    /*protected String saveFileToDevice(String hi, String ext) throws IOException {
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

    public Edithbg(Resources res, Hebergement r) {
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Edit hebergement", "Title")
                )
        );
        setLayout(BoxLayout.y());

        setLayout(BoxLayout.y());

        TextField tnom=new TextField(r.getNom(), "Nom" , 20 , TextField.ANY);
        TextField tcity=new TextField(r.getCity(), "city" , 20 , TextField.ANY);
        ////Date aujourdhui = new Date();
        //Picker datePicker = new Picker();
        //datePicker.setType(Display.PICKER_TYPE_DATE);
        TextField tadress=new TextField(r.getAdress(), "adress", 20 , TextField.ANY);
        TextField tnom_hotel=new TextField(r.getNom_hotel(), "nom_hotel", 20 , TextField.ANY);
        TextField tnb_chambres=new TextField(String.valueOf(r.getNb_chambres()), "nb_chambres", 20 , TextField.ANY);
        TextField tnb_suites=new TextField(String.valueOf(r.getNb_suites()), "nb_suites", 20 , TextField.ANY);
        TextField tpiscine=new TextField(String.valueOf(r.getPiscine()), "piscine", 20 , TextField.ANY);
        TextField tprix=new TextField(String.valueOf(r.getPrix()), "prix", 20 , TextField.ANY);  
    
        Button btnValider = new Button("Edit");
        btnValider.setUIID("InboxNumber3");
        Button btnAnnuler = new Button("Annuler");
       btnAnnuler.addActionListener(e -> {
           new Showhbg(res).show();
       });
       addAll(tnom,tcity,tadress,tnom_hotel,tnb_chambres,tnb_suites,tpiscine,tprix,btnValider);


       
            
                    
                       
                                  btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tnom.getText().length()==0)||(tcity.getText().length()==0)||(tadress.getText().length()==0)||(tnom_hotel.getText().length()==0)||(tnb_chambres.getText().length()==0)||(tnb_suites.getText().length()==0)||(tpiscine.getText().length()==0)||(tprix.getText().length()==0))
                Dialog.show("Please fill all the fields", "", "Cancel", "OK");
                else{ 
                    try {
                                            InfiniteProgress ip = new InfiniteProgress();
                                            final Dialog iDialog = ip.showInfiniteBlocking();

                                            r.setNom(tnom.getText());
           r.setCity(tcity.getText());
           r.setAdress(tadress.getText());
           r.setNom_hotel(tnom_hotel.getText());
           r.setNb_chambres(Integer.parseInt(tnb_chambres.getText()));
           r.setNb_suites(Integer.parseInt(tnb_suites.getText()));
           r.setPiscine(Integer.parseInt(tpiscine.getText()));
           r.setPrix(Integer.parseInt(tprix.getText()));
           

                                            hebergmentService.getInstance().edithbg(r);

                                            iDialog.dispose();
                                            //new Showhbg(res).show();
                                            refreshTheme();
                                        }
                                     catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                
                                revalidate();
                            
                        }
                    }
                });
            }
        



    }

