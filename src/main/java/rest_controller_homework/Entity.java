package rest_controller_homework;

public class Entity {
    private float price;
    private Info info;

    public Entity() {
    }

    public Entity(Info info, float price) {
        this.info = info;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
