
package elementos;

public class ErrorLexico {

    private String cadena;
    private int fila, columna;

    public ErrorLexico(String cadena) {
        this.setCadena(cadena);
    }

    public ErrorLexico(String cadena, int fila, int columna) {
        this.setCadena(cadena);
        this.setFila(fila);
        this.setColumna(columna);
    }

    public Object[] getArray() {
        
        Object[] arrayError = new Object[3];
        arrayError[0] = this.getCadena();
        arrayError[1] = this.getFila();
        arrayError[2] = this.getColumna();
        
        return arrayError;
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

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    @Override
    public String toString() {
        return "Error [ Cadena = " + cadena + " ]";
    }

    
}



