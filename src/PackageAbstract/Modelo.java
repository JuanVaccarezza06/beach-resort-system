package PackageAbstract;

import PackageInterfaces.IVerVentanilla;

import java.util.UUID;

public abstract class Modelo implements IVerVentanilla {
    private String id = UUID.randomUUID().toString().substring(0,5).toUpperCase();
    // Esto esta buenisimo, ya que cada instancia de clase que extienda de esta clase
    // abstracta, va a crear su propio id UNIQUE! sin molestar al constructor!

    // Si mis conocimientos no me fallan, NO es mala practica que una clase abstracta NO
    // tenga constructor, tampoco esta mal que SI tenga, pero yo prefiero que NO, ya que
    // no hay tareas para este constructor!

    public String getId() {
        return id;
        // este metodo, lo tienen todos las clases hijas! Por su puesto,
        // cada hija va a retornan su propio ID!
    }

    public void setId (String id){
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        boolean rta = false;
       if(o != null){
           if(o instanceof Modelo){
               if(((Modelo) o).getId().equals(this.id)){
                   rta = true;
                   // este metodo, lo tienen todos las clases hijas! Por su puesto,
                   // cada hija va resolver el .equals con su propio ID!
                   // NO hace falta que las hijas lo sobreescriban! (ya lo sobreeescribimos aca)
               }
           }
       }
    return rta;
    }
}
