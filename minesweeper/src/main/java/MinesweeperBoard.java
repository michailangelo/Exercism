import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class MinesweeperBoard {
	private List<String> board;
	
	public MinesweeperBoard(List<String> list){
		board=list;
		
	}
	
	public List<String> withNumbers(){
		List<String> result = new ArrayList<>();
		if (board.isEmpty())
			return Collections.emptyList();
		if (board.equals(Collections.singletonList("")))
			return Collections.singletonList("");

		String boardString = "";

		for (String s : board) {
			boardString += s;
		}
		if (!boardString.contains("*"))
			return board;

		if (!boardString.contains(" "))
			return board;

		int columns = board.get(0).length();
		char[][] matrix = new char[board.size()][columns];
		for (int i = 0; i < board.size(); i++) {
			matrix[i] = board.get(i).toCharArray();

		}

		int counter = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] != '*') {
					for (int dx = (i > 0 ? -1 : 0); dx <= (i < matrix.length ? 1 : 0); ++dx) {
						for (int dy = (j > 0 ? -1 : 0); dy <= (j < matrix[i].length ? 1 : 0); ++dy) {
							if (dx != 0 || dy != 0) {
								if ((i + dx < matrix.length) && (j + dy < matrix[i].length)) {
									char a = matrix[i + dx][j + dy];
									if (a == '*') {
										counter++;
									}
								}

							}
						}
					}
					if (counter == 0)
						matrix[i][j] = ' ';
					else {
						matrix[i][j] = Character.forDigit(counter, 10);
					}

					counter = 0;
				}
			}

		}

		for (int i = 0; i < board.size(); i++) {
			result.add(new String(matrix[i]));
		}

		return result;
	}
	
	
}