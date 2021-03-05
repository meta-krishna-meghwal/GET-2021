package shape;

import java.sql.Timestamp;

/**
 * Class to represent rectangle
 * 
 * @created-on 02-03-2021
 * @author krishna.meghwal_meta
 */
public class Rectangle implements Shape {
	int length, breadth;
	Point topRight;
	Point origin;
	int shapeId;
	Timestamp timestamp;
	ShapeType type;

	public Rectangle(ShapeType type, Point p, Integer length, Integer breadth) {
		this.timestamp = new Timestamp(System.currentTimeMillis());
		this.origin = p;
		this.length = length;
		this.type = type;
		this.breadth = breadth;
		this.shapeId = (int) (Math.random() * 1000);
		this.topRight = new Point(this.origin.xCoordinate + this.length,
				this.origin.yCoordinate + this.breadth);

	}

	/**
	 * Method to calculate area of rectangle
	 * 
	 * @return double
	 */
	@Override
	public double getArea() {
		double area = this.breadth * this.length;
		return area;
	}

	/**
	 * Method to calculate perimeter of rectangle
	 * 
	 * @return double
	 */
	@Override
	public double getPerimeter() {

		return 2 * (this.length + this.breadth);
	}

	/**
	 * Method to check if a point is enclosed inside rectangle
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
