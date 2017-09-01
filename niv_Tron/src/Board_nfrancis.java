// Niven Francis
// AP Computer Science
// Mr. Balanda
// 12/19/13
// TRON

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board_nfrancis extends JPanel {
	private static final long serialVersionUID = 1L;
	public static final int SIZE = 5;
	public static int[][] grid = new int[100][100];

	private BufferedImage image;
	public Board_nfrancis() {
		setPreferredSize(new Dimension(200 * SIZE, 100 * SIZE));
		setBackground(Color.BLACK);
		try {                
	          image = ImageIO.read(new File("tronlogo.jpg"));
	       } catch (IOException ex) {
	       }
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 500, 0, null);
		g.setColor(Color.CYAN);
		g.drawRect(0, 0, 500 - 1, getHeight() - 1);
		g.drawString("By Niven", 595, 150);
		g.drawString("BLUE", 550, 250);
		g.drawString("RED", 650, 250);
		g.drawString("" + Snake_nfrancis.score1, 550, 265);
		g.drawString("" + Snake_nfrancis.score2, 650, 265);
		for (int x = 1; x < 100; x++) {
			for (int y = 0; y <100; y++) {
				drawTile(x*SIZE,y*SIZE,grid[x][y],g);
			}
		}
	}

	private void drawTile(int x, int y, int type, Graphics g) {
		switch (type) {
		case 1:
			g.setColor(Color.GREEN);
			g.fillRect(x, y, SIZE, SIZE);
			break;
		case 2:
			g.setColor(Color.BLUE);
			g.fillRect(x, y, SIZE, SIZE);
			break;
		case 3:
			g.setColor(Color.RED);
			g.fillRect(x, y, SIZE, SIZE);
			break;
		}
	}
}