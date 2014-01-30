package fr.gembasher.brumes

import fr.gembasher.brumes.server.Zone 

/**
* The position of an entity in a game zone
*/
class Position(val environment :Zone, var x :Double, var y :Double, var collisionBox_size :Double) {

	def update(x_destination :Double, y_destination :Double, velocity :Double) {
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