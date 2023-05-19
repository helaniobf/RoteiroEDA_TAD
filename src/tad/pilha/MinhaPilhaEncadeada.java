package tad.pilha;

public class MinhaPilhaEncadeada implements PilhaIF<Integer> {

	private ListaEncadeadaIF<Integer> listaEncadeada;

	public MinhaPilhaEncadeada() {
		listaEncadeada = new MinhaListaEncadeada<>();
	}

	@Override
	public void empilhar(Integer item) throws PilhaCheiaException {
		listaEncadeada.insere(item);
	}

	@Override
	public Integer desempilhar() throws PilhaVaziaException {
		if (isEmpty()) {
			throw new PilhaVaziaException();
		}
		Integer topo = listaEncadeada.remove();
		return topo;
	}

	@Override
	public Integer topo() {
		if (isEmpty()) {
			return null;
		}
		return listaEncadeada.getInicio().getDado();
	}

	@Override
	public PilhaIF<Integer> multitop(int k) {
		if (k <= 0) {
			throw new IllegalArgumentException("O valor de k é inválido.");
		}

		PilhaIF<Integer> pilhaMultiTop = new MinhaPilhaEncadeada();
		int elementosCopiados = 0;
		ListaEncadeadaNo<Integer> current = listaEncadeada.getInicio();
		while (elementosCopiados < k && current != null) {
			pilhaMultiTop.empilhar(current.getDado());
			current = current.getProximo();
			elementosCopiados++;
		}
		return pilhaMultiTop;
	}

	@Override
	public boolean isEmpty() {
		return listaEncadeada.estaVazia();
	}
}
