package fr.gembasher.brumes

import fr.gembasher.brumes.network.EntityState

/** Generic class for entities currently instancied in a Zone */
abstract class Entity extends Moveable {
	val id :Int = Entity.get_new_entity_id()

	def generate_state() :EntityState ={
		//TODO temp : l'entite regarde sa destination
		new EntityState(id, 
			position.current.x, position.current.y, 
			position.destination.x, position.destination.y,
			position.destination.x, position.destination.y
			)
	}

	def update() {
		//update code
		move()
	}
	
}

/** Companion object wich provide uniques id */

object Entity {
	var next_entity_id :Int = 1;

	def get_new_entity_id() :Int ={
		val id = next_entity_id
		next_entity_id += 1
		return id
	}
}