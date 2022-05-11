/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.services;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;

import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.Reclamation;
import com.mycompany.utils.Statics;
//import com.mycompany.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LENOVO
 */
public class ServiceReclamation {
    public ArrayList<Reclamation> reclamations;
    
    //singleton
    public static ServiceReclamation instance = null;
    
    //initiallisation
    private ConnectionRequest req;
    public static ServiceReclamation getInstance(){
        if(instance==null)
            instance=new ServiceReclamation();
        return instance;


    }
    public ServiceReclamation(){
        req=new ConnectionRequest();
        
    }
    
    //ajout
    public void ajouterReclamation(Reclamation reclamation){
        String url=Statics.BASE_URL+"/addrec/new?desc_rec="+reclamation.getDescrec();
        
        req.setUrl(url);
        req.addResponseListener((e)-> {
        String str=new String (req.getResponseData());
        System.out.println("data=="+str);
            });
            NetworkManager.getInstance().addToQueueAndWait(req);//execution mtaie request sinon yitada chay dima nalkawha 
    
    }
    //modifier
      public void EditReclamation(Reclamation reclamation) {
        String url = Statics.BASE_URL + "/modifrec/new?desc_rec="+reclamation.getDescrec()+"&idrec="+reclamation.getIdRec();
        System.out.println(url);
        req.setUrl(url);
        req.addResponseListener((e) -> {

            String str = new String(req.getResponseData());
            //reponse json hedhi elli rynaha fil naviguateur 

            System.out.println("data == " + str);
        });

        NetworkManager.getInstance().addToQueueAndWait(req);//execution mtaie request sinon yitada chay dima nalkawha 

    }
    
    //affichage
      /*
    public ArrayList<Reclamation>affichageReclamation(){
        ArrayList<Reclamation> result = new ArrayList<>();
       String url =Statics.BASE_URL+"/listeRec";
        req.setUrl(url);
        req.addResponseCodeListener(new ActionListener<NetworkEvent>() {
            @Override
          
     
        
        public void actionPerformed(NetworkEvent evt){
            JSONParser jsonp;
            jsonp = new JSONParser();
            try{
                Map<String,Object>mapReclamations = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
            List<Map<String,Object>>listOfMaps =(List<Map<String,Object>>) mapReclamations.get("root");
            for (Map<String,Object> obj : listOfMaps){
                Reclamation re = new Reclamation();
                float id = Float.parseFloat(obj.get("idRec").toString()); 
                String descrec =obj.get("descRec").toString();
                
                re.setIdRec((int)id);
                re.setDescrec(descrec);
                
               String DateConverter= obj.get("dateajoutrec").toString().substring(obj.get("dateajoutrec").toString().indexOf("timestamp")+10,obj.get("obj").toString().lastIndexOf("}"));
                
                //Date currentTime =new Date(Double.valueOf(DateConverter).longValue()*1000);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                //String dateString =formatter.format(currentTime);
                re.setDateajoutrec(dateString);
                
                result.add(re);                
            }
            
            
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
            }
        });
                    NetworkManager.getInstance().addToQueueAndWait(req);
return result;
                
    }

      
      */
      //affich

      public ArrayList<Reclamation> parseReclamation(String jsonText) {
        System.out.println(jsonText);
        try {
            reclamations= new ArrayList<>();
            JSONParser j = new JSONParser();
            //System.out.println("111");
            //System.out.println(new CharArrayReader(jsonText.toCharArray()));
            //System.out.println("222");
            Map<String,Object> ProduitListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            //System.out.println(ProduitListJson);
            //System.out.println("aaa");
            List< Map<String,Object>> list =(List< Map<String,Object>>) ProduitListJson.get("root");
            System.out.println(list);
            for ( Map<String,Object> obj: list){
            Reclamation r = new Reclamation();
                ///System.out.println(obj.get("idRec"));
            int idRec = ((int)(Float.parseFloat(obj.get("idRec").toString())));
                //System.out.println((int) idRes);
            r.setIdRec(idRec);
            r.setDescrec(obj.get("descRec").toString());
            r.setTraite((int)(Float.parseFloat(obj.get("traite").toString())));
            r.setDateajoutrec(obj.get("dateajoutrec").toString());
            //r.setDateee(obj.get("datetraitrec").toString());
            reclamations.add(r);
              //System.out.println(reservations);
            }
        }
            catch (IOException ex) {
               System.out.println(ex);
        }
          return reclamations;
 }
     
         public ArrayList<Reclamation> getReclamation(){
          String url = Statics.BASE_URL+"/listeRec";
            req.setUrl(url);
            req.setPost(false);
            req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                reclamations = parseReclamation(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
             //System.out.println(reservations);
        return reclamations;
    }
  
        
        
        
        /////
    
      public boolean resultOK;

        public boolean deleteReclamation(int id) {
        String url = Statics.BASE_URL + "/supprec/" + id;
            System.out.println(url);
               req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
   
    
}

