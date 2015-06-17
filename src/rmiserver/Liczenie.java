/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author A
 */
public class Liczenie {

    public double[] tab;
    public double ilosc;
    public int poj;
    public double[] tmp;
    public static final String PROP_ILOSC = "ilosc";
    public static final String PROP_POJ = "poj";
    PrintWriter zapis;

    public Liczenie(int ilosc, int pojemnosc, double[] tab) {

        this.tab = tab;
        this.ilosc = ilosc;
        poj = pojemnosc;
        tmp = new double[ilosc];
        for (int i = 0; i < tab.length; i++) {
            tmp[i] = tab[i];
        }
    }

    public int getPoj() {
        return poj;
    }

    public void setPoj(int poj) {
        int oldPoj = this.poj;
        this.poj = poj;
        propertyChangeSupport.firePropertyChange(PROP_POJ, oldPoj, poj);
    }

    public double getIlosc() {
        return ilosc;
    }

    public void setIlosc(double ilosc) {
        double oldIlosc = this.ilosc;
        this.ilosc = ilosc;
        propertyChangeSupport.firePropertyChange(PROP_ILOSC, oldIlosc, ilosc);
    }
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    double suma = 0;

    public String wariant2(double waga, int pocz) {

       
        String temp = "";
        for (int i = pocz; i < tab.length; i++) {       
            if (tab[i] < waga && tab[i] < waga - 40 && tab[i] > waga - 150 && tab[i] < waga - 100) {
                temp = "";
                tmp[i] = 0;
                
                return String.valueOf(tab[i]);
                
            } else if (waga > tab[i]) {

                temp = wariant2(waga - tab[i], i + 1);
                if (!temp.contains("Brak rozwiazań!")) {
                    tmp[i] = 0;
                    return String.valueOf(tab[i]) + " " + temp;
                }
            }

        }
        return "Brak rozwiazań!";

    }
    double suma1 = 0;

    public String wariant1(double waga, int pocz) {

        List lista = new ArrayList();

        suma++;
        double[] tab1 = null;

        String temp = "";

        for (int i = pocz; i < tab.length; i++) {

            if (tab[i] <= waga && tab[i] >= waga - 40) {
                temp = "";
                tmp[i] = 0;
                return String.valueOf(tab[i]);
                
            } else if (waga > tab[i]) {

                temp = wariant1(waga - tab[i], i + 1);

                if (!temp.contains("Brak rozwiazań!")) {
                    tmp[i] = 0;
                    return String.valueOf(tab[i]) + " " + temp;
                }
            }
        }
        return "Brak rozwiazań!";
    }

    public void przepisz() {
        for (int i = 0; i < tmp.length; i++) {
            tab[i] = tmp[i];
        }
    }

    public double sumuj() {
        double suma = 0;
        for (int i = 0; i < tab.length; i++) {
            suma += tab[i];
        }
        return suma;
    }

    public String looper(int waga, int pocz) throws FileNotFoundException {

        zapis = new PrintWriter("wyniki.txt");
        int licz = 1;
        this.przepisz();
        String text = "";
        while (sumuj() > 560) {
            System.out.println("Wariant optymalny");
            System.out.println(this.wariant1(waga, pocz).replace(" 0.0", " "));
            
            zapis.println("Wariant optymalny: \n"+this.wariant1(waga, pocz).replace(" 0.0", " "));
            text = text + "\nWariant optymalny: \n"+this.wariant1(waga, pocz).replace(" 0.0", " ");
            if (this.wariant1(waga, pocz).contains("Brak rozwiazań!")) {
                System.out.println("Wariant opcjonalny" + licz);
                System.out.println(this.wariant2(waga, pocz).replace(" 0.0", " "));
                zapis.println("Wariant opcjonalny: \n"+this.wariant2(waga, pocz).replace(" 0.0", " "));
                text = text + "Wariant opcjonalny: \n"+this.wariant2(waga, pocz).replace(" 0.0", " ");
                this.przepisz();
                break;               
            }
            this.przepisz();
        }
        if (sumuj() >= 450 && sumuj()<=500) {
                System.out.println("Wariant opcjonalny: ");
                System.out.println(this.wariant2(waga, pocz).replace(" 0.0", " "));
                zapis.println("Wariant opcjonalny: \n"+this.wariant2(waga, pocz).replace(" 0.0", " "));
                text = text + "Wariant opcjonalny: \n"+this.wariant2(waga, pocz).replace(" 0.0", " ");
                this.przepisz();
                               
            }
        if (sumuj() < 450 && sumuj()!=0) {
            System.out.println("Wariant ostateczny:");
            zapis.print("Wariant ostateczny: ");
            text = text + "\nWariant ostateczny: ";
            for (int i = 0; i < tab.length; i++) {

                if (tab[i] != 0.0)
                System.out.print(tab[i] + " ");
                if (tab[i] != 0.0){
                zapis.print(tab[i] + " ");
                text = text+tab[i]+" ";}

            }
            this.przepisz();
        } else if (sumuj() > 450) {
            System.out.println("Wariant nieoptymalny:");
            zapis.print("Wariant nieoptymalny: ");
            text = text + "\nWariant nieoptymalny: ";
            for (int i = 0; i < tab.length; i++) {

                if (tab[i] != 0.0)
                System.out.print(tab[i] + " ");
                if (tab[i] != 0.0)
                zapis.println(tab[i] + " ");
                text = text+tab[i]+" ";
                
            }
            this.przepisz();
        }
        zapis.close();
        return text;
    }
}
