import java.awt.Rectangle;

public class PhysicsUtils {
	public static void collisionWithWall(Rectangle wall, Tortoise tort) {
		float ballMinX = wall.x + tort.radius;
		float ballMinY = wall.y + tort.radius;
		float ballMaxX = wall.width - tort.radius;
		float ballMaxY = wall.height - tort.radius;
		if (tort.x < ballMinX) {
			tort.speedX = -tort.speedX; // Reflect along normal
			tort.x = ballMinX; // Re-position the Tortoise at the edge
                        tort.factor=-35;//rotating the head
		} else if (tort.x > ballMaxX) {
			tort.speedX = -tort.speedX;
			tort.x = ballMaxX;
                        tort.factor=-35;//rotating the head
		}
		// May cross both x and y bounds
		if (tort.y < ballMinY) {
			tort.speedY = -tort.speedY;
			tort.y = ballMinY;
                        tort.factor=-35;//rotating the head
		} else if (tort.y > ballMaxY) {
			tort.speedY = -tort.speedY;
			tort.y = ballMaxY;
                        tort.factor=-35;//rotating the head
		}
	}

	public static void intersect(Tortoise a, Tortoise b,int x,int y) {
		//ref http://gamedev.stackexchange.com/questions/20516/ball-collisions-sticking-together
		double xDist, yDist;
		xDist = a.x - b.x;
		yDist = a.y - b.y;
		double distSquared = xDist * xDist + yDist * yDist;
                int penPosx=x;
                int penPosy=y;
		// Check the squared distances instead of the the distances, same
		// result, but avoids a square root.
		if (distSquared <= (a.radius + b.radius+10) * (a.radius + b.radius+10)) {
			double speedXocity = b.speedX - a.speedX;
			double speedYocity = b.speedY - a.speedY;
			double dotProduct = xDist * speedXocity + yDist * speedYocity;
			// Neat vector maths, used for checking if the objects moves towards
			// one another.
			if (dotProduct > 0) {
				double collisionScale = dotProduct / distSquared;
				double xCollision = xDist * collisionScale;
				double yCollision = yDist * collisionScale;
				// The Collision vector is the speed difference projected on the
				// Dist vector,
				// thus it is the component of the speed difference needed for
				// the collision.
				double combinedMass = a.getMass() + b.getMass();
				double collisionWeightA = 2 * b.getMass() / combinedMass;
				double collisionWeightB = 2 * a.getMass() / combinedMass;
				a.speedX += (collisionWeightA * xCollision);
				a.speedY += (collisionWeightA * yCollision);
                                a.factor=5;
				b.speedX -= (collisionWeightB * xCollision);
				b.speedY -= (collisionWeightB * yCollision);
                                b.factor=5;
			}
		}
	}




}
