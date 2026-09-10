public class Carro extends Veiculo {
    private static double TAXA_FIXA_OPERACIONAL = 15.0;

    public Carro(String placa, String modelo, double custoKm) {
        super(placa, modelo, custoKm);
    }

    @Override
    public double custoViagem(double distanciaKm) {
        if (distanciaKm <= 0) {
        }
        return (distanciaKm * getCustoKm()) + TAXA_FIXA_OPERACIONAL;
    }
}