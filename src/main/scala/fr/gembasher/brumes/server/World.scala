package fr.gembasher.brumes.server

//import fr.gembasher.brumes.server.Zone
/**
*
*/
object World {

	val zones :List[Zone] = List() // mettre les zones

	def update(delta : Double) {
		for ( zone :Zone <- zones ) {
			zone.update
		}
	}
}