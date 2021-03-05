package shape;

import java.sql.Timestamp;

/**
 * Class to represent square
 * 
 * @created-on 02-03-2021
 * @author krishna.meghwal_meta
 */

public class Square implements Shape {
	int side;
	Point topRight;
	Point origin;
	int shapeId;
	Timestamp timestamp;
	ShapeType type;

	public Square(ShapeType type, Point p, Integer side) {
		this.timestamp = new Timestamp(System.currentTimeMillis());
		this.origin = p;
		this.side = side;
		this.type = type;
		this.shapeId = (int) (Math.random() * 1000);
		this.topRight = new Point(this.origin.xCoordinate + this.side,
				this.origin.yCoordinate + this.side);
	}

	/**
	 * Method to calculate area of square
	 * 
	 * @return double
	 */
	@Override
	public double getArea() {
		return this.side * this.side;
	}

	/**
	 * Method to calculate perimeter of square
	 * 
	 * @return double
	 */
	@Override
	public double getPerimeter() {
		return 4 * this.side;
	}

	/**
	 * Method to check if a point is enclosed inside Square
	 * 
	 * @param Point
	 * @return boolean
	 */
	@Override
	public boolean isPointEnclosed(Point p) {
		double x = p.xCoordinate, y = p.yCoordinate;

		if (x > topRight.xCoordinate && x < this.origin.xCoordinate
				&& y > topRight.yCoordinate && y < this.origin.yCoordinate)
			return true;

		return false;
	}

	/**
	 * Method to the origin point
	 * 
	 * @return Point
	 */
	public Point getOrigin() {
		return this.origin;
	}

	/**
	 * Method to get the Id of the shape
	 * 
	 * @return int
	 */
	public int getShapeID() {
		return this.shapeId;
	}

	/**
	 * Method that returns ShapeType of shape
	 * 
	 * @return ShapeType
	 */
	public ShapeType getShapeType() {
		return this.type;
	}

	/**
	 * Method that returns distance of origin point from (0,0)
	 * 
	 * @return double
	 */
	public double originDistance() {
		return Math.sqrt(Math.pow(origin.xCoordinate, 2)
				+ Math.pow(origin.yCoordinate, 2));
	}

	/**
	 * Method for getting timestamp when the shape was created
	 * 
	 * @return Timestamp
	 */
	public Timestamp getTimestamp() {
		return this.timestamp;
	}

}
