package screen;

import java.util.ArrayList;
import java.util.List;

import shape.*;
import shape.Shape.ShapeType;

/**
 * Class to represent screen
 * 
 * @created-on 02-03-2021
 * @author krishna.meghwal_meta
 */
public class Screen {

	double XMAX = 720, YMAX = 1280;
	private static List<Shape> objects = new ArrayList<Shape>();

	public enum SortType {
		AREA, PERIMETER, TIMESTAMP, ORIGIN_DISTANCE
	}

	/**
	 * Method to add an object to the screen
	 * 
	 * @param Shape
	 * 
	 * @return boolean
	 */
	public boolean addObject(Shape shape) {

		objects.add(shape);

		return true;
	}

	/**
	 * Method to remove an object from the screen
	 * 
	 * @param Shape
	 * 
	 * @return boolean
	 */
	public boolean removeObject(Shape shape) {
		int i = 0;
		for (Shape s : objects) {
			Point p = shape.getOrigin();
			Point p1 = s.getOrigin();
			if (p1.getCoordinates()[0] == p.getCoordinates()[0]
					&& p1.getCoordinates()[1] == p.getCoordinates()[1]
					&& shape.getTimestamp() != s.getTimestamp()) {
				objects.remove(i);
				return true;

			}
			i++;

		}

		return false;

	}

	/**
	 * Method to remove all objects of specific type from the screen
	 * 
	 * @param ShapeType
	 * 
	 * @return int
	 */
	public boolean removeSpecificType(ShapeType type) {

		int count = 0;
		for (int i = 0; i < objects.size();) {
			Shape s = objects.get(i);
			if (s.getShapeType() == type) {
				objects.remove(i);
				count++;
			} else {
				i++;
			}

		}
		return true;
	}

	/**
	 * Method that sort objects according to origin distance *
	 * 
	 * @param int
	 * @param
	 **/
	private void sortOriginDistance(int i, int j) {
		if (objects.get(i).originDistance() > objects.get(j).originDistance()) {
			Shape temp = objects.get(i);
			objects.set(i, objects.get(j));
			objects.set(j, temp);

		}

	}

	/**
	 * Method that sort objects according to timestamp
	 * 
	 * @param int
	 * @param
	 * */
	private void sortTimestamp(int i, int j) {
		if (objects.get(i).getTimestamp()
				.compareTo(objects.get(j).getTimestamp()) > 0) {
			Shape temp = objects.get(i);
			objects.set(i, objects.get(j));
			objects.set(j, temp);

		}
	}

	/**
	 * Method that sort objects according to perimeter *
	 * 
	 * @param int
	 * @param
	 **/
	private void sortPerimeter(int i, int j) {
		if (objects.get(i).getPerimeter() > objects.get(j).getPerimeter()) {
			Shape temp = objects.get(i);
			objects.set(i, objects.get(j));
			objects.set(j, temp);

		}
	}

	/**
	 * Method that sort objects according to area *
	 * 
	 * @param int
	 * @param
	 **/
	private void sortArea(int i, int j) {

		if (objects.get(i).getArea() > objects.get(j).getArea()) {
			Shape temp = objects.get(i);
			objects.set(i, objects.get(j));
			objects.set(j, temp);

		}

	}

	/**
	 * Method that sort list of abjects according to type
	 * 
	 * @param SortType
	 * */
	public List<Shape> sortAscending(SortType type) {
		for (int i = 0; i < objects.size() - 1; i++) {
			for (int j = 0; j < objects.size() - i - 1; j++) {
				switch (type) {
				case AREA:
					sortArea(j, j + 1);
					break;
				case PERIMETER:
					sortPerimeter(j, j + 1);
					break;
				case TIMESTAMP:
					sortTimestamp(j, j + 1);
					break;
				case ORIGIN_DISTANCE:
					sortOriginDistance(j, j + 1);
					break;
				default:
					sortTimestamp(j, j + 1);

				}
			}
		}
		return objects;
	}

	/**
	 * Method to get list of objects enclosing a point
	 * 
	 * @param Point
	 * @return List<Shape>
	 */
	public List<Shape> isEnclosed(Point p) {
		List<Shape> list = new ArrayList<Shape>();

		for (Shape s : objects) {
			if (s.isPointEnclosed(p)) {
				list.add(s);
			}
		}
		return list;

	}

}
