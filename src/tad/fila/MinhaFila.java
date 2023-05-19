package tad.fila;

/**
 * Fila deve ser implementada com array fixo e estratégia circular
 * de gerenciamento de apontadores de cauda e cabeça.
 * @author fabioleite
 *
 */
public class MinhaFila implements FilaIF<Integer> {

	private int tamanho = 10;
	private int cauda = 1;
	private int cabeca = 0;
	private Integer[] meusDados = null;

	public MinhaFila(int tamanhoInicial) {
		tamanho = tamanhoInicial;
		meusDados = new Integer[tamanho];
	}

	public MinhaFila() {
		meusDados = new Integer[tamanho];
	}

	@Override
	public void enfileirar(Integer item) throws FilaCheiaException {
		if (isFull()) {
			throw new FilaCheiaException("Fila cheia. Não é possível enfileirar o item.");
		}
		meusDados[cauda] = item;
		cauda = (cauda + 1) % tamanho;
	}

	@Override
	public Integer desenfileirar() throws FilaVaziaException {
		if (isEmpty()) {
			throw new FilaVaziaException("Fila vazia. Não é possível desenfileirar.");
		}
		Integer item = meusDados[cabeca];
		cabeca = (cabeca + 1) % tamanho;
		return item;
	}

	@Override
	public Integer verificarCauda() throws FilaVaziaException {
		if (isEmpty()) {
			throw new FilaVaziaException("Fila vazia. Não é possível verificar a cauda.");
		}
		return meusDados[(cauda - 1 + tamanho) % tamanho];
	}

	@Override
	public Integer verificarCabeca() throws FilaVaziaException {
		if (isEmpty()) {
			throw new FilaVaziaException("Fila vazia. Não é possível verificar a cabeça.");
		}
		return meusDados[cabeca];
	}

	@Override
	public boolean isEmpty() {
		return cabeca == cauda;
	}

	@Override
	public boolean isFull() {
		return (cauda + 1) % tamanho == cabeca;
	}
}


