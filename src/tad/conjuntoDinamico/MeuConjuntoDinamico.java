package tad.conjuntoDinamico;

public class MeuConjuntoDinamico implements ConjuntoDinamicoIF<Integer> {

	private Integer[] meusDados = null;
	private int posInsercao = 0;

	@Override
	public void inserir(Integer item) {
		if (meusDados == null) {
			meusDados = new Integer[1];
		}

		if (posInsercao >= meusDados.length) {
			meusDados = aumentarArray();
		}

		meusDados[posInsercao] = item;
		posInsercao++;
	}

	private Integer[] aumentarArray() {
		int novoTamanho = meusDados.length * 2;
		Integer[] arrayMaior = new Integer[novoTamanho];
		System.arraycopy(meusDados, 0, arrayMaior, 0, meusDados.length);
		return arrayMaior;
	}

	@Override
	public Integer remover(Integer item) {
		if (meusDados == null) {
			return null;
		}

		int indice = -1;
		for (int i = 0; i < posInsercao; i++) {
			if (meusDados[i].equals(item)) {
				indice = i;
				break;
			}
		}

		if (indice == -1) {
			return null;
		}

		Integer valorRemovido = meusDados[indice];
		for (int i = indice; i < posInsercao - 1; i++) {
			meusDados[i] = meusDados[i + 1];
		}

		meusDados[posInsercao - 1] = null;
		posInsercao--;

		return valorRemovido;
	}

	@Override
	public Integer predecessor(Integer item) {
		if (meusDados == null) {
			return null;
		}

		Integer predecessor = null;
		for (int i = 0; i < posInsercao; i++) {
			if (meusDados[i].equals(item)) {
				break;
			}
			predecessor = meusDados[i];
		}

		return predecessor;
	}

	@Override
	public Integer sucessor(Integer item) {
		if (meusDados == null) {
			return null;
		}

		boolean encontrado = false;
		for (int i = 0; i < posInsercao - 1; i++) {
			if (encontrado) {
				return meusDados[i];
			}
			if (meusDados[i].equals(item)) {
				encontrado = true;
			}
		}

		return null;
	}

	@Override
	public int tamanho() {
		return posInsercao;
	}

	@Override
	public Integer buscar(Integer item) {
		if (meusDados == null) {
			return null;
		}

		for (int i = 0; i < posInsercao; i++) {
			if (meusDados[i].equals(item)) {
				return meusDados[i];
			}
		}

		return null;
	}

	@Override
	public Integer minimum() {
		if (meusDados == null || posInsercao == 0) {
			throw new NoSuchElementException("Conjunto vazio. Não é possível obter o valor mínimo.");
		}

		Integer minimum = meusDados[0];
		for (int i = 1; i < posInsercao; i++) {
			if (meusDados[i].compareTo(minimum) < 0) {
				minimum = meusDados[i];
			}
		}

		return minimum;
	}

	@Override
	public Integer maximum() {
		if (meusDados == null || posInsercao == 0) {
			return null;
		}

		Integer maximum = meusDados[0];
		for (int i = 1; i < posInsercao; i++) {
			if (meusDados[i].compareTo(maximum) > 0) {
				maximum = meusDados[i];
			}
		}

		return maximum;
	}
}
