import java.util.List;
import java.util.ArrayList;

class Dominoes {
	static List<Domino> validChain = new ArrayList<>();

	List<Domino> formChain(List<Domino> dominoList) throws ChainNotFoundException {
		validChain = new ArrayList<>();
		if(dominoList.isEmpty())
		return new ArrayList<>();
		List<Domino> tempDomino = new ArrayList<>();
		for (Domino dom : dominoList)
			tempDomino.add(dom);
		List<Domino> result = new ArrayList<>();
		listChains(result, tempDomino, dominoList.size());
		if(validChain.isEmpty())
			throw new ChainNotFoundException("No domino chain found.");
		return validChain;
	}

	private static void listChains(List<Domino> chain, List<Domino> list, int listSize) {
		for (int i = 0; i < list.size(); ++i) {

			Domino dom = list.get(i);
			if (canAppend(dom, chain)) {
				chain.add(dom);
				Domino saved = dom;
				if (!list.isEmpty())
					saved = list.remove(i);
				if (chain.size() == listSize && list.isEmpty()
						&& chain.get(0).getLeft() == chain.get(chain.size() - 1).getRight())
					for (Domino domino : chain) {
						if (validChain.size() < listSize)
							validChain.add(domino);
					}

				listChains(chain, list, listSize);
				list.add(i, saved);
				chain.remove(chain.size() - 1);
			}
			dom = dom.flipped();
			if (canAppend(dom, chain)) {
				chain.add(dom);
				Domino saved = list.remove(i);
				listChains(chain, list, listSize);
				list.add(i, saved);
				chain.remove(chain.size() - 1);
			}

		}

	}

	private static boolean canAppend(Domino domino, List<Domino> list) {
		return list.isEmpty() || list.get(list.size() - 1).getRight() == domino.getLeft();
	}
}
