package fr.gembasher.brumes.server

import com.esotericsoftware.kryonet.Listener
import fr.gembasher.brumes.network.RegistrationRequired
import com.esotericsoftware.kryonet.Connection
import fr.gembasher.brumes.Character
import fr.gembasher.brumes.network.PlayerIntent

/**
*	Here are received players inputs
*/
object BrumesListener extends Listener {

	override def received (connection :Connection, obj :Object ) {
		// We know all connections for this server are actually CharacterConnections.
        val session = connection.asInstanceOf[PlayerSession]
        val character = session.character

        if (character == null) {
        session.sendTCP(new RegistrationRequired)
    	}

    	// sinon on est connecté legalement
    	if (obj.isInstanceOf[PlayerIntent] ) {
    		val player_intent :PlayerIntent = obj.asInstanceOf[PlayerIntent]
    		println("demande de mouvement a x : " + player_intent.destination_x + " Y : " + player_intent.destination_y);
    	}

	}
}