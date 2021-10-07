/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejadorArchivos;

import java.awt.*;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author CIROSS
 */
public class abrirArchivos {

    public static void abrirArchivo(Container container, JTextArea txArea) {
        
        JFileChooser fileChosser = new JFileChooser();
        int seleccion = fileChosser.showOpenDialog(container);
        
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            
            File archivo = fileChosser.getSelectedFile();
            FileReader fr;
            try {
                fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                txArea.setText("");
                while ((linea = br.readLine()) != null) {
                    txArea.append("\n" + linea);
                }
                fr.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }
}
