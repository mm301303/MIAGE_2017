package utils;

public class Rectangle extends Quadrilatere {
    public Rectangle(double x, double y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "Salut, je suis un "+ this.getClass().getSimpleName()+" :"+super.toString();
    }


}
