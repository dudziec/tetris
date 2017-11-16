

import java.awt.Color;

public enum Shape {
	LineShape(new int[][] {{0, -3}, {0, -2}, {0, -1}, {0, 0}}, new Color(102, 102, 204)),
	LShape(new int[][] {{0, 0}, {1, -2}, {1, -1}, {1, 0}}, new Color(247, 197, 46)),
	MirroredLShape(new int[][] {{1, 0}, {0, -2}, {0, -1}, {0, 0}}, new Color(66, 229, 244)),
	TShape(new int[][] {{-1, -1}, {0, -1}, {1, -1}, {0, 0}}, new Color(247, 244, 46)),
	SquareShape(new int[][] {{0, 0}, {1, 0}, {0, -1}, {1, -1}}, new Color(130, 36, 114)),
	SShape(new int[][] {{0, -2}, {0, -1}, {-1, -1}, {-1, 0}}, new Color(46, 247, 127)),
	ZShape(new int[][] {{0, -2}, {0, -1}, {1, -1}, {1, 0}}, new Color(244, 66, 66));
	
	private int[][] coordinates;
	private Color color;
	
	private Shape(int[][] coordinates, Color color)
	{
		this.coordinates = coordinates;
		this.color = color;
	}

	public int[][] getCoordinates() {
		return coordinates;
	}

	public Color getColor() {
		return color;
	}
	
	public static Shape getRandom()
	{
		return values()[(int) (Math.random() * values().length)];
	}
	
}
