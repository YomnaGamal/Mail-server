package eg.edu.alexu.csd.datastructure.maze.cs12_cs57_cs62;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import eg.edu.alexu.csd.datastructure.linkedList.cs12_cs62.SLinkedList;
import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;
import eg.edu.alexu.csd.datastructure.queue.cs57_cs12_cs62.LinkedBased;
import eg.edu.alexu.csd.datastructure.stack.cs12.Stack;

/**
 * .
 *
 * @author LENOVO
 *
 */
public class MazeSolver implements IMazeSolver {

	/**
	 * . X dimension of the map
	 */
	private int n;
	/**
	 * . Y dimension of the map
	 */
	private int m;
	/**
	 * . Map
	 */
	private char[][] map;
	/**
	 * . Check visited points
	 */
	private boolean[][] visited;
	/**
	 * . Stack ADT for DFS
	 */
	Stack s;
	/**
	 * . Queue ADT for BFS
	 */
	LinkedBased q;

	@Override
	public int[][] solveBFS(final File maze) {
		// TODO Auto-generated method stub
		try {
			readFile(maze);
			q = new LinkedBased();
			// SLinkedList route = new SLinkedList();
			Point p = new Point();
			Step step = new Step();
			p = findS();
			step.setPoint(p);
			step.setParent(null);
			q.enqueue(step);
			while (!q.isEmpty()) {
				step = (Step) q.dequeue();
				p = step.getPoint();
				// route.add(step);
				if (map[p.x][p.y] == 'E') {
					return route(step);
				}
				visited[p.x][p.y] = true;
				addBFS(step);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int[][] solveDFS(final File maze) {
		// TODO Auto-generated method stub
		try {
			readFile(maze);
			s = new Stack();
			// SLinkedList route = new SLinkedList();
			Point p = new Point();
			Step step = new Step();
			p = findS();
			step.setPoint(p);
			step.setParent(null);
			s.push(step);
			while (!s.isEmpty()) {
				step = (Step) s.pop();
				// route.add(p);
				p = step.getPoint();
				if (map[p.x][p.y] == 'E') {
					return route(step);
				}
				visited[p.x][p.y] = true;
				addDFS(step);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**.
	 * @method add DFS.
	 * @param parent step.
	 */
	public void addDFS(final Step parent) {
		Point p = new Point();
		p = parent.getPoint();
		if ((p.y + 1) < m) {
			Point left = new Point(p.x, p.y + 1);
			if (map[left.x][left.y] != '#'
					&& !visited[left.x][left.y]) {
				Step step = new Step();
				step.setParent(parent);
				step.setPoint(left);
				s.push(step);

			}
		}
		if ((p.y - 1) >= 0) {
			Point right = new Point(p.x, p.y - 1);
			if (map[right.x][right.y] != '#'
					&& !visited[right.x][right.y]) {
				Step step = new Step();
				step.setParent(parent);
				step.setPoint(right);
				s.push(step);
			}
		}
		if ((p.x - 1) >= 0) {
			Point up = new Point(p.x - 1, p.y);
			if (map[up.x][up.y] != '#'
					&& !visited[up.x][up.y]) {
				Step step = new Step();
				step.setParent(parent);
				step.setPoint(up);
				s.push(step);

			}
		}
		if ((p.x + 1) < n) {
			Point down = new Point(p.x + 1, p.y);
			if (map[down.x][down.y] != '#'
					&& !visited[down.x][down.y]) {
				Step step = new Step();
				step.setParent(parent);
				step.setPoint(down);
				s.push(step);
			}
		}
	}
	/**.
	 * @method add BFS.
	 * @param parent step
	 */
	public void addBFS(final Step parent) {
		Point p = new Point();
		p = parent.getPoint();
		if ((p.x + 1) < n) {
			Point down = new Point(p.x + 1, p.y);
			if (map[down.x][down.y] != '#'
					&& !visited[down.x][down.y]) {
				Step step = new Step();
				step.setParent(parent);
				step.setPoint(down);
				q.enqueue(step);
				visited[down.x][down.y] = true;
			}
		}
		if ((p.x - 1) >= 0) {
			Point up = new Point(p.x - 1, p.y);
			if (map[up.x][up.y] != '#'
					&& !visited[up.x][up.y]) {
				Step step = new Step();
				step.setParent(parent);
				step.setPoint(up);
				q.enqueue(step);
				visited[up.x][up.y] = true;
			}
		}
		if ((p.y + 1) < m) {
			Point left = new Point(p.x, p.y + 1);
			if (map[left.x][left.y] != '#'
					&& !visited[left.x][left.y]) {
				Step step = new Step();
				step.setParent(parent);
				step.setPoint(left);
				q.enqueue(step);
				visited[left.x][left.y] = true;
			}
		}
		if ((p.y - 1) >= 0) {
			Point right = new Point(p.x, p.y - 1);
			if (map[right.x][right.y] != '#'
					&& !visited[right.x][right.y]) {
				Step step = new Step();
				step.setParent(parent);
				step.setPoint(right);
				q.enqueue(step);
				visited[right.x][right.y] = true;

			}
		}
	}
	/**.
	 * @method route.
	 * @param step step.
	 * @return r rout.
	 */
	public int[][] route(final Step step) {
		Step y = new Step();
		y = step;
		SLinkedList x = new SLinkedList();
		while (y.getParent() != null) {
			x.add(0, y.getPoint());
			y = y.getParent();
		}
		x.add(0, y.getPoint());
		int[][] r = new int[x.size()][2];
		int i = 0;
		while (i < x.size()) {
			Point p = (Point) x.get(i);
			r[i][0] = p.x;
			r[i][1] = p.y;
			i++;
		}
		return r;
	}
	/**.
	 * @method finds to find start.
	 * @return start p.
	 */
	public Point findS() {
		int i = 0, j = 0;
		Point start = null;
		boolean check = false;
		for (i = 0; i < n; i++) {
			for (j = 0; j < m; j++) {
				if (map[i][j] == 'E') {
					check = true;
				}
			}
		}
		if (!check) {
			throw new RuntimeException();
		}
		for (i = 0; i < n; i++) {
			for (j = 0; j < m; j++) {
				if (map[i][j] == 'S') {
					start = new Point(i, j);
				}
			}
		}
		return start;
	}
	/**.
	 * @method read file.
	 * @param x file.
	 * @throws IOException .
	 */
	public void readFile(final File x) throws IOException {
		String line;
		String st = "";
		int i;
		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(
					new FileReader(x));
			line = br.readLine();
			for (i = 0; line.charAt(i) != ' '; i++) {
				st += line.charAt(i);
			}
			n = Integer.valueOf(st);
			st = line.substring(i + 1, line.length());
			m = Integer.valueOf(st);
			map = new char[n][m];
			visited = new boolean[n][m];
			for (i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					visited[i][j] = false;
				}
			}
			for (i = 0; i < n; i++) {
				line = br.readLine();
				for (int j = 0; j < m; j++) {
					map[i][j] = line.charAt(j);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
