package userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;

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
		// setLayout(new GridLayout(10,10));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(1500, 1500);

		JPanel center = new JPanel();
		center.setBackground(Color.PINK);
		

		JButton[][] chessCells = new JButton[8][8];
		JButton currentCell;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {

				currentCell = chessCells[i][j] = new JButton();
				//currentCell.setVisible(true); ??
				center.add(currentCell);
				if ((i + j) % 2 == 0) {
					//System.out.println("Set white!");
					currentCell.setBackground(Color.PINK);
				} else {
					//System.out.println("Set black!");
					currentCell.setBackground(Color.BLACK);
				}
				try { // used for images, will add later
					Image img = ImageIO.read(new File("pawn.png"));
					currentCell.setIcon(new ImageIcon(img)); //image icon
				} catch (Exception e) {
					System.out.println("Did not place icon image....");
				}
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

}
