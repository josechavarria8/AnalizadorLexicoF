
package Analizador;

public class automata {
    
    public static int nuevoEstado(char ch, int estadoActual) {

        int SiguienteEstado = -1;
        
        if ((ch == ' ') | (ch == '\n')) {        
            SiguienteEstado = 0;
        
        } else {
                            
            switch (estadoActual) {
                
                case 0:
                
                    if (Character.isLetter(ch)) { // S0 -> letra  -> S1 
                        SiguienteEstado = 1;
                    } else if (Character.isDigit(ch)) { // S0 -> dígito -> S2 
                        SiguienteEstado = 2;
                    } else if ( (ch == '.') || (ch == ',') || (ch == ':') || (ch == ';') ) { // S0 -> ( . | , | ; | : ) -> S5 
                        SiguienteEstado = 5;
                    } else if ( (ch == '+') || (ch == '-') || (ch == '*') || (ch == '/') || (ch == '%') ) { // S0 -> ( + | - | / | * | % ) -> S6 
                        SiguienteEstado = 6;
                    } else if ( (ch == '(') || (ch == ')') || (ch == '[') || (ch == ']') || (ch == '{') || (ch == '}') ) { // S0 -> ( '(' | ')' | '[' | ']' | '{' | '}' ) -> S7 
                        SiguienteEstado = 7;
                    } else { // No pertenece al alfabeto
                        SiguienteEstado = -5;
                    }
                    break;

                case 1:
                    if (Character.isLetterOrDigit(ch)) { // S1 -> ( letra | dígito ) -> S1
                        SiguienteEstado = 1;
                    }
                    break;

                case 2:
                    if (Character.isDigit(ch)) { // S2 -> dígito -> S2
                        SiguienteEstado = 2;
                    } else if (ch == '.') { // S2 ->  '.'   -> S3
                        SiguienteEstado = 3;
                    }
                    break;

                case 3:
                    if (Character.isDigit(ch)) { // S3 -> dígito -> S4
                        SiguienteEstado = 4;
                    }
                    break;

                case 4:
                    if (Character.isDigit(ch)) { // S4 -> dígito -> S4
                        SiguienteEstado = 4;
                    }
                    break;
               
            }

        }
            return SiguienteEstado;
            
    }
}
