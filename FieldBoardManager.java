import java.awt.Graphics;
import java.util.ArrayList;

public class FieldBoardManager {
	private Field[][] fieldboard;
	
	public FieldBoardManager(Field[][] fieldboard) {
		super();
		this.fieldboard = fieldboard;
	}

	public void initializeFieldBoard()
	{
		
		for(int i = 0; i < Board.WIDTH; i++)
		{
			for(int j = 0; j < Board.HEIGHT; j++)
			{
				fieldboard[i][j] = new Field();
				fieldboard[i][j].setOccupied(false);
				fieldboard[i][j].setX(i * Board.FIELD_PIXEL_SIZE);
				fieldboard[i][j].setY(j * Board.FIELD_PIXEL_SIZE);
			}
		}
	}
	
	public void clearFields()
	{
		for(int i = 0; i < Board.WIDTH; i++)
		{
			for(int j = 0; j < Board.HEIGHT; j++)
			{
				fieldboard[i][j].setOccupied(false);
			}
		}
	}
		
	
	public void setTetrominosOccupiedFields(Tetromino currentTetromino)
	{
		ArrayList<Field> occupiedFields = new ArrayList<>();
		
		for(int i = 0; i < currentTetromino.getShapeCoordinates().length; i++)
		{
			int x = currentTetromino.getCurrentPosition().x + currentTetromino.getShapeCoordinates()[i][0];
			int y = currentTetromino.getCurrentPosition().y + currentTetromino.getShapeCoordinates()[i][1];
			
			if(fieldboard[x][y].isOccupied())
			{
				currentTetromino.setFalling(false);
				return;
			}
			occupiedFields.add(fieldboard[x][y]);
		}
		
		currentTetromino.setOccupiedFields(occupiedFields);
	}

	public void printOccupiedFields()
	{
		System.out.println("Occupied fields: !!!!!!");
		for(int i = 0; i < Board.WIDTH; i++)
		{
			for(int j = 0; j < Board.HEIGHT; j++)
			{
				if(fieldboard[i][j].isOccupied())
				{
					System.out.println("Occupied field:" + i + " " + j);
				}
			}
		}
	}
	
	public void repaint(Graphics g)
	{
		for(int i = 0; i < Board.WIDTH; i++)
		{
			for(int j = 0; j < Board.HEIGHT; j++)
			{
				if(fieldboard[i][j].isOccupied())
				{
					fieldboard[i][j].paint(g);
				}
			}
	}
	}
}


