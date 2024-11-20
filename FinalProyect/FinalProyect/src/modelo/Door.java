
package modelo;


public class Door extends Producto {
    private String type;

    public Door(String type,int id, String name, String dimension, String material) {
        super(id, name, dimension, material);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
    
    
}
