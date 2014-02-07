package fr.gembasher.brumes.server

import fr.gembasher.brumes.Character
import fr.gembasher.brumes.Position

object DataBase {

	/**
	* validate a login
	*/
	def is_valid_login(login :String, password :String) :Boolean={
		//TODO implements
		return true
	}

	def get_character_id_by_account(login :String) :Int={
		//TODO implements
		return 1
	}

	/**
	* Load a character, add him in the entity list of his current zone, and return a reference to him
	*/
	def load_character_by_id( id :Int ) :fr.gembasher.brumes.Character ={
		var character :Character = null
		/* placeholder */
		if (id == 1) {
			val position_initiale = new Position(World.get_zone_by_id('test_zone), Location(0, 0),1)
			character = new Character(id, "Michel", position_initiale, 1)
		} else {
			val position_initiale = new Position(World.get_zone_by_id('test_zone), Location(2, 2),1)
			character = new Character(id, "Jean-Louis", position_initiale, 1)
		}
		return character
	}

	def shutdown {
	  
	}
}