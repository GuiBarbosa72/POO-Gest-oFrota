public class Caminhao extends Veiculo {
    private double capacidadeMaximaKg;
    private double pesoCargaAtualKg;

    public Caminhao(String placa, String modelo, double custoKm, double capacidadeMaximaKg) {
        super(placa, modelo, custoKm);
        this.capacidadeMaximaKg = capacidadeMaximaKg;
        this.pesoCargaAtualKg = 0.0;
    }

    public double getCapacidadeMaximaKg() {
        return capacidadeMaximaKg;
    }

    public double getPesoCargaAtualKg() {
        return pesoCargaAtualKg;
    }

    public void carregar(double pesoKg) {
        if (pesoKg <= 0) {
            System.out.println("Carga inválida.");
        }
        if (pesoKg > capacidadeMaximaKg) {
            System.out.println("Erro: Carga de " + pesoKg + " kg excede a capacidade máxima de " + capacidadeMaximaKg + " kg.");
        }
        this.pesoCargaAtualKg = pesoKg;
        System.out.println("Caminhão carregado com " + pesoKg + " kg de carga");
    }

    @Override
    public double custoViagem(double distanciaKm) {
        if (distanciaKm <= 0) {
            return 0.0;
        }
        double taxaCarga = (pesoCargaAtualKg / 1000.0) * 50.0;
        return (distanciaKm * getCustoKm()) + taxaCarga;
    }

    @Override
    public void iniciarEntrega(double distanciaKm) {
        if (emManutencao()) {
            System.out.println("Veículo: " + getPlaca());
            System.out.println("Situação: EM MANUTENÇÃO");
            System.out.println("A entrega não pode ser iniciada");

        }

        if (distanciaKm <= 0) {
            System.out.println("A entrega não pode ser iniciada");

        }

        double custo = custoViagem(distanciaKm);
        System.out.println("Veículo: " + getPlaca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Distância: " + distanciaKm + " km");
        System.out.println("Peso da carga: " + pesoCargaAtualKg + " kg");
        System.out.println("Custo previsto: R$ " + custo);
        System.out.println("Entrega iniciada com sucesso.");
    }
}