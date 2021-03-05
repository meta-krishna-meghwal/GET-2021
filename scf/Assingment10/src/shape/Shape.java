package shape;

import java.sql.Timestamp;

/**
 * Interface that provides structure to create class of specific shape
 * 
 * @created-on 02-03-2021
 * @author krishna.meghwal_meta
 */
public interface Shape {

	public enum ShapeType {
		CIRCLE, TRIANGLE, SQUARE, RECTANGLE, POLYGON
	}

	/**
	 * Method that returns area of the shape
	 * 
	 * @return double
	 */
	double getArea();

	/**
	 * Method that returns perimeter of the shape
	 * 
	 * @return double
	 */
	double getPerimeter();

	ShapeType getShapeType();

	Point getOrigin();

	double originDistance();

	/**
	 * Method that check if a point is inside the shape
	 * 
	 * @param Point
	 * @return boolean
	 */
	boolean isPointEnclosed(Point p);

	Timestamp getTimestamp();
}
