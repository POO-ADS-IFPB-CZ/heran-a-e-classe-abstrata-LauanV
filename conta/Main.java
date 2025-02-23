package conta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Conta> contas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Criar nova conta");
            System.out.println("2. Listar contas");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    criarConta(contas, scanner);
                    break;
                case 2:
                    listarContas(contas);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static void criarConta(List<Conta> contas, Scanner scanner) {
        System.out.println("\n=== Tipo de Conta ===");
        System.out.println("1. Conta (padrão)");
        System.out.println("2. Conta Especial");
        System.out.println("3. Conta Poupança");
        System.out.print("Escolha o tipo de conta: ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        // Dados comuns a todas as contas
        System.out.print("Número da conta: ");
        String numeroConta = scanner.nextLine();
        System.out.print("Saldo inicial: ");
        double saldo = scanner.nextDouble();
        scanner.nextLine(); // Consumir a quebra de linha
        System.out.print("Titular: ");
        String titular = scanner.nextLine();

        switch (tipo) {
            case 1: // Conta padrão (usaremos ContaPoupanca com taxa 0 como exemplo)
                contas.add(new ContaPoupanca(numeroConta, saldo, titular, 0.0));
                System.out.println("Conta padrão criada com sucesso!");
                break;
            case 2: // Conta Especial
                System.out.print("Limite da Conta Especial: ");
                double limite = scanner.nextDouble();
                contas.add(new ContaEspecial(numeroConta, saldo, titular, limite));
                System.out.println("Conta Especial criada com sucesso!");
                break;
            case 3: // Conta Poupança
                System.out.print("Taxa de rendimento (ex: 0.05 para 5%): ");
                double taxaRendimento = scanner.nextDouble();
                contas.add(new ContaPoupanca(numeroConta, saldo, titular, taxaRendimento));
                System.out.println("Conta Poupança criada com sucesso!");
                break;
            default:
                System.out.println("Tipo de conta inválido!");
        }
    }

    private static void listarContas(List<Conta> contas) {
        if (contas.isEmpty()) {
            System.out.println("\nNenhuma conta cadastrada.");
            return;
        }

        System.out.println("\n=== Lista de Contas ===");
        for (int i = 0; i < contas.size(); i++) {
            Conta conta = contas.get(i);
            System.out.printf("Conta %d: Número: %s, Titular: %s, Saldo: %.2f%n",
                    i + 1, conta.getNumeroConta(), conta.getTitular(), conta.getSaldo());
            // Identificar o tipo específico
            if (conta instanceof ContaEspecial) {
                System.out.printf("   Tipo: Conta Especial, Limite: %.2f%n",
                        ((ContaEspecial) conta).getLimite());
            } else if (conta instanceof ContaPoupanca) {
                System.out.printf("   Tipo: Conta Poupança, Taxa de Rendimento: %.2f%%%n",
                        ((ContaPoupanca) conta).getTaxaRendimento() * 100);
            }
        }
    }
}