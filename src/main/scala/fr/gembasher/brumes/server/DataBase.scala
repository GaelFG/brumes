package fr.gembasher.brumes.server

import fr.gembasher.brumes.Character
import fr.gembasher.brumes.Position

object DataBase {

	/**
	* Load a character
	*/
	def load_character_by_id( p_id :Int ) {
		/* placeholder */
		val position_initiale = new Position(World.get_zone_by_id('test_zone), Location(0, 0),1)
		new Character(p_id, "Michel", position_initiale, 1)
	}

	def shutdown {
	  
	}
}