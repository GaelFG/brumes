package fr.gembasher.brumes.server

import scala.collection.mutable.MutableList
/**
*
*/
object World {

	val zones :MutableList[Zone] = MutableList() // mettre les zones
	zones += new Zone('test_zone)
	zones += new Zone('test_zone2)
	load_test_setting

	def get_zone_by_id( id_zone :Symbol ) :Zone = {
		//TODO faire le foreach ou passer a une hashmap
		//TODO Biter comment marchent les mutables
		return zones.get(1).getOrElse(null)
	}

	def update(delta : Double) {
		for ( zone :Zone <- zones ) {
			zone.update
		}
	}

	def load_test_setting() {
		
	}

}