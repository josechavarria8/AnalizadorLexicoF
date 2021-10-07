package elementos;

public class Token {

    private String lexema;
    private TipoToken tipoToken;
    private int fila, columna;

    public Token(String lexema, TipoToken tipoToken) {
        this.setLexema(lexema);
        this.tipoToken = tipoToken;
    }

    public Token(String lexema, TipoToken tipoToken, int fila, int columna) {
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

    public TipoToken getTipoToken() {
        return tipoToken;
    }

    public void setTipoToken(TipoToken tipoToken) {
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
