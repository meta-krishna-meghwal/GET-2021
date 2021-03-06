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

	double getArea();

	double getPerimeter();

	ShapeType getShapeType();

	Point getOrigin();

	double originDistance();

	boolean isPointEnclosed(Point p);

	Timestamp getTimestamp();
}
