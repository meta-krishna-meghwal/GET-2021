package screen;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import screen.Screen.SortType;
import shape.Point;
import shape.Shape;
import shape.shapeFactory;
import shape.Shape.ShapeType;

/** @author krishna.meghwal_meta */
public class ScreenTest {

	Screen sc;

	@Before
	public void before() {
		sc = new Screen();
		Point p1 = new Point(100, 100);
		Point p2 = new Point(200, 100);
		Point p3 = new Point(200, 100);
		List<Integer> param = new ArrayList<Integer>();
		List<Integer> param2 = new ArrayList<Integer>();
		param.add(5);
		param.add(3);
		param2.add(4);
		param2.add(5);
		param2.add(17);
		ShapeType type = ShapeType.POLYGON;
		ShapeType type2 = ShapeType.TRIANGLE;
		Shape polygon1 = shapeFactory.createShape(type, p1, param);
		Shape polygon2 = shapeFactory.createShape(type, p2, param);
		Shape triangle = shapeFactory.createShape(type2, p3, param2);

		sc.addObject(polygon1);
		sc.addObject(polygon2);
		sc.addObject(triangle);
	}

	@Test
	public void addObjectTestAndRemoveObjectTest() {

		Point p1 = new Point(100, 100);
		List<Integer> param = new ArrayList<Integer>();
		param.add(5);
		param.add(10);
		ShapeType type = ShapeType.POLYGON;
		Shape polygon = shapeFactory.createShape(type, p1, param);
		assertTrue(sc.addObject(polygon));
		assertTrue(sc.removeObject(polygon));
	}

	@Test
	public void isEnclosedTestPositive() {
		Point p = new Point(100, 100);
		assertEquals(1, sc.isEnclosed(p).size());
	}

	@Test
	public void sortAscendingTestArea() {
		SortType type = SortType.AREA;

		List<Shape> objects = sc.sortAscending(type);
		for (int i = 0; i < objects.size() - 1; i++) {
			boolean isTrue = objects.get(i).getArea() <= objects.get(i + 1)
					.getArea();

			assertTrue(isTrue);

		}

	}

	@Test
	public void sortAscendingTestPerimeter() {
		SortType type = SortType.PERIMETER;

		List<Shape> objects = sc.sortAscending(type);
		for (int i = 0; i < objects.size() - 1; i++) {
			boolean isTrue = objects.get(i).getPerimeter() <= objects
					.get(i + 1).getPerimeter();

			assertTrue(isTrue);

		}

	}

	@Test
	public void sortAscendingTestOriginDistance() {
		SortType type = SortType.ORIGIN_DISTANCE;

		List<Shape> objects = sc.sortAscending(type);
		for (int i = 0; i < objects.size() - 1; i++) {
			boolean isTrue = objects.get(i).originDistance() <= objects.get(
					i + 1).originDistance();

			assertTrue(isTrue);

		}

	}

	@Test
	public void sortAscendingTestTimestamp() {
		SortType type = SortType.TIMESTAMP;

		List<Shape> objects = sc.sortAscending(type);
		for (int i = 0; i < objects.size() - 1; i++) {
			int temp = objects.get(i).getTimestamp()
					.compareTo(objects.get(i + 1).getTimestamp());
			boolean isTrue;
			if (temp == 0 || temp < 0)
				isTrue = true;
			else
				isTrue = false;

			assertTrue(isTrue);

		}

	}

	@Test
	public void removeSpecificType() {
		ShapeType type = ShapeType.POLYGON;
		assertTrue(sc.removeSpecificType(type));
	}
}
