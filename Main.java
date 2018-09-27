public class Main {
	public static void main(String[] args) {
		int boxSize = 2;

		if (args.length == 1) {
			try {
				boxSize = Integer.parseInt(args[0]);
			}
			catch (Exception e) {
				System.out.println("The additional value must be a number");
				return;
			}
		}

		if (boxSize < 2) {
			System.out.println("The sudoku must have at least 4 columns/rows");
			return;
		}

		Sudoku sudoku = new Sudoku(boxSize);
		sudoku.generateSudokuField();
		sudoku.removeCellValuesRandomly();
		sudoku.printSudoku();
	}
}
