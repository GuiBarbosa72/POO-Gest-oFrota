public abstract class Veiculo {
    private String placa;
    private String modelo;
    private double custoKm;
    private boolean emManutencao;
    public Veiculo(String placa, String modelo, double custoPorKm) {
        this.placa = placa;
        this.modelo = modelo;
        if (custoPorKm <= 0) {
            System.out.println("Erro: Custo por km deve ser maior que zero");
            this.custoKm = 1.0;
        } else {
            this.custoKm = custoPorKm;
        }
        this.emManutencao = false;
    }
    public String getPlaca() {
        return placa;
    }
    public String getModelo() {
        return modelo;
    }
    public double getCustoKm() {
        return custoKm;
    }
    public boolean emManutencao() {
        return emManutencao;
    }
    public void enviarManutencao() {
        this.emManutencao = true;
        System.out.println("Veículo " + placa + " enviado para manutenção.");
    }
    public void liberarManutencao() {
        this.emManutencao = false;
        System.out.println("Veículo " + placa + " liberado da manutenção.");
    }
    public abstract double custoViagem(double distanciaKm);
    public void iniciarEntrega(double distanciaKm) {
        if (emManutencao) {
            System.out.println("Veículo: " + placa);
            System.out.println("Situação: EM MANUTENÇÃO");
            System.out.println("A entrega não pode ser iniciada.");
        }
        if (distanciaKm <= 0) {
            System.out.println("A entrega não pode ser iniciada: distância deve ser maior que zero.");
        }
        double custo = custoViagem(distanciaKm);
        System.out.println("Veículo: " + placa);
        System.out.println("Modelo: " + modelo);
        System.out.println("Distância: " + distanciaKm + " km");
        System.out.println("Custo previsto: R$ " + custo);
        System.out.println("Entrega iniciada com sucesso.");
    }
}