package conta;

public class ContaPoupanca extends Conta {
    private double taxaRendimento;

    public ContaPoupanca(String numeroConta, double saldo, String titular, double taxaRendimento) {
        super(numeroConta, saldo, titular);
        this.taxaRendimento = taxaRendimento;
    }

    public void reajustar() {
        if (saldo > 0) {
            saldo += saldo * taxaRendimento;
        }
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }
}