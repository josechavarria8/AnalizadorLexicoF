/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionalidad;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.*;

/**
 *
 * @author CIROSS
 */
public class Busqueda {

    public static void buscar(JTextArea jTextArea, String palabraBuscar) {

        DefaultHighlighter.DefaultHighlightPainter resaltador = new DefaultHighlighter.DefaultHighlightPainter(new Color(255, 155, 0));
        Highlighter resaltado = jTextArea.getHighlighter();
        resaltado.removeAllHighlights();

        String textoBusqueda = jTextArea.getText();
        int contador, indice;

        for (int i = 0; i < textoBusqueda.length()- palabraBuscar.length() + 1; i++) {

            contador = 0;
            indice = i;
            String cadena = "";
            int[] inicio = new int[palabraBuscar.length()];
            
            for (int j = 0; j < palabraBuscar.length(); j++) {

                if (textoBusqueda.charAt(indice) == palabraBuscar.charAt(j)) {
                    cadena = (cadena + textoBusqueda.charAt(indice));
                    inicio[j] = indice;

                    if (iguales(cadena, palabraBuscar)) {
                        try {
                            resaltado.addHighlight(inicio[0], inicio[palabraBuscar.length() - 1] + 1, resaltador);
                        } catch (BadLocationException ex) {
                            JOptionPane.showMessageDialog(null, "No se pudo resaltar la palabra");
                        }
                    }
                    contador++;
                }
                indice++;
            }
        }
    }

    public static boolean iguales(String cadena1, String cadena2) {
        
        if (cadena1.length() == cadena2.length()) {            
            for (int i = 0; i < cadena1.length(); i++) {                
                if (cadena1.charAt(i) != cadena2.charAt(i)) {                    
                    return false;
                }
            }
            return true;            
        } else {
            return false;
        }
        
    }
    
   
}
