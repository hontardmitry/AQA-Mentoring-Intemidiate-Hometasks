package instance_of;

import instance_of.entities.Admin;
import instance_of.entities.SuperAdmin;
import instance_of.entities.User;

public class Main {
    public static void main(String[] args) {
        User admin = new Admin("Admin Name");

        System.out.println("========================================================================");
        System.out.println("Actual 'admin' user class is: " + admin.getClass());
        System.out.println("All available methods for the 'admin' user created as User type variable:");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("User class method getName():" + admin.getName());
        System.out.println("========================================================================");

        if(admin instanceof Admin trueAdmin){
            System.out.println("Actual 'trueAdmin' user class is: " + admin.getClass());
            System.out.println("User 'admin' is an instanceof Admin");
            System.out.println("------------------------------------------------------------------------");
            System.out.println("All available methods for the 'admin' user created as User type variable" +
                "after instanceof was used:");
            System.out.println("User class method getName():" + trueAdmin.getName());
            System.out.println("Admin class method hasAdminPermission() is now available:"
                + trueAdmin.hasAdminPermission());
        } else {
            System.out.println("User 'admin' is not instanceof Admin");
        }
            System.out.println("========================================================================");

        if(admin instanceof SuperAdmin superAdminFromAdmin) {
            System.out.println("User 'admin' is an instanceof Super Admin");
        } else {
            System.out.println("User 'admin' is NOT an instanceof SuperAdmin");
        }
        System.out.println("========================================================================");
    }
}
