package gameLogic;

import java.util.ArrayList;

/*
 * A Journal keeps track of a chess game with FEN notations, current board state and move history
 */
public class Journal {

	private String currentFen;
	private ArrayList<String> fens;
	private ArrayList<String> moveLog;

	private char[][] pieces;
	private boolean activeColor; // true for white ; false for black
	private boolean castlingK;
	private boolean castlingQ;
	private boolean castlingk;
	private boolean castlingq;
	private String enPassent; // enPassent opportunity square e.g. c6 or - for null
	private short halfmoveClock; // half moves since last capture or pawn advance
	private short fullmoveClock; // full move number: starts at 1, incremented after black's move

	public Journal() {
		currentFen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
		pieces = new char[8][8];
		fens = new ArrayList<String>();
		fens.add(currentFen);
		activeColor = true; //white = w
		castlingK = true;
		castlingQ = true;
		castlingk = true;
		castlingq = true;
		enPassent = "-";
		halfmoveClock = 0;
		fullmoveClock = 1;
		updateJournalFromFen(currentFen);

	}

	public Journal(String fen) {
		this();
		if (!updateViaFEN(fen))
			System.out.println("Invalid Fen notation. Made default board instead");
	}

	public boolean updateViaFEN(String fen) {
		// TODO
		return true;
	}

	public char getActiveColorFromFen(String fen) {
		return fen.charAt(fen.length() - 11);
	}

	public int getFullmoveNumberFromFen(String fen) {
		return Integer.parseInt(String.valueOf(currentFen.charAt(currentFen.length())));
	}

	public int getHalfmoveNumberFromFen() {
		return Integer.parseInt(String.valueOf(currentFen.charAt(currentFen.length() - 2)));
	}

	public String toString() {
		return currentFen;
		// TODO
	}

	public void updateJournalFromFen(String fen) {
		this.currentFen = fen;
		//fens.add(currentFen);
		// TODO moveLog not updated yet, hm

		short index = 0;
		short positionInRow = 0;
		short colomn = 0;

		while (colomn != 7 || positionInRow != 7) {
			char c = fen.charAt(index);
			switch (c) {
			case '/':
				colomn++;
				positionInRow = 0;
				break;
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
				for (int i = Integer.parseInt(String.valueOf(c)); i > 0; i--) {
					pieces[colomn][positionInRow++] = '-';
				}
				break;
			case 'r':
				pieces[colomn][positionInRow++] = 'r';
				break;
			case 'R':
				pieces[colomn][positionInRow++] = 'R';
				break;
			case 'n':
				pieces[colomn][positionInRow++] = 'n';
				break;
			case 'N':
				pieces[colomn][positionInRow++] = 'N';
				break;
			case 'b':
				pieces[colomn][positionInRow++] = 'b';
				break;
			case 'B':
				pieces[colomn][positionInRow++] = 'B';
				break;
			case 'q':
				pieces[colomn][positionInRow++] = 'q';
				break;
			case 'Q':
				pieces[colomn][positionInRow++] = 'Q';
				break;
			case 'k':
				pieces[colomn][positionInRow++] = 'k';
				break;
			case 'K':
				pieces[colomn][positionInRow++] = 'K';
				break;
			case 'p':
				pieces[colomn][positionInRow++] = 'p';
				break;
			case 'P':
				pieces[colomn][positionInRow++] = 'P';
				break;
			}
			index++;
		}

	}

	public String getCurrentFen() {
		return currentFen;
	}

	public void setCurrentFen(String currentFen) {
		this.currentFen = currentFen;
	}

	public ArrayList<String> getFens() {
		return fens;
	}

	public void setFens(ArrayList<String> fens) {
		this.fens = fens;
	}

	public ArrayList<String> getMoveLog() {
		return moveLog;
	}

	public void setMoveLog(ArrayList<String> moveLog) {
		this.moveLog = moveLog;
	}

	public char[][] getPieces() {
		char[][] returnedPieces = new char[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				returnedPieces[i][j] = pieces[i][j];
			}
		}
		return returnedPieces;
	}

	public void setPieces(char[][] pieces) {
		this.pieces = pieces;
	}

	public boolean getActiveColor() {
		return activeColor;
	}

	public void setActiveColor(boolean activeColor) {
		this.activeColor = activeColor;
	}

	public boolean isCastlingK() {
		return castlingK;
	}

	public void setCastlingK(boolean castlingK) {
		this.castlingK = castlingK;
	}

	public boolean isCastlingQ() {
		return castlingQ;
	}

	public void setCastlingQ(boolean castlingQ) {
		this.castlingQ = castlingQ;
	}

	public boolean isCastlingk() {
		return castlingk;
	}

	public void setCastlingk(boolean castlingk) {
		this.castlingk = castlingk;
	}

	public boolean isCastlingq() {
		return castlingq;
	}

	public void setCastlingq(boolean castlingq) {
		this.castlingq = castlingq;
	}

	public String getEnPassent() {
		return enPassent;
	}

	public void setEnPassent(String enPassent) {
		this.enPassent = enPassent;
	}

	public short getHalfmoveClock() {
		return halfmoveClock;
	}

	public void setHalfmoveClock(short halfmoveClock) {
		this.halfmoveClock = halfmoveClock;
	}

	public short getFullmoveClock() {
		return fullmoveClock;
	}

	public void setFullmoveClock(short fullmoveClock) {
		this.fullmoveClock = fullmoveClock;
	}

}
