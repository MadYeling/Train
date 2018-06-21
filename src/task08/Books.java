package task08;

public class Books {
    private int number, id;
    private String name;
    private float price,sales;

    Books(int id, String name, float price, int number) {
        this.number = number;
        this.sales = number * price;
        this.name = name;
        this.price = price;
        this.id = id;
    }

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    int getNumber() {
        return number;
    }

    void setNumber(int number) {
        this.number = number;
    }

    float getSales() {
        return sales;
    }

    void setSales(int sales) {
        this.sales = sales;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    float getPrice() {
        return price;
    }

    void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "图书编号:" + this.getId() + "\t图书名称:" + this.getName() + "\t图书价格:" + this.getPrice() + "\t图书数量:" + this.getNumber() + "\t总价:" + this.getSales();
    }
}
