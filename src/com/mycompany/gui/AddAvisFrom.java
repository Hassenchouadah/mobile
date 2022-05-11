
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
import com.mycompany.entities.Avis;
import com.mycompany.entities.Reclamation;
import com.mycompany.services.ServiceAvis;
import com.mycompany.services.ServiceReclamation;


/**
 *
 * @author LENOVO
 */
public class AddAvisFrom extends Form {
    public AddAvisFrom(Form previous) {
        
    setTitle("Add Avis");
    setLayout(BoxLayout.y());
    
    TextField tfDescAvis = new TextField("","Description");
    Button btnValider = new Button ("Ajouter ");
    
     btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if((tfDescAvis.getText().length()==0)){
                    Dialog.show("Alert","Veuillez Remplir tout les champs correctement",new Command("OK"));
                }else{
                       // Avis r = new Avis(tfDescAvis.getText());
                        ServiceAvis.getInstance().ajouterAvis(tfDescAvis.getText());
                    }}
                });
    
     
        
        addAll(tfDescAvis,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
        //new AddPaiementForm().show();
        //AddPaiementForm().setRes();
        
    }

}

    

