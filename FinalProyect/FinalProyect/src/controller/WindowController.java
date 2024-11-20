package controller;

import java.util.ArrayList;
import modelo.Window;

public class WindowController extends ProductoController {

    private final ArrayList<Window> listWindows = new ArrayList<>();

    @Override
    public <T> boolean register(int id,T obj) {
        try {
            if (obj == null) {
                return false;
            } else {
                Window objWindow = (Window) obj;
                this.listWindows.add(objWindow);
                return true;
            }
        } catch (Exception e) {

            return false;
        }
    }

    @Override
    public String search(int id) {
        String result = "";

        for (int i = 0; i < listWindows.size(); i++) {
            if (this.listWindows.get(i).getId() == id) {
                result = listWindows.get(i).getName() + "-"
                        + listWindows.get(i).getDimension() + "-"
                        + listWindows.get(i).getMaterial();
                break;

            }
        }
        return result;
    }

    @Override
    public <T> boolean update(int id, T obj) {

        boolean result = true;
        try {
            if (obj == null) {

                return false;
            } else {
                Window objWindow = (Window) obj;
                for (Window objtWindow : this.listWindows) {
                    if (objtWindow.getId() == id) {
                        objWindow.setName(objtWindow.getName());
                        objWindow.setDimension(objtWindow.getDimension());
                        objWindow.setMaterial(objtWindow.getMaterial());

                    }
                }
            }

        } catch (Exception e) {
            result = false;

        }
        return result;
    }

    @Override
    public boolean remove(int id) {
        boolean result = true;
        int numberId = id;

        try {
            if (numberId != -1) {
                result = false;
                return result;
            } else {
                for (Window objWindow : this.listWindows) {
                    if (objWindow.getId() == id) {
                        this.listWindows.remove(objWindow);
                    }
                }
            }
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    @Override
    public String list() {
       String listWindow = "";
       
        for (int i = 0; i < this.listWindows.size(); i++) {
            listWindow += this.listWindows.get(i).getName() + " - " +
                    this.listWindows.get(i).getDimension() + " - " +
                    this.listWindows.get(i).getMaterial() + "\n";
                    break;
        }
        return listWindow;
    }

}
