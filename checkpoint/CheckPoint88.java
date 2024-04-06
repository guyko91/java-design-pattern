public class CheckPoint88 {

    public static class Person {
        private Role role;

        public void setRole(Role role) {
            this.role = role;
        }

        public Role getRole() {
            return role;
        }

        public void doIt() {
            role.doIt();
        }

    }

    abstract static class Role {
        public abstract void doIt();
    }

    public static class Driver extends Role {
        public void doIt() {
            System.out.println("Driving");
        }
    }

    public static class Worker extends Role {
        public void doIt() {
            System.out.println("Working");
        }
    }

    public static void main(String[] args) {
        Person person = new Person();
        Role role = new Driver();
        person.setRole(role);
        person.doIt();

        person.setRole(new Worker());
        person.doIt();
    }
}
