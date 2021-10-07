package elementos;

import funcionalidad.Busqueda;
import java.util.ArrayList;

/**
 *
 * @author CIROSS
 */
public class Lexema {

    private String cadena;
    private TipoToken tipoToken;
    private int repeticiones;
    private ArrayList<Token> listaTokens;
    private ArrayList<Lexema> listaLexemas;

    public Lexema(ArrayList<Token> listaTokens) {
        this.listaTokens = listaTokens;
        listaLexemas = new ArrayList<>();
        crearArrayListLexemas();
    }

    private Lexema(String cadena, TipoToken token) {
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

                if (Busqueda.iguales(listaTokens.get(i).getLexema(), listaLexemas.get(j).getCadena())) {
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

    

    private void agregarLexema(Token token) {
        String lexema = token.getLexema();
        TipoToken tipoTk = token.getTipoToken();
        listaLexemas.add(new Lexema(lexema, tipoTk));
    }

    public ArrayList<Lexema> getListaLexemas() {
        return listaLexemas;
    }

    public void setListaLexemas(ArrayList<Lexema> listaLexemas) {
        this.listaLexemas = listaLexemas;
    }
    
    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public TipoToken getToken() {
        return tipoToken;
    }

    public void setToken(TipoToken token) {
        this.tipoToken = token;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void aumentarRepeticiones() {
        this.repeticiones++;
    }

}
