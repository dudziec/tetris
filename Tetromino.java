

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;


public class Tetromino {
	private Point currentPosition;
	private Point pixelPosition;
	private ArrayList<Point> squaresTranspositions = new ArrayList<>();
	private ArrayList<Field> occupiedFields = new ArrayList<>();
	private Color color;
	private static int X = 0;
	private static int Y = 1;
	private boolean isFalling = false;
	private static int SQUARE_SIDE_IN_PIXELS = 20;
	private int[][] shapeCoordinates;
	
	public void setPosition(Point point)
	{
		currentPosition = new Point(point.x, point.y);
		setSquaresWithCoordinates();
		setPixelPosition(currentPosition);
	}
	
	public boolean isFalling() {
		return isFalling;
	}

	public void setFalling(boolean isFalling) {
		this.isFalling = isFalling;
	}

	public Point getPixelPosition() {
		return pixelPosition;
	}

	public void setPixelPosition(Point currentPosition) {
		this.pixelPosition = new Point(currentPosition.x * SQUARE_SIDE_IN_PIXELS, currentPosition.y * SQUARE_SIDE_IN_PIXELS);
	}

	public void setCurrentPosition(Point currentPosition) {
		this.currentPosition = currentPosition;
	}
		
	public Point getCurrentPosition() {
		return currentPosition;
	}

	public int[][] getShapeCoordinates() {
		return shapeCoordinates;
	}

	public void setShapeCoordinates(int[][] shapeCoordinates) {
		this.shapeCoordinates = shapeCoordinates;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public ArrayList<Point> getSquares() {
		return squaresTranspositions;
	}

	public void setSquaresWithCoordinates() {
		Point squareCoordinates;
		
		for(int i = 0; i < shapeCoordinates.length; i++)
		{
			squareCoordinates = new Point(shapeCoordinates[i][X], shapeCoordinates[i][Y]);
			squaresTranspositions.add(squareCoordinates);
		}
	}

	public void setOccupiedFields(ArrayList<Field> occupiedFields) {
		clearLastOccupiedFields();
		this.occupiedFields = occupiedFields;
		for(Field field: occupiedFields)
		{
			field.setOccupied(true);
			field.setColor(this.color);
		}
	}
	
	public void clearLastOccupiedFields()
	{
		for(Field field:occupiedFields)
		{
			field.setOccupied(false);
		}
	}
}
