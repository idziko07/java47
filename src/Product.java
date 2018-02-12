public class Product {
    private String nazwa;
    private String producent;
    private double cena;

    public Product(String nazwa, String producent, double cena) {
        this.nazwa = nazwa;
        this.producent = producent;
        this.cena = cena;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getProducent() {
        return producent;
    }

    public double getCena() {
        return cena;
    }

    @Override
    public String toString() {
        return nazwa + " " + producent + " " + cena;
    }

}
