package gameLogic;

public class Game /* implements Rules */ {

	public static void main(String[] args) {
		Game g = new Game();
		g.displayToConsole();
	}
	
	private Journal journal; // a game has a journal or log
	private char[][] pieces;

	public Game() {
		journal = new Journal();
		pieces = journal.getPieces();
	}

	private boolean isCheck() {
		// TODO Auto-generated method stub
		return false;
	}

	public void displayToConsole() {

		System.out.println("                             ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println((journal.getActiveColor() ? "  " : "=>") + "+-A--B--C--D--E--F--G--H-+     Turn: "
				+ journal.getFullmoveClock());

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					System.out.print(i + " |");
				} else if (j == 9) {
					System.out.print("| " + i);
				} else {

					switch (pieces[i][j-1]) {

					case '-':
						if ((i + j) % 2 == 0) {
							System.out.print(":::");
						} else {
							System.out.print("   ");
						}
						break;
					case 'p':
						System.out.print("[p]");
						break;
					case 'P':
						System.out.print("<P>");
						break;
					case 'r':
						System.out.print("[r]");
						break;
					case 'R':
						System.out.print("<R>");
						break;
					case 'n':
						System.out.print("[n]");
						break;
					case 'N':
						System.out.print("<N>");
						break;
					case 'b':
						System.out.print("[b]");
						break;
					case 'B':
						System.out.print("<B>");
						break;
					case 'k':
						System.out.print("[k]");
						break;
					case 'K':
						System.out.print("<K>");
						break;
					case 'q':
						System.out.print("[q]");
						break;
					case 'Q':
						System.out.print("<Q>");
						break;
					default:
						System.out.print("X"+pieces[i-1][j-1]+"X");
					}

				}

			}
			System.out.println("");
		}
		System.out.println((journal.getActiveColor() ? "=>" : "  ") + "+-A--B--C--D--E--F--G--H-+  "
				+ (isCheck() ? "   Check!" : "   "));
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

}
