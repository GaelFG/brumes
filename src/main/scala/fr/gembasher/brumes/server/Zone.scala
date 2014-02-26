package fr.gembasher.brumes.server

import scala.collection.mutable.MutableList
import fr.gembasher.brumes.Entity
import fr.gembasher.brumes.network.EntityState
import fr.gembasher.brumes.network.WorldState

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

	def delete_entity(entity_to_remove :Entity) {
		entities = entities.remove( entity => entity == entity_to_remove )
	}

	def get_entity_by_id(entity_id :Int) :Entity = {
		for (entity :Entity <- entities) {
			if (entity.id == entity_id ) {
				return entity
			}
		}
		return null
	}

	def update {
		val world_state :WorldState = new WorldState()
		var entities_states :List[EntityState] = List[EntityState]()

		for( entity :Entity <- entities) {
			entity.update()
			entities_states = entity.generate_state() :: entities_states
		}
		world_state.entities_states = entities_states.toArray
		//TODO Raw experiment
		KryoServer.sendToAllTCP(world_state);

	}

	def is_free(location :Location, collision_size :Double) :Boolean = {
		/* check lack of collision with setting */
		/* check lack of collision with entities */
		return true
	}

}