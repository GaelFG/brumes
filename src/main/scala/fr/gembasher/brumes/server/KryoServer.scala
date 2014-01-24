package fr.gembasher.brumes.server

import com.esotericsoftware.kryonet.Server

/**
* Server front-end : receive players inputs and send them world state
*/
object KryoServer extends Server {
  	   protected var Connection = new PlayerSession;
  
  def initialize {}
  

  
}
