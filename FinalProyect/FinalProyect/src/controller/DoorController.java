package controller;

import java.util.ArrayList;
import modelo.Door;

public class DoorController extends ProductoController {

    private final ArrayList<Door> listDoor = new ArrayList<>();

    @Override
    public <T> boolean register(int id,T obj) {
        try {
            if (obj == null) {
                return false;

            } else {
                Door objDoor = (Door) obj;
                this.listDoor.add(objDoor);
                return true;
            }

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String search(int id) {
        String result = "";

        for (int i = 0; i < listDoor.size(); i++) {
            if (this.listDoor.get(i).getId() == id) {
                result = this.listDoor.get(i).getName() + " - "
                        + this.listDoor.get(i).getDimension() + " - "
                        + this.listDoor.get(i).getMaterial() + " - "
                        + this.listDoor.get(i).getType();

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
                Door objDoor = (Door) obj;
                for (Door objtDoor : this.listDoor) {
                    if (objtDoor.getId() == id) {
                        objtDoor.setName(objDoor.getName());
                        objtDoor.setDimension(objDoor.getDimension());
                        objtDoor.setMaterial(objDoor.getMaterial());
                        objtDoor.setType(objDoor.getType());
                        break;

                    }
                }
                return result;
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
                for (Door objtDoor : this.listDoor) {
                    if (objtDoor.getId() == id) {
                        this.listDoor.remove(objtDoor);

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
        String listDoor = "";

        for (int i = 0; i < this.listDoor.size(); i++) {
            listDoor += this.listDoor.get(i).getName() + " - "
                    + this.listDoor.get(i).getDimension() + " - "
                    + this.listDoor.get(i).getMaterial() + " - "
                    + this.listDoor.get(i).getType() + "\n";
            break;
        }
        return listDoor;
    }
}
