package xmlreader;

import java.io.Serializable;

/**
 *
 * @author Alba
 */
public class Products implements Serializable {

    private String codigo, descricion;
    private double prezo;

    public Products() {
        this.codigo = null;
        this.descricion = null;
        this.prezo = 0;
    }

    public Products(String codigo, String descricion, double prezo) {
        this.codigo = codigo;
        this.descricion = descricion;
        this.prezo = prezo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricion() {
        return descricion;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }

    public double getPrezo() {
        return prezo;
    }

    public void setPrezo(double prezo) {
        this.prezo = prezo;
    }

    @Override
    public String toString() {
        return codigo + "\n" + descricion + "\n"
                + prezo;

    }

}
