import java.util.Random;

public class Sudoku {
	int[][] mat;
	int sudokuSize;
	int boxSize;

	Sudoku(int boxSize) {
		this.boxSize = boxSize;
		this.sudokuSize = boxSize * boxSize;

		this.mat = new int[this.sudokuSize][this.sudokuSize];
	}
 
	public void generateSudokuField() {
		for(int i = 0; i < this.sudokuSize; i++) {
			for(int j = 0; j < this.sudokuSize; j++) {
				this.mat[i][j] = ((i * this.boxSize + i / this.boxSize + j) % this.sudokuSize + 1);
			}
		}

		for (int i = 0; i < this.sudokuSize; i++) {
			Random rand = new Random();
			Random rand2 = new Random();
			ChangeTwoCells(rand.nextInt(this.sudokuSize) + 1, rand2.nextInt(this.sudokuSize) + 1);
		}   
	}
    
	private void ChangeTwoCells(int findValue1, int findValue2) {
		// Found from: https://www.youtube.com/watch?v=XD866K6VO8A
        
		int xParm1, yParm1, xParm2, yParm2;
		xParm1 = yParm1 = xParm2 = yParm2 = 0;
    
		for (int sudokuColumn = 0; sudokuColumn < this.sudokuSize; sudokuColumn += this.boxSize) {
			for (int sudokuRow = 0; sudokuRow < this.sudokuSize; sudokuRow += this.boxSize) {
                
				for (int boxRow = 0; boxRow < this.boxSize; boxRow++) {
					for (int boxColumn = 0; boxColumn < this.boxSize; boxColumn++) {
						if (this.mat[sudokuRow + boxRow][sudokuColumn + boxColumn] == findValue1) {
							xParm1 = sudokuRow + boxRow;
							yParm1 = sudokuColumn + boxColumn;
						}
						if (this.mat[sudokuRow + boxRow][sudokuColumn + boxColumn] == findValue2) {
							xParm2 = sudokuRow + boxRow;
							yParm2 = sudokuColumn + boxColumn;
						}
					}
				}
                
				this.mat[xParm1][yParm1] = findValue2;
				this.mat[xParm2][yParm2] = findValue1;
			}
		}
	}

	public void removeCellValuesRandomly() {
		Random toRemove = new Random();

		for(int i = 0; i < this.sudokuSize; i++) {
			for(int j = 0; j < this.sudokuSize; j++) {
				if(toRemove.nextBoolean()) {
					mat[i][j] = 0;
				}
			}
		}
	}
 
	public void printSudoku()
	{
		for (int i = 0; i < this.sudokuSize; i++) {
			for (int j = 0; j < this.sudokuSize; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}
}
