import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TetrisKeyListener implements KeyListener {
	private Board tetrisBoard;
	
	public TetrisKeyListener(Board tetrisBoard) {
		this.tetrisBoard = tetrisBoard;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent key) {
		if(key.getKeyCode() == KeyEvent.VK_LEFT) {
			tetrisBoard.moveTernominoLeft();
		}
		
		if(key.getKeyCode() == KeyEvent.VK_RIGHT) {
			tetrisBoard.moveTernominoRight();
		}
		
		if(key.getKeyCode() == KeyEvent.VK_DOWN) {

		}
		
		if(key.getKeyCode() == KeyEvent.VK_A) {

		}
		
		if(key.getKeyCode() == KeyEvent.VK_D) {

		}
		tetrisBoard.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}
