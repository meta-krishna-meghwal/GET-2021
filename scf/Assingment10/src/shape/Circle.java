package shape;

import java.sql.Timestamp;
/**
 * Class to represent circle
 * 
 * @created-on 02-03-2021
 * @author krishna.meghwal_meta
 */
public class Circle extends shapeFactory {
	int radius;

	public Circle(ShapeType type, Point p, Integer radius) {
		this.timestamp = new Timestamp(System.currentTimeMillis());
		this.origin = p;
		this.radius = radius;
		this.type = type;
		this.shapeId = (int) (Math.random() * 1000);

	}

	/**
	 * Method to calculate area of circle
	 * 
	 * @return double
	 */
	@Override
	public double getArea() {
		double area = (Math.PI * this.radius * this.radius);
		return area;
	}

	/**
	 * Method to calculate perimeter of circle
	 * 
	 * @return double
	 */
	@Override
	public double getPerimeter() {
		double parameter = (2 * Math.PI * this.radius);
		return parameter;
	}

	/**
	 * Method to check if a point is enclosed inside circle
	 * 
	 * @param Point
	 * @return boolean
	 */
	@Override
	public boolean isPointEnclosed(Point p) {
		Point p1 = this.getOrigin();
		double d = Math.sqrt(Math.pow(p.xCoordinate - p1.xCoordinate, 2)
				+ Math.pow(p.yCoordinate - p1.yCoordinate, 2));

		if (d <= this.radius) {
			return true;
		}

		return false;
	}

}
