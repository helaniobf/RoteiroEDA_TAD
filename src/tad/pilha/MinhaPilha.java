package tad.pilha;

public class MinhaPilha implements PilhaIF<Integer> {

	private int tamanho;
	private Integer[] meusDados;
	private int topo;

	public MinhaPilha(int tamanho) {
		this.tamanho = tamanho;
		this.meusDados = new Integer[tamanho];
		this.topo = -1;
	}

	public MinhaPilha() {
		this(10); // Tamanho padrão da pilha
	}

	@Override
	public void empilhar(Integer item) throws PilhaCheiaException {
		if (topo == tamanho - 1) {
			throw new PilhaCheiaException();
		}
		meusDados[++topo] = item;
	}

	@Override
	public Integer desempilhar() throws PilhaVaziaException {
		if (isEmpty()) {
			throw new PilhaVaziaException();
		}
		Integer item = meusDados[topo];
		meusDados[topo--] = null;
		return item;
	}

	@Override
	public Integer topo() {
		if (isEmpty()) {
			return null;
		}
		return meusDados[topo];
	}

	@Override
	public PilhaIF<Integer> multitop(int k) {
		if (k <= 0) {
			throw new IllegalArgumentException("O valor de k é inválido.");
		}

		PilhaIF<Integer> pilhaMultiTop = new MinhaPilha(k);
		int elementosCopiados = 0;
		int posicao = topo;
		while (elementosCopiados < k && posicao >= 0) {
			pilhaMultiTop.empilhar(meusDados[posicao--]);
			elementosCopiados++;
		}
		return pilhaMultiTop;
	}

	@Override
	public boolean isEmpty() {
		return topo == -1;
	}
}


