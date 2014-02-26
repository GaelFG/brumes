package fr.gembasher.brumes

import fr.gembasher.brumes.server.Zone 

/**
* A connected player character
*/
class PlayerCharacter( name :String, val position :Position, var velocity :Double, 
	model_name :String, model_parameters :String ) extends Entity( name, model_name, model_parameters ) {

	def get_zone_key() :Symbol= {
		position.environment.name
	}
}