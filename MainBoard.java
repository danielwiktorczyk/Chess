package userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gameLogic.Journal;

public class MainBoard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static void updateTiles(Journal fen, JButton[][] cells) {
		
	}
	
	
	public MainBoard() {
		super("Chess!");
		String x = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1"; //Test Fen
		// setLayout(new GridLayout(10,10));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(1500, 1500);

		JPanel center = new JPanel();
		center.setBackground(Color.PINK);
		

		JButton[][] chessCells = new JButton[8][8];
		JButton currentCell;
		String[][] pieces = placePieces(Read(x));
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {

				currentCell = chessCells[i][j] = new JButton();
				//currentCell.setVisible(true); ??
				center.add(currentCell);
				if ((i + j) % 2 == 0) {
					//System.out.println("Set white!");
					currentCell.setBackground(Color.WHITE);
				} else {
					//System.out.println("Set black!");
					currentCell.setBackground(Color.PINK);
				}
				//REPLACE WITH SWITCH
				//
				//
				//
			if (pieces[i][j].equals("p"))
				try { // used for images, will add later
					Image img = ImageIO.read(new File("BlackPawn.png"));
					currentCell.setIcon(new ImageIcon(img)); //image icon
				} catch (Exception e) {
					System.out.println("Did not place icon image....");
				}
			
			if (pieces[i][j].equals("r"))
				try { // used for images, will add later
					Image img = ImageIO.read(new File("BlackRook.png"));
					currentCell.setIcon(new ImageIcon(img)); //image icon
				} catch (Exception e) {
					System.out.println("Did not place icon image....");
				} 
			
			
			if (pieces[i][j].equals("n"))
				try { // used for images, will add later
					Image img = ImageIO.read(new File("BlackKnight.png"));
					currentCell.setIcon(new ImageIcon(img)); //image icon
				} catch (Exception e) {
					System.out.println("Did not place icon image....");
				} 
			
			if (pieces[i][j].equals("b"))
				try { // used for images, will add later
					Image img = ImageIO.read(new File("BlackBishop.png"));
					currentCell.setIcon(new ImageIcon(img)); //image icon
				} catch (Exception e) {
					System.out.println("Did not place icon image....");
				} 
			if (pieces[i][j].equals("q"))
				try { // used for images, will add later
					Image img = ImageIO.read(new File("BlackQueen.png"));
					currentCell.setIcon(new ImageIcon(img)); //image icon
				} catch (Exception e) {
					System.out.println("Did not place icon image....");
				} 
			if (pieces[i][j].equals("k"))
				try { // used for images, will add later
					Image img = ImageIO.read(new File("BlackKing.png"));
					currentCell.setIcon(new ImageIcon(img)); //image icon
				} catch (Exception e) {
					System.out.println("Did not place icon image....");
				} 
			
			
			
			
			if (pieces[i][j].equals("P"))
				try { // used for images, will add later
					Image img = ImageIO.read(new File("WhitePawn.png"));
					currentCell.setIcon(new ImageIcon(img)); //image icon
				} catch (Exception e) {
					System.out.println("Did not place icon image....");
				}
			
			if (pieces[i][j].equals("R"))
				try { // used for images, will add later
					Image img = ImageIO.read(new File("WhiteRook.png"));
					currentCell.setIcon(new ImageIcon(img)); //image icon
				} catch (Exception e) {
					System.out.println("Did not place icon image....");
				} 
			
			
			if (pieces[i][j].equals("N"))
				try { // used for images, will add later
					Image img = ImageIO.read(new File("WhiteKnight.png"));
					currentCell.setIcon(new ImageIcon(img)); //image icon
				} catch (Exception e) {
					System.out.println("Did not place icon image....");
				} 
			
			if (pieces[i][j].equals("B"))
				try { // used for images, will add later
					Image img = ImageIO.read(new File("WhiteBishop.png"));
					currentCell.setIcon(new ImageIcon(img)); //image icon
				} catch (Exception e) {
					System.out.println("Did not place icon image....");
				} 
			if (pieces[i][j].equals("Q"))
				try { // used for images, will add later
					Image img = ImageIO.read(new File("WhiteQueen.png"));
					currentCell.setIcon(new ImageIcon(img)); //image icon
				} catch (Exception e) {
					System.out.println("Did not place icon image....");
				} 
			if (pieces[i][j].equals("K"))
				try { // used for images, will add later
					Image img = ImageIO.read(new File("WhiteKing.png"));
					currentCell.setIcon(new ImageIcon(img)); //image icon
				} catch (Exception e) {
					System.out.println("Did not place icon image....");
				} 
			
			//
			//
			//
			}
		}
		
	

		
//		JButton b = new JButton();
//		b.setBackground(Color.CYAN);
//		
//		try {
//			Image img = ImageIO.read(new File("pawn.png"));
//			b.setIcon(new ImageIcon(img)); //image icon
//		} catch (Exception e) {
//			System.out.println("Did not place icon image....");
//		}
//		add(b, BorderLayout.CENTER);
		
		
		add(center, BorderLayout.CENTER);
		//add(new JButton("HI!"), BorderLayout.NORTH);
		//add(new JButton("HI!"), BorderLayout.SOUTH);
		//add(new JButton("HI!"), BorderLayout.EAST);
		//add(new JButton("HI!"), BorderLayout.NORTH);
		center.setVisible(true);
		center.setLayout(new GridLayout(8, 8));
		//center.setBackground(Color.GREEN);
		
		setVisible(true); // must be at end

	}
	public static String[] Read(String x) {
		StringTokenizer sb = new StringTokenizer(x, " ");
		String fen = sb.nextToken();
		StringTokenizer sb2 = new StringTokenizer(fen, "/");
		String[] positions = new String[sb2.countTokens()];
		int count = 0;
		while (sb2.hasMoreTokens()) {
			positions[count] = sb2.nextToken();
			//System.out.println(positions[count]);
			count++;
		}
		return positions;
	}
	public static String[][] placePieces(String[] positions) {
		String[][] pieces = new String[8][8];
		for (int i=0; i<8; i++) {
			int j=0;
			int length= positions[i].length();
			for (int k=0; k<length;k++) {
				if (Character.isDigit(positions[i].charAt(k))==true) {
				//	System.out.println("made it" + Character.toString(positions[i].charAt(k)));
					for(int z=0; z<Character.getNumericValue(positions[i].charAt(k)); z++){
						pieces[i][j] = "e";
						j++;
					}
					continue;
				}
				else {
				pieces[i][j] = Character.toString(positions[i].charAt(k));
				}
				j++;
			}
		}
		return pieces;
	}

}
