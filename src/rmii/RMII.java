package rmii;

import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hubert
 */
public interface RMII extends Remote{
    
    public String getData(String text) throws RemoteException;
    public double[] zapisDanych(int ilosc, String text, String text1) throws RemoteException;
    public String obliczenia(double tab[]) throws RemoteException;
}
