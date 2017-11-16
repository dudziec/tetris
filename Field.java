import java.awt.Color;
import java.awt.Graphics;

public class Field {
	private int x;
	private int y;
	private Color color;
	private boolean isOccupied = false;
	private int size = 20;
	
	public void paint(Graphics g)
	{
		g.setColor(color);
		g.fillRect(x, y, size, size);
		g.setColor(color.darker());
		g.drawRect(x, y, size, size);
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isOccupied() {
		return isOccupied;
	}
	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
}
	
