package fr.gembasher.brumes
import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryonet.EndPoint
//import fr.gembasher.brumes.network.RegistrationRequired
//import fr.gembasher.brumes.network.PlayerIntent
//import fr.gembasher.brumes.network.LoginRequest
import fr.gembasher.brumes.server.KryoServer

import fr.gembasher.brumes.network.KryoRegisterer

/**
 * Include all common constants between server and client.
 * Also register commons class for networking
 */
object Network {
	/** Port used by server */
	val port = 2214

	def register {
		val kryo :Kryo = KryoServer.getKryo
		KryoRegisterer.registerAll(kryo)
	}

}