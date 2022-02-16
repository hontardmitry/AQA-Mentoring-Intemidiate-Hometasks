package instance_of.entities;

public class SuperAdmin extends Admin{

    public SuperAdmin(String name) {
        super(name);
    }

    public boolean hasSuperAdminPermission() {
        return true;
    }
}
