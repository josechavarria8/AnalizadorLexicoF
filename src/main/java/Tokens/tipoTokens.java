
package Tokens;

public enum tipoTokens {

    IDENTIFICADOR(1), 
    NUMERO(2), 
    DECIMAL(4), 
    PUNTUACION(5),
    OPERADOR(6), 
    AGRUPACION(7);

    private int estadoAceptacion; // Estado de Aceptación

    private tipoTokens(int estadoAceptacion) {
        this.estadoAceptacion = estadoAceptacion;
    }

    public int getEstadoAcept() {
        return estadoAceptacion;
    }
    
}
