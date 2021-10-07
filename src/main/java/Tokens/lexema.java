package Tokens;

import Analizador.busqueda;
import java.util.ArrayList;

/**
 *
 * @author CIROSS
 */
public class lexema {

    private String cadena;
    private tipoTokens tipoToken;
    private int repeticiones;
    private ArrayList<token> listaTokens;
    private ArrayList<lexema> listaLexemas;

    public lexema(ArrayList<token> listaTokens) {
        this.listaTokens = listaTokens;
        listaLexemas = new ArrayList<>();
        crearArrayListLexemas();
    }

    private lexema(String cadena, tipoTokens token) {
        this.cadena = cadena;
        this.tipoToken = token;
        this.repeticiones = 0;
    }
    
    public Object[] getArray() {
        
        Object[] arrayLexema = new Object[4];
        arrayLexema[0] = this.getCadena();
        arrayLexema[1] = this.getToken();
        arrayLexema[2] = this.getRepeticiones();
        
        return arrayLexema;
    }

    private void crearArrayListLexemas() {
        
        agregarLexema(listaTokens.get(0));
        listaLexemas.get(0).aumentarRepeticiones();

        for (int i = 1; i < listaTokens.size(); i++) {
            
            int contador = 0;
            for (int j = 0; j < listaLexemas.size(); j++) {

                if (busqueda.iguales(listaTokens.get(i).getLexema(), listaLexemas.get(j).getCadena())) {
                    listaLexemas.get(j).aumentarRepeticiones();
                    break;
                } else {
                    contador++;
                }
            }

            if (contador == listaLexemas.size()) {
                agregarLexema(listaTokens.get(i));
                listaLexemas.get(listaLexemas.size()-1).aumentarRepeticiones();
            }
        }
        
    }

    

    private void agregarLexema(token token) {
        String lexema = token.getLexema();
        tipoTokens tipoTk = token.getTipoToken();
        listaLexemas.add(new lexema(lexema, tipoTk));
    }

    public ArrayList<lexema> getListaLexemas() {
        return listaLexemas;
    }

    public void setListaLexemas(ArrayList<lexema> listaLexemas) {
        this.listaLexemas = listaLexemas;
    }
    
    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public tipoTokens getToken() {
        return tipoToken;
    }

    public void setToken(tipoTokens token) {
        this.tipoToken = token;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void aumentarRepeticiones() {
        this.repeticiones++;
    }

}
