package fr.gembasher.brumes.server

import fr.gembasher.brumes.PlayerCharacter
import scala.collection.mutable.MutableList
/**
*
*/
object World {
	var zones :Map[Symbol,Zone] = Map() // mettre les zones
	
	def register_character( character :PlayerCharacter ) {
		val zone = get_zone_by_id(character.get_zone_key())
		zone.register_entity(character)
	}

	def initialize {
		zones = zones + ('test_zone -> new Zone('test_zone))
 		zones = zones + ('test_zone2 -> new Zone('test_zone2))
	}

	def get_zone_by_id( id_zone :Symbol ) :Zone = {
		return zones('test_zone)
	}

	def update(delta :Double) {
		for ( zone :Zone <- zones.values ) {
			zone.update
		}
	}

	def disconnect_character ( character :PlayerCharacter ) {
		val zone = get_zone_by_id(character.get_zone_key())
		zone.delete_entity(character)
	}


}