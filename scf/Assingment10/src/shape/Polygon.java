package shape;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent polygon
 * 
 * @created-on 02-03-2021
 * @author krishna.meghwal_meta
 */
public class Polygon extends shapeFactory {
	int side, size;
	double angle, height;
	static int INF = 10000;

	public Polygon(ShapeType type, Point p, int size, int side) {
		this.timestamp = new Timestamp(System.currentTimeMillis());
		this.origin = p;
		this.type = type;
		this.shapeId = (int) (Math.random() * 1000);
		this.side = side;
		this.size = size;
		this.angle = Math.toRadians(180 / this.size);
	}

	/**
	 * Method to calculate area of polygon
	 * 
	 * @return double
	 */
	@Override
	public double getArea() {
		double tangentAngle = Math.tan(angle);
		double area = (this.side * this.side * this.size) / 4 * tangentAngle;
		return area;
	}

	/**
	 * Method to calculate perimeter of polygon
	 * 
	 * @return double
	 */
	@Override
	public double getPerimeter() {
		return this.side * this.size;
	}

	/**
	 * Three colinear points p, q, r, the function checks if point q lies on
	 * line segment 'pr'
	 * 
	 * @param Point
	 * @param Point
	 * @param Point
	 * @return boolean
	 */
	private static boolean onSegment(Point p, Point q, Point r) {
		if (q.xCoordinate <= Math.max(p.xCoordinate, r.xCoordinate)
				&& q.xCoordinate >= Math.min(p.xCoordinate, r.xCoordinate)
				&& q.yCoordinate <= Math.max(p.yCoordinate, r.yCoordinate)
				&& q.yCoordinate >= Math.min(p.yCoordinate, r.yCoordinate)) {
			return true;
		}
		return false;
	}

	/**
	 * Method To find orientation of ordered triplet (p, q, r) The function
	 * returns 0 --> Colinear 1 --> Clockwise 2 --> Counterclockwise
	 * 
	 * @param Point
	 * @param Point
	 * @param Point
	 * @return int
	 */
	private static int orientation(Point p, Point q, Point r) {
		double val = (q.yCoordinate - p.yCoordinate)
				* (r.xCoordinate - q.xCoordinate)
				- (q.xCoordinate - p.xCoordinate)
				* (r.yCoordinate - q.yCoordinate);

		if (val == 0) {
			return 0;
		}
		return (val > 0) ? 1 : 2;
	}

	/**
	 * Method returns true if line segment 'p1q1' and 'p2q2' intersect
	 * 
	 * @param Point
	 * @param Point
	 * @param Point
	 * @param Point
	 * @param Point
	 * @return boolean
	 */
	static boolean doIntersect(Point p1, Point q1, Point p2, Point q2) {

		int orientation1 = orientation(p1, q1, p2);
		int orientation2 = orientation(p1, q1, q2);
		int orientation3 = orientation(p2, q2, p1);
		int orientation4 = orientation(p2, q2, q1);

		if (orientation1 != orientation2 && orientation3 != orientation4) {
			return true;
		}

		if (orientation1 == 0 && onSegment(p1, p2, q1)) {
			return true;
		}

		if (orientation2 == 0 && onSegment(p1, q2, q1)) {
			return true;
		}

		if (orientation3 == 0 && onSegment(p2, p1, q2)) {
			return true;
		}

		if (orientation4 == 0 && onSegment(p2, q1, q2)) {
			return true;
		}

		return false;
	}

	/**
	 * Method to get coordinates of polygon
	 * 
	 * @return List<Point>
	 */
	public List<Point> getCoordinatesList() {
		List<Point> listOfCordinates = new ArrayList<Point>();
		double angle = 2 * Math.PI / this.size;
		double radius = (this.side / 2) / Math.sin(this.angle);
		for (int i = 0; i < this.size; i++) {

			double x = origin.xCoordinate + radius * Math.cos(i * angle);
			double y = origin.yCoordinate + radius * Math.sin(i * angle);
			Point p = new Point(x, y);
			listOfCordinates.add(p);
		}
		return listOfCordinates;
	}

	/**
	 * Method to check if a point is enclosed inside polygon
	 * 
	 * @param Point
	 * @return boolean
	 */
	@Override
	public boolean isPointEnclosed(Point p) {
		List<Point> polygon = getCoordinatesList();
		Point extreme = new Point(INF, p.yCoordinate);

		int count = 0, i = 0;
		do {
			int next = (i + 1) % this.size;

			if (doIntersect(polygon.get(i), polygon.get(next), p, extreme)) {

				if (orientation(polygon.get(i), p, polygon.get(next)) == 0) {
					return onSegment(polygon.get(i), p, polygon.get(next));
				}

				count++;
			}
			i = next;
		} while (i != 0);

		return (count % 2 == 1);

	}

}
