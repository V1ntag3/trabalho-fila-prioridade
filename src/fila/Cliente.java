package fila;

import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		Fila filaP = new Fila();
		Fila filaN = new Fila();
		Scanner sc = new Scanner(System.in);
		String nome;
		int op = 0;
		while (true) {
			System.out.println(
					"\nMenu de opcoes:\n1.Chegada de pessoa para atendimento normal\n2.Chegada de pessoa para atendimento prioritário\n3.Atender pessoa\n4.Listar todas as pessoas da fila\n5.Gerar estatísticas\n6.Sair\n");
			op = Integer.parseInt(sc.nextLine());
			if (op == 1) {
				System.out.println("Adicionar pessoa normal à fila:");
				System.out.print("Digite o nome: ");
				nome = sc.nextLine();
				filaN.enqueue(nome);
			} else if (op == 2) {
				System.out.println("Adicionar pessoa com prioridade à fila:");
				System.out.print("Digite o nome: ");
				nome = sc.nextLine();
				filaP.enqueue(nome);
			} else if (op == 3) {
				if (filaP.isEmpty() && filaN.isEmpty()) {
					System.out.println("Fila vazia.");
				} else if (filaP.isEmpty()) {
					System.out.println("Pessoa normal atendida: " + filaN.dequeue());
				} else {
					System.out.println("Pessoa prioridade atendida: " + filaP.dequeue());
				}
			} else if (op == 4) {
				System.out.println("Listar pessoas da fila: ");
				System.out.print(filaP);
				System.out.print(filaN);
			} else if (op == 5) {
				System.out.println("Gerar estatisticas diárias da empresa: ");
				float soma = filaP.getQntTotal() + filaN.getQntTotal();
				float atendNormal = (filaN.getQntTotal() / soma) * 100;
				float atendPrioritario = (filaP.getQntTotal() / soma) * 100;
				System.out.printf("Porcentagem de atendimento prioritário: %.2f%%\n", atendPrioritario);
				System.out.printf("Porcentagem de atendimento normal: %.2f%%\n", atendNormal);
			} else if (op == 6) {
				if (filaP.isEmpty() && filaN.isEmpty()) {
					int qnt = filaP.getQntTotal() + filaN.getQntTotal();
					System.out.println("Quantidade de pessoas atendidas: " + qnt);
					break;
				} else {
					System.out.println("Fila ainda contem pessoas.");
				}
			} else {
				System.out.println("Opção inválida");
			}

		}
		sc.close();
		System.out.println("End of program");
	}
}