package fr.gembasher.brumes.server

import scala.collection.mutable.MutableList
import fr.gembasher.brumes.Entity

/**
* A zone is an area of the world with a limited set of entry points needing a loading time for client
* zones ares independents, entities other than players characters can't travel between them
* If needed zones could be instanciated, for housing per exemple.
*/
class Zone (val name :Symbol){
	var entities :List[Entity] = List()

	def register_entity (entity :Entity) {
		entities = entity :: entities
	}

	def update {
		for( entity :Entity <- entities) {
			entity.update()
		}
	}

	def is_free(location :Location, collision_size :Double) :Boolean = {
		/* check lack of collision with setting */
		/* check lack of collision with entities */
		return true
	}

}