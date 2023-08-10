package forma;

public class Triangulo implements Forma {
    
    double base;
    double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double Area() {
        return (base * altura) / 2;
    }
}
