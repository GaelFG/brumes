package fr.gembasher.brumes.server

/**
* A location on a world zone identified by it's coordinates
*/
 case class Location(var x :Double,var y :Double) {
 	
 	def step_toward(destination:Location, velocity :Double) :Location ={
 		val future :Location = Location(x,y)

 		if ( x < destination.x ) {
			future.x = Math.min(destination.x, x+velocity)
		}

		if ( x > destination.x ) {
			future.x = Math.max(destination.x, x-velocity)
		}

		if ( y < destination.y ) {
			future.y = Math.min(destination.y, y+velocity)
		}

		if ( y > destination.y ) {
			future.y = Math.max(destination.y, y-velocity)
		}
		return future
 	}
}