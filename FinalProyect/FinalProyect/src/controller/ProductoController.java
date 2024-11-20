
package controller;


abstract class ProductoController {
    
    abstract  <T> boolean register (int id,T obj);
    
    abstract String search (int id);
    
    abstract  <T> boolean update (int id,T obj);
    
    abstract   boolean remove  (int id);
    
    abstract String list();
}
