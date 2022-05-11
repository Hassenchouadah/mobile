/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utils.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entity.Hebergement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class hebergmentService {

    private boolean resultat;
    public static hebergmentService instance = null;
    public ArrayList<Hebergement> hbgs;
    private MultipartRequest req;

    public static hebergmentService getInstance() {
        if (instance == null) {
            instance = new hebergmentService();
        }
        return instance;
    }

    public hebergmentService() {
        req = new MultipartRequest();
    }

    public boolean addhbg(Hebergement t) {
           String url=Statics.BASE_URL+"/addhbgM?id="+t.getId_hbg()+"&nom="+t.getNom()+"&city="+t.getCity()+"&adress="+t.getAdress()+"&nomhotel="+t.getNom_hotel()+"&nbchambres="+t.getNb_chambres()+"&nbsuites="+t.getNb_suites()+"&piscine="+t.getPiscine()+"&prix="+t.getPrix();

        req.setPost(true);

        req.setUrl(url);
        req.setFailSilently(true);
        System.out.println(url);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println("action performed");

                resultat = req.getResponseCode() == 200;

                req.removeResponseListener(this);

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultat;

    }

    public ArrayList<Hebergement> parse(String jsonTxt) {
        try {
            hbgs = new ArrayList<>();

            JSONParser parser = new JSONParser();

            System.out.println(jsonTxt);
            System.out.println("******************");
            Map<String, Object> EvenementsJSON;
            EvenementsJSON = parser.parseJSON(new CharArrayReader(jsonTxt.toCharArray()));
            List<Map<String, Object>> listeRec;
            listeRec = (List<Map<String, Object>>) EvenementsJSON.get("root");

            for (Map<String, Object> obj : listeRec) {

                Hebergement t = new Hebergement();

                float id = Float.parseFloat(obj.get("id").toString());

                 t.setNom((obj.get("nom").toString()));
                t.setCity((obj.get("city").toString()));
                t.setAdress((obj.get("adress").toString()));
                t.setNom_hotel((obj.get("nomHotel").toString()));
                float nbch = Float.parseFloat(obj.get("nbChambres").toString());
                float nbsu = Float.parseFloat(obj.get("nbSuites").toString());
                float pi = Float.parseFloat(obj.get("piscine").toString());
                float p = Float.parseFloat(obj.get("prix").toString());
                t.setNb_chambres((int)nbch);
                t.setNb_suites((int)nbsu);
                t.setPiscine((int)pi);
                t.setPrix((int)p);

                hbgs.add(t);
            }
        } catch (IOException | NumberFormatException ex) {
            ex.printStackTrace();
            System.out.println("aaa");
        }
        return hbgs;

    }

    public ArrayList<Hebergement> showhbgs() {
        req = new MultipartRequest();
        ArrayList<Hebergement> result = new ArrayList<>();
        String url = Statics.BASE_URL + "/Allhbgs";
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    hbgs = parse(new String(req.getResponseData(), "utf-8"));
                    req.removeResponseListener(this);
                } catch (Exception ex) {

                }
            }

        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return hbgs;
    }

    public boolean edithbg(Hebergement t) {
               String url=Statics.BASE_URL+"updatehbg?id="+t.getId_hbg()+"&nom="+t.getNom()+"&city="+t.getCity()+"&adress="+t.getAdress()+"&nomhotel="+t.getNom_hotel()+"&nbchambres="+t.getNb_chambres()+"&nbsuites="+t.getNb_suites()+"&piscine="+t.getPiscine()+"&prix="+t.getPrix();

        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultat = req.getResponseCode() == 200;
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultat;
    }

    public boolean deletehbg(int id) {
        String url = Statics.BASE_URL + "deletehbg?id=" + id;

        req.setUrl(url);
        req.setPost(false);
        req.setFailSilently(true);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultat = req.getResponseCode() == 200;
                req.removeResponseListener(this);
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultat;

    }
}
