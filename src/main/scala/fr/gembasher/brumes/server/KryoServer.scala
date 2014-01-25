package fr.gembasher.brumes.server

import com.esotericsoftware.kryonet.Server
import com.esotericsoftware.kryonet.Connection

/**
* Server front-end : receive players inputs and send them world state
*/
object KryoServer extends Server {
  /** On redefinit la methode qui crée les connections Kryonet pour utiliser nos versions enrichies */
  override def newConnection :Connection = new PlayerSession  
}
