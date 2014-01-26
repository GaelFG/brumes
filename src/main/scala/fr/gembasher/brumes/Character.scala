package fr.gembasher.brumes

import fr.gembasher.brumes.server.Zone 

/**
* A connected player character
*/
class Character(val id :Int, var x :Double, var y :Double, var name :String, var velocity :Double, val environment :Zone, var collisionBox_size :Double) extends Entity( ) {
	
}