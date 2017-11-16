
public enum Direction {
	Left(new int[] {-1, 0}),
	Right(new int[] {1, 0}),
	Down(new int[] {0, 1});
	
	private int[] shift;
	
	private Direction(int[] shift)
	{
		this.shift = shift;
	}
	
	public int getX() {
		return shift[0];
	}
	
	public int getY() {
		return shift[1];
	}
	
}
