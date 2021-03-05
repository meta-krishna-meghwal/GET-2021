package shape;

import java.sql.Timestamp;
import java.util.List;

/**
 * CLass to create object of specific type
 * 
 * @created-on 02-03-2021
 * @author krishna.meghwal_meta
 */
public abstract class shapeFactory implements Shape {

	Point origin;
	int shapeId;
	Timestamp timestamp;
	ShapeType type;

	/**
	 * Method to create a shape according to its type
	 * 
	 * @param ShapeType
	 *            type: type of shape
	 * @param Point
	 *            p: origin point of the shape
	 * @param List<Integer>
	 *             param: list of sides
	 * @return Shape : object of specific type
	 */
	public static Shape createShape(ShapeType type, Point p, List<Integer> param) {
		switch (type) {
		case TRIANGLE:
			Shape triangle = new Triangle(type, p, param.get(0), param.get(1));
			return triangle;

		case SQUARE:
			Shape square = new Square(type, p, param.get(0));
			return square;

		case CIRCLE:
			Shape circle = new Circle(type, p, param.get(0));
			return circle;
		case RECTANGLE:
			Shape rectangle = new Rectangle(type, p, param.get(0), param.get(1));
			return rectangle;
		case POLYGON:
			Shape polygon = new Polygon(type, p, param.get(0), param.get(1));
			return polygon;

		default:
			System.out.println("Shape not found");
			return null;

		}

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
