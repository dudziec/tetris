import javax.swing.JFrame;

public class Tetris extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int FRAME_WIDTH = 300;
	public static final int FRAME_HEIGHT = 400;
	private Board board;
	
	public Tetris()
	{
		board = new Board();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		add(board);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Tetris");
	}

	public static void main(String[] args) {
		new Tetris();
	}

}
