package tad.conjuntoDinamico;

public class MeuConjuntoDinamicoEncadeado implements ConjuntoDinamicoIF<Integer> {

	private Nodo<Integer> inicio;
	private int tamanho;

	public MeuConjuntoDinamicoEncadeado() {
		inicio = null;
		tamanho = 0;
	}

	@Override
	public void inserir(Integer item) {
		Nodo<Integer> novoNodo = new Nodo<>(item);

		if (inicio == null) {
			inicio = novoNodo;
		} else {
			Nodo<Integer> nodoAtual = inicio;
			Nodo<Integer> nodoAnterior = null;

			while (nodoAtual != null) {
				if (nodoAtual.getElemento().equals(item)) {
					return; // Elemento já existe no conjunto, não é inserido novamente
				}

				nodoAnterior = nodoAtual;
				nodoAtual = nodoAtual.getProximo();
			}

			nodoAnterior.setProximo(novoNodo);
		}

		tamanho++;
	}

	@Override
	public Integer remover(Integer item) {
		if (inicio == null) {
			return null; // Conjunto vazio, nenhum elemento para remover
		}

		if (inicio.getElemento().equals(item)) {
			Integer elementoRemovido = inicio.getElemento();
			inicio = inicio.getProximo();
			tamanho--;
			return elementoRemovido;
		}

		Nodo<Integer> nodoAnterior = inicio;
		Nodo<Integer> nodoAtual = inicio.getProximo();

		while (nodoAtual != null) {
			if (nodoAtual.getElemento().equals(item)) {
				Integer elementoRemovido = nodoAtual.getElemento();
				nodoAnterior.setProximo(nodoAtual.getProximo());
				tamanho--;
				return elementoRemovido;
			}

			nodoAnterior = nodoAtual;
			nodoAtual = nodoAtual.getProximo();
		}

		return null; // Elemento não encontrado no conjunto
	}

	@Override
	public Integer predecessor(Integer item) {
		if (inicio == null) {
			return null; // Conjunto vazio, nenhum predecessor
		}

		Nodo<Integer> nodoAtual = inicio;
		Nodo<Integer> nodoAnterior = null;
		Integer predecessor = null;

		while (nodoAtual != null) {
			if (nodoAtual.getElemento().equals(item)) {
				return predecessor;
			}

			predecessor = nodoAtual.getElemento();
			nodoAnterior = nodoAtual;
			nodoAtual = nodoAtual.getProximo();
		}

		return null; // Elemento não encontrado no conjunto
	}

	@Override
	public Integer sucessor(Integer item) {
		if (inicio == null) {
			return null; // Conjunto vazio, nenhum sucessor
		}

		Nodo<Integer> nodoAtual = inicio;

		while (nodoAtual != null) {
			if (nodoAtual.getElemento().equals(item)) {
				if (nodoAtual.getProximo() != null) {
					return nodoAtual.getProximo().getElemento();
				} else {
					return null; // Último elemento, não tem sucessor
				}
			}

			nodoAtual = nodoAtual.getProximo();
		}

		return null; // Elemento não encontrado no conjunto
	}

	@Override
	public int tamanho() {
		return tamanho;
	}

	@Override
	public Integer buscar(Integer item) {
		Nodo<Integer> nodoAtual = inicio;

		while (nodoAtual != null) {
			if (nodoAtual.getElemento().equals(item)) {
				return nodoAtual.getElemento();
			}

			nodoAtual = nodoAtual.getProximo();
		}

		return null; // Elemento não encontrado no conjunto
	}

	@Override
	public Integer minimum() {
		if (inicio == null) {
			return null; // Conjunto vazio, nenhum mínimo
		}

		Integer minimum = inicio.getElemento();
		Nodo<Integer> nodoAtual = inicio.getProximo();

		while (nodoAtual != null) {
			if (nodoAtual.getElemento().compareTo(minimum) < 0) {
				minimum = nodoAtual.getElemento();
			}

			nodoAtual = nodoAtual.getProximo();
		}

		return minimum;
	}

	@Override
	public Integer maximum() {
		if (inicio == null) {
			return null; // Conjunto vazio, nenhum máximo
		}

		Integer maximum = inicio.getElemento();
		Nodo<Integer> nodoAtual = inicio.getProximo();

		while (nodoAtual != null) {
			if (nodoAtual.getElemento().compareTo(maximum) > 0) {
				maximum = nodoAtual.getElemento();
			}

			nodoAtual = nodoAtual.getProximo();
		}

		return maximum;
	}
}

