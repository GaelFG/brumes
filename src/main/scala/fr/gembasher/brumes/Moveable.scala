package fr.gembasher.brumes

import fr.gembasher.brumes.server.Zone
import fr.gembasher.brumes.server.Location

/** Define entities which can move on the world */
trait Moveable {
	val position :Position
	var velocity :Double

	/** Update position objective of entity */
	def aim_toward(new_destination :Location) {
		position.destination = new_destination
	}

	/** Eventualy move entity toward it's destination */
	def move() {
		position.update(velocity)
	}	
}