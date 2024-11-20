package controller;

import java.util.ArrayList;
import modelo.Cabin;

public class CabinController extends ProductoController {

    private final ArrayList<Cabin> listCabin = new ArrayList<>();

    @Override
    public <T> boolean register(int id, T obj) {

        try {
            if (obj == null) {
                return false;

            } else if (listCabin.size() > 0) {
                for (int i = 0; i < listCabin.size(); i++) {
                    if (this.listCabin.get(i).getId() == id) {
                        return false;
                    }
                }

            }

            Cabin objCabin = (Cabin) obj;
            this.listCabin.add(objCabin);
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public String search(int id) {
        String result = "";

        for (int i = 0; i < listCabin.size(); i++) {
            if (this.listCabin.get(i).getId() == id) {
                result = this.listCabin.get(i).getName() + " - "
                        + this.listCabin.get(i).getDimension() + " - "
                        + this.listCabin.get(i).getMaterial() + " - "
                        + this.listCabin.get(i).getOpenStyle() + " - "
                        + this.listCabin.get(i).getColor();
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
                result = false;
            } else {
                Cabin objCabin = (Cabin) obj;
                for (Cabin objtCabin : this.listCabin) {
                    if (objtCabin.getId() == id) {
                        objtCabin.setName(objCabin.getName());
                        objtCabin.setDimension(objCabin.getDimension());
                        objtCabin.setMaterial(objCabin.getMaterial());
                        objtCabin.setOpenStyle(objCabin.getOpenStyle());
                        objtCabin.setColor(objCabin.getColor());
                        break;
                    }
                }
            }
            return result;
        } catch (Exception ex) {
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
                for (Cabin objtCabin : this.listCabin) {
                    if (objtCabin.getId() == id) {
                        this.listCabin.remove(objtCabin);

                    }
                }
            }
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    @Override
    public String list() {
        String listCabin = "";

        for (int i = 0; i < this.listCabin.size(); i++) {
            listCabin += this.listCabin.get(i).getName() + " - "
                    + this.listCabin.get(i).getDimension() + " - "
                    + this.listCabin.get(i).getMaterial() + " - "
                    + this.listCabin.get(i).getOpenStyle() + " - "
                    + this.listCabin.get(i).getColor() + "\n";
            break;
        }
        return listCabin;
    }

}
