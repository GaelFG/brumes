package fr.gembasher.brumes

import fr.gembasher.brumes.server.Zone
import fr.gembasher.brumes.server.Location

/**
* The position of an entity in a game zone
*/
class Position(val environment :Zone, var current :Location, var collisionBox_size :Double) {
	var destination :Location = current

	def update(velocity :Double) {
		val future :Location = Location(current.x,current.y)

		if (current == destination) return
		
		if ( current.x < destination.x ) {
			future.x = Math.min(destination.x, current.x+velocity)
		}

		if ( current.x > destination.x ) {
			future.x = Math.max(destination.x, current.x-velocity)
		}

		if ( current.y < destination.y ) {
			future.y = Math.min(destination.y, current.y+velocity)
		}

		if ( current.y > destination.y ) {
			future.y = Math.max(destination.y, current.y-velocity)
		}

		if ( environment.is_free(future, collisionBox_size) ) {
			current = future
		}
	}

}