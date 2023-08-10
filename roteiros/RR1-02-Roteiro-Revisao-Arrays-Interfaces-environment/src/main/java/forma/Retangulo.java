package forma;

public class Retangulo implements Forma {

    private double base;
    private double altura;

    public Retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double Area() {
        return base * altura;
    }
}