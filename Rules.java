package gameLogic;

/*
 * Might not use this as an interface....
 */

public interface Rules {

	/**
	 * Need to be able to move 
	 * @param squares
	 * @param desiredMove
	 * @return validity
	 */
	boolean move(char[][] squares, String desiredMove);
	
	/**
	 * Need to check if check
	 * @param squares
	 * @return if check or not boolean
	 */
	boolean isCheck(char[][] squares);
	
	/**
	 * Need to update a journal
	 * @param journal
	 * @param squares
	 * @return whether it updated or not
	 */
	boolean updateJournal(Journal journal, char[][] squares);
	
}
