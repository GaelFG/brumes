package fr.gembasher.brumes.server

import scala.collection.mutable.MutableList
/**
*
*/
object World {

	var zones :Map[Symbol,Zone] = Map() // mettre les zones
	
	def initialize {
		zones = zones + ('test_zone -> new Zone('test_zone))
 		zones = zones + ('test_zone2 -> new Zone('test_zone2))
	}

	def get_zone_by_id( id_zone :Symbol ) :Zone = {
		println(zones)
		return new Zone('test_zone)
		//return zones('test_zone)
	}

	def update(delta : Double) {
		for ( zone :Zone <- zones.values ) {
			zone.update
		}
	}



}