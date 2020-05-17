package model;

public class Coordinates
{
	private int x;
	private int y;
	/**
	 * Coordinates for the Nodes.
	 *
	 * @param coordinateX X value.
	 * @param coordinateY Y Value.
	 */

	public Coordinates (int coordinateX, int coordinateY)
	{
		this.x = coordinateX;
		this.y = coordinateY;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}
}
