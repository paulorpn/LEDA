package forma;

public class Circulo implements Forma {

    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double Area() {
        return Math.PI * (raio * raio);
    }
}
