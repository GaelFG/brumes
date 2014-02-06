package fr.gembasher.brumes.server

import scala.collection.mutable.MutableList
import fr.gembasher.brumes.Entity

/**
* A zone is an area of the world with a limited set of entry points needing a loading time for client
* zones ares independents, entities other than players characters can't travel between them
* If needed zones could be instanciated, for housing per exemple.
*/
class Zone (val name :Symbol){
	val entities :MutableList[Entity] = MutableList()
	test_load_entities


	def update {

	}

	def is_free(location :Location, collision_size :Double) :Boolean = {
		/* check lack of collision with setting */
		/* check lack of collision with entities */
		return true
	}

	private def test_load_entities {
		entities += DataBase.load_character_by_id(1)
		entities += DataBase.load_character_by_id(2)
	}

}