package Tokens;

public class token {

    private String lexema;
    private tipoTokens tipoToken;
    private int fila, columna;

    public token(String lexema, tipoTokens tipoToken) {
        this.setLexema(lexema);
        this.tipoToken = tipoToken;
    }

    public token(String lexema, tipoTokens tipoToken, int fila, int columna) {
        this.setLexema(lexema);
        this.setTipoToken(tipoToken);
        this.setFila(fila);
        this.setColumna(columna);
    }
    
    public Object[] getArray() {
        
        Object[] arrayToken = new Object[4];
        arrayToken[0] = this.getTipoToken();
        arrayToken[1] = this.getLexema();
        arrayToken[2] = this.getFila();
        arrayToken[3] = this.getColumna();
        
        return arrayToken;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public tipoTokens getTipoToken() {
        return tipoToken;
    }

    public void setTipoToken(tipoTokens tipoToken) {
        this.tipoToken = tipoToken;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    @Override
    public String toString() {
        return "Token [ Lexema = " + lexema + ", Token = " + tipoToken + " ]";
    }

}
