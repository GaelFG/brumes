package fr.gembasher.brumes

import fr.gembasher.brumes.server.Zone
import fr.gembasher.brumes.server.Location

/**
* The position of an entity in a game zone
*/
class Position(val environment :Zone, var current :Location, var collisionBox_size :Double) {
	var destination :Location = current

	def update(velocity :Double) {
		val future :Location = current.step_toward(destination, velocity)
		if ( environment.is_free(future, collisionBox_size) ) {
			current = future
		}
	}

}