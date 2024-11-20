
package modelo;


public class Cabin extends Producto {
    private String color;
    private String openStyle;

    public Cabin(int id, String name, String dimension, String material,String color,String openStyle) {
        super(id, name, dimension, material);
        this.color = color;
        this.openStyle = openStyle;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOpenStyle() {
        return openStyle;
    }

    public void setOpenStyle(String openStyle) {
        this.openStyle = openStyle;
    }
    
    
    
  
}
