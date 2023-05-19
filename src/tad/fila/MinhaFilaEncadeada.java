package tad.fila;

public class MinhaFilaEncadeada implements FilaIF<Integer> {

	private Node cabeca;
	private Node cauda;
	private int tamanho;

	private class Node {
		private Integer item;
		private Node proximo;

		public Node(Integer item) {
			this.item = item;
			this.proximo = null;
		}
	}

	public MinhaFilaEncadeada() {
		cabeca = null;
		cauda = null;
		tamanho = 0;
	}

	@Override
	public void enfileirar(Integer item) throws FilaCheiaException {
		Node novoNode = new Node(item);
		if (isEmpty()) {
			cabeca = novoNode;
			cauda = novoNode;
		} else {
			cauda.proximo = novoNode;
			cauda = novoNode;
		}
		tamanho++;
	}

	@Override
	public Integer desenfileirar() throws FilaVaziaException {
		if (isEmpty()) {
			throw new FilaVaziaException();
		}
		Integer item = cabeca.item;
		cabeca = cabeca.proximo;
		if (cabeca == null) {
			cauda = null;
		}
		tamanho--;
		return item;
	}

	@Override
	public Integer verificarCauda() throws FilaVaziaException {
		if (isEmpty()) {
			throw new FilaVaziaException();
		}
		return cauda.item;
	}

	@Override
	public Integer verificarCabeca() throws FilaVaziaException {
		if (isEmpty()) {
			throw new FilaVaziaException();
		}
		return cabeca.item;
	}

	@Override
	public boolean isEmpty() {
		return tamanho == 0;
	}

	@Override
	public boolean isFull() {
		return false;
	}
}

