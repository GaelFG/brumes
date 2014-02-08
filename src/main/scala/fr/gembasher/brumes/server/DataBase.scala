package fr.gembasher.brumes.server

import fr.gembasher.brumes.PlayerCharacter
import fr.gembasher.brumes.Position

object DataBase {

	/**
	* validate a login
	*/
	def is_valid_login(login :String, password :String) :Boolean={
		login match {
			case "gael" => true
			case "flavio" => true
			case _ => false
		}
	}

	def get_character_id_by_account(login :String) :Int={
		//TODO implements
		login match {
			case "gael" => 3
			case "flavio" => 4
			case _ => 1
		}
	}

	/**
	* Load a character
	*/
	def load_character_by_id( id :Int ) :PlayerCharacter ={
		var character :PlayerCharacter = null
		/* placeholder */
		val zone_id :Symbol = 'test_zone
		if (id == 3) {
			val position_initiale = new Position(World.get_zone_by_id(zone_id), Location(0, 0),1)
			character = new PlayerCharacter(id, "Gael", position_initiale, 1)
		} else if (id == 4) {
			val position_initiale = new Position(World.get_zone_by_id(zone_id), Location(2, 2),1)
			character = new PlayerCharacter(id, "Flavio", position_initiale, 1)
		} else {
			val position_initiale = new Position(World.get_zone_by_id(zone_id), Location(2, 2),1)
			character = new PlayerCharacter(id, "RandomConnard", position_initiale, 1)
		}
		return character
	}

	def shutdown {
	  
	}
}