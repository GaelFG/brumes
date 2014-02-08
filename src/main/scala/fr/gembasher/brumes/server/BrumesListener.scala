package fr.gembasher.brumes.server

import com.esotericsoftware.kryonet.Listener
import com.esotericsoftware.kryonet.Connection
import fr.gembasher.brumes.PlayerCharacter

import fr.gembasher.brumes.network.RegistrationRequired
import fr.gembasher.brumes.network.LoginRequest
import fr.gembasher.brumes.network.LoggedAs
import fr.gembasher.brumes.network.PlayerIntent

/**
*	Here are received players inputs
*/
object BrumesListener extends Listener {

	override def received (connection :Connection, obj :Object ) {
		// We know all connections for this server are actually CharacterConnections.
        val session = connection.asInstanceOf[PlayerSession]
        var character :fr.gembasher.brumes.PlayerCharacter = session.character


		if (obj.isInstanceOf[LoginRequest] ) {
							val login_request :LoginRequest = obj.asInstanceOf[LoginRequest]
							
							if (character != null) { return } // ignore if aldready logged

							if (DataBase.is_valid_login(login_request.login, login_request.encrypted_password)) {
								character = DataBase.load_character_by_id(DataBase.get_character_id_by_account(login_request.login))
								World.register_character(character)
								println("connexion de " + character.name)
								session.character = character
								session.sendTCP(new LoggedAs(character.name))
							} else {
								session.sendTCP(new RegistrationRequired())
							}


		} else if (obj.isInstanceOf[PlayerIntent] ) {

				    		if (character != null) {
					    			val player_intent :PlayerIntent = obj.asInstanceOf[PlayerIntent]
				    			character.aim_toward(Location(player_intent.destination_x, player_intent.destination_y))
				    		} else {
				    			session.sendTCP(new RegistrationRequired())
					   		}


    	}

	}
}