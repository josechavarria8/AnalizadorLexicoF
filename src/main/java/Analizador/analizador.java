
package Analizador;

import Tokens.tipoTokens;
import Tokens.errorLexico;
import Tokens.token;
import java.util.ArrayList;

public class analizador {
    
    private ArrayList<token> listaTokens = new ArrayList<token>();
    private ArrayList<errorLexico> listaErrores = new ArrayList<errorLexico>();
    private static String transiciones;

    public void Analizar(String texto) {

        listaTokens.clear();
        listaErrores.clear();
        transiciones = ("\n  TRANSICIONES EN EL AUTOMATA:\n  ---------------------------\n\n");    
        String cadena = "";
        int estadoActual = 0;
        
        for (int i = 0; i < texto.length(); i++) {

            if ((texto.charAt(i) != ' ') && (texto.charAt(i) != '\n')) {
                this.addTransicion("  S" + estadoActual + "  ->");
                estadoActual = automata.nuevoEstado(texto.charAt(i), estadoActual);
                cadena += texto.charAt(i);
                this.addTransicion("  " + texto.charAt(i) + "  ->  S" + estadoActual + "\n");

                if (estadoActual == -1) {
                    System.out.println(cadena + " -> Error lexico");
                    errorLexico erl = new errorLexico(cadena, 0, 0);
                    listaErrores.add(erl);
                    estadoActual = 0;
                    cadena = "";
                } else if (estadoActual == -5) {
                    System.out.println(cadena + " -> Error: No se reconoce el simbolo (" + texto.charAt(i) + ")");
                    listaErrores.add(new errorLexico(cadena, 0, 0));
                    estadoActual = 0;
                    cadena = "";
                }

            } else {

                if (!cadena.isEmpty()) {

                    for (tipoTokens tk : tipoTokens.values()) {
                        if (tk.getEstadoAcept() == estadoActual) {
                            token nuevoToken = new token(cadena, tk, 0, 0);
                            listaTokens.add(nuevoToken);

                            this.addTransicion("  Token: " + nuevoToken.getTipoToken().name() + ",   Lexema: " 
                                    + nuevoToken.getLexema() + "\n\n");

                            estadoActual = 0;
                            cadena = "";
                        }
                    }

                }
            }
        }

    }
        
    public void addTransicion(String transiciones) {       
        this.transiciones = this.transiciones + transiciones;
    }
    
    public String getTransiciones() {
        return transiciones;
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
