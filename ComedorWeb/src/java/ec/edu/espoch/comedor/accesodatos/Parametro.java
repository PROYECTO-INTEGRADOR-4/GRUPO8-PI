package ec.edu.espoch.comedor.accesodatos;

/**
 *
 * @author Tupac
 */
public class Parametro {

    private Integer posicion;
    private Object valor; //el Object almacena datos de cualquier tipo de dato
    private Integer tipo;

    public Parametro(Integer posicion, Object valor, Integer tipo) {
        this.posicion = posicion;
        this.valor = valor;
        this.tipo = tipo;
    }
        public Parametro(Integer posicion, Object valor) {
        this.posicion = posicion;
        this.valor = valor;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

}
