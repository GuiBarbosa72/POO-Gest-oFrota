public class Motocicleta extends Veiculo {

    public Motocicleta(String placa, String modelo, double custoKm) {
        super(placa, modelo, custoKm);
    }

    @Override
    public double custoViagem(double distanciaKm) {
        if (distanciaKm <= 0) {
        }
        return distanciaKm * getCustoKm();
    }
}