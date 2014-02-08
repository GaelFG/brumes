package fr.gembasher.brumes

import fr.gembasher.brumes.server.Zone 

/**
* A connected player character
*/
class PlayerCharacter(val id :Int, var name :String, val position :Position, var velocity :Double ) extends Entity( ) {
	
	def get_zone_key() :Symbol= {
		position.environment.name
	}
}