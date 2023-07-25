package pe.edu.utp.provider.domain;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Luis Bazan
 */
public class Location {
    private final String name;
    private final ArrayList<Location> childrens = new ArrayList<>();

    /**
     * Constructor de una nueva locación
     * @param name Nombre de la locación
     */
    public Location(String name) {
        this.name = name;
    }

    /**
     * Constructor de una nueva locación incluyendo una lista de los hijos
     * @param name Nombre de la locación
     * @param children Lista de los hijos
     */
    public Location(String name, String[] children) {
        this.name = name;
        registerChildrens(children);
    }

    /**
     * Getter para obtener el nombre de la locación
     * @return Nombre de la locación
     */
    public String getName() {
        return name;
    }

    /**
     * Getter para obtener la lista de los hijos
     * @return Lista de los hijos
     */
    public ArrayList<Location> getChildrens() {
        return childrens;
    }

    /**
     * Registrar los hijos, y revisa que no estén duplicados
     * @param children Lista de los hijos
     */
    public void registerChildrens(String[] children) {
        if (children.length == 0) return;
        String comp = children[0];
        int index = this.childrens.stream().map(x -> x.getName().toUpperCase()).toList().indexOf(comp.toUpperCase());
        if (index < 0) {
            Location location = new Location(comp);
            location.registerChildrens(Arrays.copyOfRange(children, 1, children.length));
            this.childrens.add(location);
        } else {
            this.childrens.get(index).registerChildrens(Arrays.copyOfRange(children, 1, children.length));
        }
    }
}
