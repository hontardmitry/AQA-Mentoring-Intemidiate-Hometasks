package instance_of.entities;

public class Admin extends User{

    public Admin(String name) {
        super(name);
    }

    public boolean hasAdminPermission() {
        return true;
    }
}
