package rmiserver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmii.RMII;

/**
 *
 * @author Hubert
 */
public class RMIServer extends UnicastRemoteObject implements RMII {

    List<Roleta> lista = new ArrayList<Roleta>();
    Liczenie wylicz;
    double[] tab;

    public RMIServer() throws RemoteException {
        super();
    }


    public double[] zapisDanych(int ilosc, String text, String text1) throws RemoteException {

        Scanner odczyt = new Scanner(System.in);

        tab = new double[ilosc];

        for (int i = 0; i < ilosc; i++) {

            lista.add(i, new Roleta(Double.parseDouble(text), Double.parseDouble(text1), "Jasny Brąz"));
            tab[i] = lista.get(i).getWidth();

        }

        return tab;
    }

    public String obliczenia(double tab[]) {
        wylicz = new Liczenie(tab.length, 600, tab);
   
        String text = "";
        try {
            text = wylicz.looper(600, 0);
        } catch (FileNotFoundException ex) {
            return "Obliczenia nie zostały wykonane";
        }
        return text;

    }

    public static void main(String args[]) {
        try {
            Registry reg = LocateRegistry.createRegistry(5099);
            reg.rebind("server", new RMIServer());
            System.out.println("Server started");

        } catch (Exception e) {
            System.out.println(e);

        }
    }

}
