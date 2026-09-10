public class Main {
    public static void main() {

        Motocicleta moto = new Motocicleta("GHI7J89", "Honda CG", 1.0);
        Carro carro = new Carro("DEF4G56", "Fiat Fiorino", 1.5);
        Caminhao caminhao = new Caminhao("ABC1D23", "Volvo FH", 7.0, 15000.0);

        caminhao.carregar(20000.0);
        caminhao.carregar(10000.0);
        caminhao.iniciarEntrega(350.0);
        carro.enviarManutencao();
        carro.iniciarEntrega(100.0);

        System.out.println();
        carro.liberarManutencao();
        carro.iniciarEntrega(100.0);


        moto.iniciarEntrega(30.0);
        moto.iniciarEntrega(-10.0);
    }
}