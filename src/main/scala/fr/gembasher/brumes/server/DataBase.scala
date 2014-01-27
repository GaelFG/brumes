package fr.gembasher.brumes.server

import fr.gembasher.brumes.Character


object DataBase {

	/**
	* Load a character
	*/
	def load_character_by_id( p_id :Int ) {
		/* placeholder */
		new Character(p_id, 0, 0, "Michel", 1,  World.get_zone_by_id('test_zone), 1)
	}

	def shutdown {
	  
	}
}