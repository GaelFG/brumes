package fr.gembasher.brumes

import fr.gembasher.brumes.server.Zone

/** Define entities which can move on the world */
trait Moveable {
	val environment :Zone
	var x :Double
	var y :Double
	var collisionBox_size :Double
	var velocity :Double
	var x_destination :Double = x
	var y_destination :Double = y

	/** Update position objective of entity */
	def aim_toward( p_x :Double, p_y :Double ) {
		x_destination = p_x
		y_destination = p_y
	}

	/** Eventualy move entity toward it's destination */
	def move() {
		var future_x = x
		var future_y = y

		if (x_destination == x && y_destination == y) return
		
		if ( x < x_destination ) {
			future_x = Math.min(x_destination, x+velocity)
		}

		if ( x > x_destination ) {
			future_x = Math.max(x_destination, x-velocity)
		}

		if ( y < y_destination ) {
			future_y = Math.min(y_destination, y+velocity)
		}

		if ( y > y_destination ) {
			future_y = Math.max(y_destination, y-velocity)
		}

		if ( environment.is_free(future_x, future_y, collisionBox_size) ) {
			x = future_x
			y = future_y
		}
	}	
}