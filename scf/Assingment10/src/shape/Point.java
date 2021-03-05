package shape;

/**
 * Class to represent a point in geometry
 * 
 * @created-on 02-03-2021
 * @author krishna.meghwal_meta
 */
public class Point {
	double xCoordinate, yCoordinate;

	public Point(double x, double y) {
		this.xCoordinate = x;
		this.yCoordinate = y;

	}

	@Override
	public String toString() {
		return "Point [xCoordinate=" + xCoordinate + ", yCoordinate="
				+ yCoordinate + "]";
	}

	/**
	 * Method that returns coordinates of a point
	 * 
	 * @return double[]
	 */
	public double[] getCoordinates() {
		double[] coordinates = { this.xCoordinate, this.yCoordinate };
		return coordinates;
	}

}
