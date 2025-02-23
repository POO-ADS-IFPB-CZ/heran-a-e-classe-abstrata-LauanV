package conta;

public class Main {
    public static void main(String[] args) {

        ContaEspecial ce = new ContaEspecial("001", 1000.0, "João", 500.0);
        System.out.println("Saldo inicial ContaEspecial: " + ce.getSaldo());
        ce.sacar(1200.0);
        System.out.println("Saldo após saque: " + ce.getSaldo());

        ContaPoupanca cp = new ContaPoupanca("002", 1000.0, "Maria", 0.05); // 5% de rendimento
        System.out.println("\nSaldo inicial ContaPoupanca: " + cp.getSaldo());
        cp.reajustar();
        System.out.println("Saldo após reajuste: " + cp.getSaldo());

    }
}