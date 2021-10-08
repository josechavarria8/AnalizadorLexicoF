
package Analizador;

import Tokens.tipoTokens;
import Tokens.errorLexico;
import Tokens.token;
import java.util.ArrayList;

public class analizador {
    
    private ArrayList<token> listaTokens = new ArrayList<token>();
    private ArrayList<errorLexico> listaErrores = new ArrayList<errorLexico>();
  

    public void Analizar(String texto) {

        listaTokens.clear();
        listaErrores.clear();      
        String cadena = "";
        int state = 0;
        
        for (int i = 0; i < texto.length(); i++) {

            if ((texto.charAt(i) != ' ') && (texto.charAt(i) != '\n')) {
                
                state = automata.nuevoEstado(texto.charAt(i), state);
                cadena += texto.charAt(i);
               

                if (state == -1) {
                    System.out.println(cadena + " -> Error lexico");
                    errorLexico erl = new errorLexico(cadena, 0, 0);
                    listaErrores.add(erl);
                    state = 0;
                    cadena = "";
                } else if (state == -5) {
                    System.out.println(cadena + " -> Error: No se reconoce el simbolo (" + texto.charAt(i) + ")");
                    listaErrores.add(new errorLexico(cadena, 0, 0));
                    state = 0;
                    cadena = "";
                }

            } else {

                if (!cadena.isEmpty()) {

                    for (tipoTokens tk : tipoTokens.values()) {
                        if (tk.getEstadoAcept() == state) {
                            token nuevoToken = new token(cadena, tk, 0, 0);
                            listaTokens.add(nuevoToken);

                          

                            state = 0;
                            cadena = "";
                        }
                    }

                }
            }
        }

    }
        
    
    public ArrayList<token> getListaTokens() {
        return listaTokens;
    }

    public void setListaTokens(ArrayList<token> listaTokens) {
        this.listaTokens = listaTokens;
    }

    public ArrayList<errorLexico> getListaErrores() {
        return listaErrores;
    }

    public void setListaErrores(ArrayList<errorLexico> listaErrores) {
        this.listaErrores = listaErrores;
    }

}
