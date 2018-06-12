package task02;

public abstract class Transportation {
    private String number, model, admin;

    public Transportation(String number, String model, String admin) {
        this.number = number;
        this.model = model;
        this.admin = admin;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public abstract void transport();
}
