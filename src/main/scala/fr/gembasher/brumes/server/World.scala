package fr.gembasher.brumes.server

//import fr.gembasher.brumes.server.Zone
/**
*
*/
object World {

	var zones :List[Zone] = List() // mettre les zones
	zones = new Zone('test_zone) :: zones

	def get_zone_by_id( id_zone :Symbol ) :Zone = {
		return zones.head
	}

	def update(delta : Double) {
		for ( zone :Zone <- zones ) {
			zone.update
		}
	}
}