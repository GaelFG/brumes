package fr.gembasher.brumes

import fr.gembasher.brumes.server.Zone

/** Define entities which can move on the world */
trait Moveable {
	val position :Position
	var velocity :Double
	var x_destination :Double = position.x
	var y_destination :Double = position.y

	/** Update position objective of entity */
	def aim_toward( p_x :Double, p_y :Double ) {
		x_destination = p_x
		y_destination = p_y
	}

	/** Eventualy move entity toward it's destination */
	def move() {
		position.update( x_destination, y_destination, velocity )
	}	
}