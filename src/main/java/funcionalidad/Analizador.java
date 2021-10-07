
package funcionalidad;

import java.util.ArrayList;
import elementos.*;

public class Analizador {
    
    private ArrayList<Token> listaTokens = new ArrayList<Token>();
    private ArrayList<ErrorLexico> listaErrores = new ArrayList<ErrorLexico>();
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
                estadoActual = Automata.nuevoEstado(texto.charAt(i), estadoActual);
                cadena += texto.charAt(i);
                this.addTransicion("  " + texto.charAt(i) + "  ->  S" + estadoActual + "\n");

                if (estadoActual == -1) {
                    System.out.println(cadena + " -> Error lexico");
                    ErrorLexico erl = new ErrorLexico(cadena, 0, 0);
                    listaErrores.add(erl);
                    estadoActual = 0;
                    cadena = "";
                } else if (estadoActual == -5) {
                    System.out.println(cadena + " -> Error: No se reconoce el simbolo (" + texto.charAt(i) + ")");
                    listaErrores.add(new ErrorLexico(cadena, 0, 0));
                    estadoActual = 0;
                    cadena = "";
                }

            } else {

                if (!cadena.isEmpty()) {

                    for (TipoToken tk : TipoToken.values()) {
                        if (tk.getEstadoAcept() == estadoActual) {
                            Token nuevoToken = new Token(cadena, tk, 0, 0);
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
    
    public ArrayList<Token> getListaTokens() {
        return listaTokens;
    }

    public void setListaTokens(ArrayList<Token> listaTokens) {
        this.listaTokens = listaTokens;
    }

    public ArrayList<ErrorLexico> getListaErrores() {
        return listaErrores;
    }

    public void setListaErrores(ArrayList<ErrorLexico> listaErrores) {
        this.listaErrores = listaErrores;
    }

}
