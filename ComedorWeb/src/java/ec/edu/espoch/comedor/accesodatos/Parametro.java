package ec.edu.espoch.comedor.accesodatos;

/**
 *
 * @author Tupac
 */
public class Parametro {

      private  int posicion;
    private Object valor;
    private int tipo;

    public Parametro(int posicion, Object valor, int tipo) {
        this.posicion = posicion;
        this.valor = valor;
        this.tipo = tipo;
    }
 public Parametro(int posicion, Object valor) {
        this.posicion = posicion;
        this.valor = valor;
      
    }
    
    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}

