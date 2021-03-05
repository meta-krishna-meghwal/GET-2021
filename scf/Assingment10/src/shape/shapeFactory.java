package shape;

import java.util.List;

import shape.Shape.ShapeType;

/**
 * CLass to create object of specific type
 * 
 * @created-on 02-03-2021
 * @author krishna.meghwal_meta
 */
public abstract class shapeFactory {

	/**
	 * Method to create a shape according to its type
	 * 
	 * @param ShapeType
	 *            type: type of shape
	 * @param Point
	 *            p: origin point of the shape
	 * @param List
	 *            <Integer> param: list of sides
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

}
