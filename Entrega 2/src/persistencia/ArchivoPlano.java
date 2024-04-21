package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import galeria.*;


public class ArchivoPlano {
	public static void almacenar(String archivo, ArrayList<Compra> Compras) {
			
			try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
				oos.writeObject(Compras);
				oos.close();	
	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	public static ArrayList<Compra> recuperar(String archivo) {
	    ArrayList<Compra> compras = new ArrayList<>();
	
	    try {
	        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
	        compras = (ArrayList<Compra>) ois.readObject();
	        ois.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return compras;
	}

}
	
	
	

