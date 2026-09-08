import java.util.Arrays;

public class Array2ADT<T>{
    private Object[][] datos;
    private int renglones;
    private int columnas;

    public Array2ADT(int renglones, int columnas) {
        this.datos = new Object[renglones][columnas];
        this.renglones = renglones;
        this.columnas = columnas;
    }

    public void rellenar(T elemento){
        for(int renglones = 0; renglones < this.renglones; renglones++){
            for(int columnas = 0; columnas < this.columnas; columnas++){
                datos[renglones][columnas] = elemento;
            }
        }
    }
    public int obtenerRenglones() {
        return this.renglones;
    }

    public int obtenerColumnas() {
        return this.columnas;
    }

    public T obtenerElemento(int renglones, int columnas){
        if(renglones >= 0 && renglones < this.renglones && columnas >= 0 && columnas < this.columnas) {
            return (T) datos[renglones][columnas];
        }else{
            System.out.println("Indice fuera de rango");
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void insertarElemento(int renglones,int columnas, T elemento){
        if(renglones >= 0 && renglones < this.renglones && columnas >= 0 && columnas < this.columnas ) {
            datos[renglones][columnas] = elemento;
        }else{
            System.out.println("Indice fuera de rango");
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        return "Array2ADT{" +
                "datos=" + Arrays.toString(datos) +
                ", renglones=" + renglones +
                ", columnas=" + columnas +
                '}';
    }
}
