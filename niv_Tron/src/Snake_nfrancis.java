// Niven Francis
// AP Computer Science
// Mr. Balanda
// 12/19/13
// TRON

import java.awt.event.KeyEvent;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import java.awt.event.KeyAdapter;

public class Snake_nfrancis extends JFrame {
	private static final long serialVersionUID = 1L;
	public static int snakeHeadX = 50;
	public static int snakeHeadY = 10;
	public int nextX = 0;
	public int nextY = 0;
	public static int snakeHead2X = 50;
	public static int snakeHead2Y = 90;
	public int next2X = 0;
	public int next2Y = 0;
	public static boolean gameOver = false;
	public boolean inGame = true;
	public static boolean up = false;
	public static boolean down = false;
	public static boolean left = false;
	public static boolean right = false;
	public static boolean up2 = false;
	public static boolean down2 = false;
	public static boolean left2 = false;
	public static boolean right2 = false;
	public static boolean pause = false;
	public static int score1 = 0;
	public static int score2 = 0;
	public boolean start = false;

	public static void main(String[] args) {
		new Snake_nfrancis();
	}

	private Board_nfrancis board;

	public Snake_nfrancis() {
		super("TRON");setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		this.board = new Board_nfrancis();
		add(board, BorderLayout.CENTER);
		nextX = 0;
		nextY = 1;
		down = false;
		up = false;
		right = true;
		next2X = 0;
		next2Y = -1;
		down2 = false;
		up2 = false;
		left2 = true;
		start = true;
		addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
				
				int key = e.getKeyCode();
				// When user presses W or UP
				if ((key == KeyEvent.VK_W) && (!down)) {
					nextX = -1;
					nextY = 0;
					up = true;
					right = false;
					left = false;
					//System.out.println("W");
				} else if ((key == KeyEvent.VK_UP) && (!down2)) {
					next2X = -1;
					next2Y = 0;
					up2 = true;
					right2 = false;
					left2 = false;
					//System.out.println("UP");
				}

				// When user presses S or DOWN
				if ((key == KeyEvent.VK_S) && (!up)) {
					nextX = 1;
					nextY = 0;
					down = true;
					right = false;
					left = false;
					//System.out.println("S");
				} else if ((key == KeyEvent.VK_DOWN) && (!up2)) {
					next2X = 1;
					next2Y = 0;
					down2 = true;
					right2 = false;
					left2 = false;
					//System.out.println("DOWN");
				}

				// When user presses A or LEFT
				if ((key == KeyEvent.VK_A) && (!right)) {
					nextX = 0;
					nextY = -1;
					down = false;
					up = false;
					left = true;
					//System.out.println("A");
				} else if ((key == KeyEvent.VK_LEFT) && (!right2)) {
					next2X = 0;
					next2Y = -1;
					down2 = false;
					up2 = false;
					left2 = true;
					//System.out.println("LEFT");
				}

				// When user presses D or RIGHT
				if ((key == KeyEvent.VK_D) && (!left)) {
					nextX = 0;
					nextY = 1;
					down = false;
					up = false;
					right = true;
					//System.out.println("D");
				} else if ((key == KeyEvent.VK_RIGHT) && (!left2)) {
					next2X = 0;
					next2Y = 1;
					down2 = false;
					up2 = false;
					right2 = true;
					//System.out.println("RIGHT");
				}
			}
		});
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		snakeUpdate();
	}

	public void snakeUpdate() {
		while (!gameOver) {
			try {
				Thread.sleep(75);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (!gameOver) {
				Board_nfrancis.grid[snakeHeadY + nextY][snakeHeadX + nextX] = 2;
				Board_nfrancis.grid[snakeHead2Y + next2Y][snakeHead2X + next2X] = 3;
				board.repaint();
				snakeHeadX = snakeHeadX + nextX;
				snakeHeadY = snakeHeadY + nextY;
				snakeHead2X = snakeHead2X + next2X;
				snakeHead2Y = snakeHead2Y + next2Y;
			}
			
			if ((snakeHeadX + nextX < 0 || snakeHeadX + nextX > 99
					|| snakeHeadY + nextY < 0 || snakeHeadY + nextY > 99)
					&& (!gameOver)) {
				System.out.println("RED WINS!");
				score2 += 1;
				endGame();
			}
			if ((snakeHead2X + next2X < 0 || snakeHead2X + next2X > 99
					|| snakeHead2Y + next2Y < 0 || snakeHead2Y + next2Y > 99)
					&& (!gameOver)) {
				System.out.println("BLUE WINS!");
				score1 += 1;
				endGame();
			}
			if (start && Board_nfrancis.grid[snakeHeadY+nextY][snakeHeadX+nextX] != 0) {
				System.out.println("RED WINS!");
				score2 += 1;
				endGame();
			}
			if (start && Board_nfrancis.grid[snakeHead2Y+next2Y][snakeHead2X+next2X] != 0) {
				System.out.println("BLUE WINS!");
				score1 += 1;
				endGame();
			}
		}
	}
	public void restart() {
		snakeHeadX = 50;
		snakeHeadY = 10;
		snakeHead2X = 50;
		snakeHead2Y = 90;
		nextX = 0;
		nextY = 1;
		down = false;
		up = false;
		right = true;
		next2X = 0;
		next2Y = -1;
		down2 = false;
		up2 = false;
		left2 = true;
		System.out.println("Blue's score: " + score1 + ". Red's score: " + score2 + ".");
		gameOver = false;
		start = true;
		snakeUpdate();
	}
	public void endGame() {
		gameOver = true;
		for (int x = 1; x < 100; x++) {
			for (int y = 0; y < 100; y++) {
				board.grid[x][y] = 0;
			}
		}
		board.repaint();
		restart();
	}
}