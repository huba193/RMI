/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author A
 */
public class Roleta {
     
    private double height;
    public static final String PROP_HEIGHT = "height";
    private double width;
    public static final String PROP_WIDTH = "width";
    private String kolor;
    public static final String PROP_KOLOR = "kolor";
    private double profileWidth;
    public static final String PROP_PROFILEWIDTH = "profileWidth";
    private int profil;
    public static final String PROP_PROFIL = "profil";
    private double box;
    public static final String PROP_BOX = "box";
    private double cenaProfilu;
    public static final String PROP_CENAPROFILU = "cenaProfilu";
    private double cenaSkrzynki;
    public static final String PROP_CENASKRZYNKI = "cenaSkrzynki";
    private double tube;
    public static final String PROP_TUBE = "tube";
    private double listwaDolna;
    public static final String PROP_LISTWADOLNA = "listwaDolna";
    private double prowadnice;
    public static final String PROP_PROWADNICE = "prowadnice";
    private double boxType;
    public static final String PROP_BOXTYPE = "boxType";

   
    public double getBoxType() {
        return boxType;
    }


    public void setBoxType(double boxType) {
        double oldBoxType = this.boxType;
        this.boxType = boxType;
        propertyChangeSupport.firePropertyChange(PROP_BOXTYPE, oldBoxType, boxType);
    }

    
    public double getProwadnice() {
        return prowadnice;
    }

  
    public void setProwadnice(double prowadnice) {
        double oldProwadnice = this.prowadnice;
        this.prowadnice = prowadnice;
        propertyChangeSupport.firePropertyChange(PROP_PROWADNICE, oldProwadnice, prowadnice);
    }


    public double getListwaDolna() {
        return listwaDolna;
    }

    public void setListwaDolna(double listwaDolna) {
        double oldListwaDolna = this.listwaDolna;
        this.listwaDolna = listwaDolna;
        propertyChangeSupport.firePropertyChange(PROP_LISTWADOLNA, oldListwaDolna, listwaDolna);
    }


    public double getTube() {
        return tube;
    }

    public void setTube(double tube) {
        double oldTube = this.tube;
        this.tube = tube;
        propertyChangeSupport.firePropertyChange(PROP_TUBE, oldTube, tube);
    }

    private double cenaSumaryczna;
    public static final String PROP_CENASUMARYCZNA = "cenaSumaryczna";


    public double getCenaSumaryczna() {
        return cenaSumaryczna;
    }


    public void setCenaSumaryczna(double cenaSumaryczna) {
        double oldCenaSumaryczna = this.cenaSumaryczna;
        this.cenaSumaryczna = cenaSumaryczna;
        propertyChangeSupport.firePropertyChange(PROP_CENASUMARYCZNA, oldCenaSumaryczna, cenaSumaryczna);
    }


    public double getCenaSkrzynki() {
        return cenaSkrzynki;
    }


    public void setCenaSkrzynki(double cenaSkrzynki) {
        double oldCenaSkrzynki = this.cenaSkrzynki;
        this.cenaSkrzynki = cenaSkrzynki;
        propertyChangeSupport.firePropertyChange(PROP_CENASKRZYNKI, oldCenaSkrzynki, cenaSkrzynki);
    }

    public double getCenaProfilu() {
        return cenaProfilu;
    }


    public void setCenaProfilu(double cenaProfilu) {
        double oldCenaProfilu = this.cenaProfilu;
        this.cenaProfilu = cenaProfilu;
        propertyChangeSupport.firePropertyChange(PROP_CENAPROFILU, oldCenaProfilu, cenaProfilu);
    }


    public double getBox() {
        return box;
    }

    public void setBox(double box) {
        double oldBox = this.box;
        this.box = box;
        propertyChangeSupport.firePropertyChange(PROP_BOX, oldBox, box);
    }

    public int getProfil() {
        return profil;
    }

    public void setProfil(int profil) {
        int oldProfil = this.profil;
        this.profil = profil;
        propertyChangeSupport.firePropertyChange(PROP_PROFIL, oldProfil, profil);
    }

    


    public double getProfileWidth() {
        return profileWidth;
    }

   public Roleta(double width, double height, String kolor)
    {
       
        this.kolor = kolor;
        this.width = width;
        this.height = height;
        this.profileWidth = this.width-7;
        this.profil = (int) ((int) this.height/3.9);
        this.box = this.width - 1;
        this.tube = this.width - 5.5;
        this.listwaDolna = this.width - 7;
        if (this.getHeight() > 179 && this.getHeight() < 220){
            this.setBoxType(16.5); 
        } else if (this.getHeight() <= 179 && this.getHeight() > 100)
            this.setBoxType(13.7);
        else if (this.getHeight() <= 100 )
            this.setBoxType(12.5);
        else if (this.getHeight() >= 220 && this.getHeight() < 250)
            this.setBoxType(18.0);
        else if (this.getHeight() >= 250 && this.getHeight() < 320)
            this.setBoxType(20.5);
        else System.out.println("Za duza roleta");
            
        this.setProwadnice(this.getHeight() - this.getBoxType());
        //System.out.println(wycena());
       
    }
    public void setProfileWidth(double profileWidth) {
        double oldProfileWidth = this.profileWidth;
        
        this.profileWidth = profileWidth;
        propertyChangeSupport.firePropertyChange(PROP_PROFILEWIDTH, oldProfileWidth, profileWidth);
    }

    

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        double oldHeight = this.height;
        this.height = height;
        propertyChangeSupport.firePropertyChange(PROP_HEIGHT, oldHeight, height);
    }

      

    
    public double getWidth() {
        return width;
    }

    
    public void setWidth(double width) {
        double oldWidth = this.width;
        this.width = width;
        propertyChangeSupport.firePropertyChange(PROP_WIDTH, oldWidth, width);
    }

   
    public Roleta()
    {
        
    }
    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        String oldKolor = this.kolor;
        this.kolor = kolor;
        propertyChangeSupport.firePropertyChange(PROP_KOLOR, oldKolor, kolor);
    }


    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    public double wycena()
    {
        double cnst = 35;
        double cenaWieszakow;
        double cenaRury;
        double cenaListwy;
        double cenaProwadnic;
        if (this.getKolor()!="Złoty dąb" && this.getKolor()!="Orzech"){
            this.setCenaProfilu(this.getProfil()*this.getProfileWidth()*0.022);
            this.setCenaSkrzynki(this.getWidth()*0.3);
        }
        else{
            this.setCenaProfilu(this.getProfil()*this.getProfileWidth()*0.025);
            this.setCenaSkrzynki(this.getWidth()*0.36);
        }
         
        if (this.getWidth() < 180)
            cenaWieszakow = 3;
        else
        cenaWieszakow = 5;
       if (this.getKolor()!="Złoty dąb" && this.getKolor()!="Orzech")
           cenaProwadnic = (this.getProwadnice()*0.14)*2;
       else
           cenaProwadnic = (this.getProwadnice()*0.168)*2;
        cenaRury = this.getTube()*0.3;
        cenaListwy = this.getListwaDolna()*0.11;
        
        this.setCenaSumaryczna(cenaProwadnic+cenaWieszakow+cenaRury+cenaListwy+cnst+this.getCenaProfilu()+this.getCenaSkrzynki());
        
        
        return this.getCenaSumaryczna();
    }
   
 
}
