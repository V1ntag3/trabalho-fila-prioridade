package fila;

public class Fila {
	private class Node {
		String nome;
		Node prox;
	}

	Node inicio;
	Node fim;

	private int qnt;
	private int qntTotal;

	public int getQnt() {
		return qnt;
	}

	public int getQntTotal() {
		return qntTotal;
	}

	public Fila() {
		inicio = null;
		fim = null;
		qnt = 0;
		qntTotal = 0;
	}

	public void enqueue(String nome) {
		Node no = new Node();
		no.nome = nome;
		no.prox = null;
		if (inicio == null) {
			inicio = no;
			fim = no;
		} else {
			fim.prox = no;
			fim = no;
		}
		qntTotal++;
		qnt++;
	}

	public String dequeue() {
		Node aux = inicio;
		if (isEmpty()) {
			return "";
		} else {
			inicio = inicio.prox;
			qnt--;
			if (qnt == 0) {
				inicio = null;
				fim = null;
			}
			return aux.nome;
		}
	}

	public boolean isEmpty() {
		if (qnt == 0) {
			return true;
		}

		return false;
	}

	public String toString() {
		StringBuilder dados = new StringBuilder();
		if (isEmpty()) {
			return "";
		} else {
			Node aux = inicio;
			while (aux != null) {
				dados.append(aux.nome + "\n");
				aux = aux.prox;
			}
			return dados.toString();
		}
	}
}