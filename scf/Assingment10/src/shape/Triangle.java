package shape;

import java.sql.Timestamp;

/**
 * Class to represent triangle
 * 
 * @created-on 02-03-2021
 * @author krishna.meghwal_meta
 */

public class Triangle extends shapeFactory {
	int base, height;
	Point secondPoint, thirdPoint;

	public Triangle(ShapeType type, Point p, Integer base, Integer height) {
		this.timestamp = new Timestamp(System.currentTimeMillis());
		this.origin = p;
		this.height = height;
		this.base = base;
		this.type = type;
		this.shapeId = (int) (Math.random() * 1000);
		this.secondPoint = new Point(this.origin.xCoordinate + this.base,
				this.origin.yCoordinate);
		this.thirdPoint = new Point(this.origin.xCoordinate,
				this.origin.yCoordinate + this.height);

	}

	/**
	 * Method to calculate area of triangle
	 * 
	 * @return double
	 */

	@Override
	public double getArea() {
		return 0.5 * this.base * this.height;
	}

	/**
	 * Method to calculate perimeter of triangle
	 * 
	 * @return double
	 */
	@Override
	public double getPerimeter() {
		return this.base + this.height
				+ Math.sqrt(this.base * this.base + this.height * this.height);
	}

	/**
	 * Method to check if a point is enclosed inside triangle
	 * 
	 * @param Point
	 * @return boolean
	 */
	@Override
	public boolean isPointEnclosed(Point p) {
		Point p1 = origin;
		Point p2 = secondPoint;
		Point p3 = thirdPoint;

		double d1 = sign(p, p1, p2), d2 = sign(p, p2, p3), d3 = sign(p, p3, p1);

		boolean has_neg = (d1 < 0) || (d2 < 0) || (d3 < 0);
		boolean has_pos = (d1 > 0) || (d2 > 0) || (d3 > 0);

		return !(has_neg && has_pos);
	}

	private double sign(Point p1, Point p2, Point p3) {
		return (p1.xCoordinate - p3.xCoordinate)
				* (p2.yCoordinate - p3.yCoordinate)
				- (p2.xCoordinate - p3.xCoordinate)
				* (p1.yCoordinate - p3.yCoordinate);
	}
}
