package eg.edu.alexu.csd.datastructure.maze.cs12_cs57_cs62;

import java.awt.Point;

/**.
 *
 * @author LENOVO
 *
 */
public class Step {

	/**.
	 * Coordinates of the point
	 */
	private Point pt;
	/**.
	 * Coordinates of the parent point
	 */
	private Step par;
	/**.
	 * @method get point.
	 * @return pt point.
	 */
	public Point getPoint() {
		return pt;
	}
	/**.
	 * @method set point.
	 * @param point Point.
	 */
	public void setPoint(final Point point) {
		pt = point;
	}
	/**.
	 * @method get parent.
	 * @return par step.
	 */
	public Step getParent() {
		return par;
	}
	/**.
	 * @method get parent.
	 * @param parent step.
	 */
	public void setParent(final Step parent) {
		par = parent;
	}
}
