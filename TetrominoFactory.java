

public class TetrominoFactory {
	
	public static Tetromino getTetromino()
	{	
		Tetromino tetromino = new Tetromino();
		Shape shape = Shape.getRandom();
		
		tetromino.setColor(shape.getColor());
		tetromino.setShapeCoordinates(shape.getCoordinates());
		tetromino.setSquaresWithCoordinates();
		return tetromino;
	}
}
