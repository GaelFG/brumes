package fr.gembasher.brumes.server

import com.esotericsoftware.kryonet.Listener
import fr.gembasher.brumes.network.RegistrationRequired
import com.esotericsoftware.kryonet.Connection
import fr.gembasher.brumes.Character

/**
*	Here are received players inputs
*/
object BrumesListener extends Listener {

	override def received (connection :Connection, obj :Object ) {
		// We know all connections for this server are actually CharacterConnections.
        val session = connection.asInstanceOf[PlayerSession]
        val character = session.character

        session.sendTCP(new RegistrationRequired )

	}
}