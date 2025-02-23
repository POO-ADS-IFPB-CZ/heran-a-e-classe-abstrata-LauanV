package conta;

public class ContaEspecial extends Conta {
    private double limite;

    public ContaEspecial(String numeroConta, double saldo, String titular, double limite) {
        super(numeroConta, saldo, titular);
        this.limite = limite;
    }

    public boolean sacar(double valor) {
        if (valor > 0 && (saldo + limite) >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public double getLimite() {
        return limite;
    }
}