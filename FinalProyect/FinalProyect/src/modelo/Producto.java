
package modelo;

/**
 *
 * @author user
 */
abstract class Producto {
    protected int id;
    protected String name;
    protected String dimension;
    protected String material;

    public Producto(int id, String name, String dimension, String material) {
        this.id = id;
        this.name = name;
        this.dimension = dimension;
        this.material = material;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    
    
}
