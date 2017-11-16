import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
	public static final int FIELD_PIXEL_SIZE = 20;
	public static final int WIDTH = 8;
	public static final int HEIGHT = 18;
	private Dimension dimension = new Dimension(8, 18);
	private Dimension dimensionInPixels = new Dimension(dimension.width * FIELD_PIXEL_SIZE, dimension.height * FIELD_PIXEL_SIZE);
	public static final int PIXEL_WIDTH = WIDTH * FIELD_PIXEL_SIZE;
	public static final int PIXEL_HEIGHT = HEIGHT * FIELD_PIXEL_SIZE;
	private Tetromino currentTetromino;
	private int delayInMiliseconds = 300;
	private Timer timer = new Timer(delayInMiliseconds, this);
	private Field[][] fieldBoard = new Field[WIDTH][HEIGHT];
	private FieldBoardManager fieldBoardManager;
	
	private ArrayList<Tetromino> tetrominosOnTheGround = new ArrayList<>();
	
	public Board()
	{
		setFocusable(true);	
		addKeyListener(new TetrisKeyListener(this));
		setBorder(BorderFactory.createLineBorder(Color.black));
		setSize(PIXEL_WIDTH, PIXEL_HEIGHT);
	
		fieldBoardManager = new FieldBoardManager(fieldBoard);
		fieldBoardManager.initializeFieldBoard();
		
		newTetromino();
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		fieldBoardManager.setTetrominosOccupiedFields(currentTetromino);
		if(currentTetromino.isFalling())
		{
			moveTernominoDown();
			fieldBoardManager.printOccupiedFields();
		}
		else 
		{
			tetrominosOnTheGround.add(currentTetromino);
			newTetromino();
		}
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		fieldBoardManager.repaint(g);
	 }
	
	 private void newTetromino()
	 {
		 currentTetromino = TetrominoFactory.getTetromino();
		 currentTetromino.setPosition(new Point(4, 3));
		 currentTetromino.setFalling(true);
		 repaint();
	 }
	
	public Tetromino getCurrentTetromino() {
		return currentTetromino;
	}

	
	public void moveTernominoLeft()
	{
		moveTernomino(Direction.Left);
	}
	
	public void moveTernominoRight()
	{
		moveTernomino(Direction.Right);
	}
	
	public void moveTernominoDown()
	{
		moveTernomino(Direction.Down);
	}
	
	private void moveTernomino(Direction direction) {
//	TODO: Too long!!!
		Point newPosition = calculateNewPosition(direction);
		
		if(inBounds(newPosition))
		{
			if(isMoveDownPossible()) {
				currentTetromino.setPosition(newPosition);
				processIfOnTheGround(currentTetromino.getCurrentPosition());
			}
			else 
			{ 
				if(direction == Direction.Down)
				{
					currentTetromino.setFalling(false);
				}
			}
		}
	}
	
	private Point calculateNewPosition(Direction shiftDirection)
	{
		return new Point(currentTetromino.getCurrentPosition().x + shiftDirection.getX(), currentTetromino.getCurrentPosition().y + shiftDirection.getY());
	}
	
	private void processIfOnTheGround(Point point)
	{
		if(onTheGround(point))
		{
			currentTetromino.setFalling(false);
		}
	}
	
	private boolean inBounds(Point point)
	{
		if(point.x >=0 && point.x < Board.WIDTH && point.y < Board.HEIGHT)
		{
			return true;
		}
		
		return false;
	}
	
	
	public boolean isMoveDownPossible() {
		for(Point point: currentTetromino.getSquares())
		{
			
		}
		return true;
	}
	
	
	private boolean onTheGround(Point point) 
	{
		if(point.y == Board.HEIGHT - 1)
		{
			return true;
		}	
		return false;
	}
}
