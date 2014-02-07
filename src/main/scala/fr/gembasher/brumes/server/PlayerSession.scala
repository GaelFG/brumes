package fr.gembasher.brumes.server

import com.esotericsoftware.kryonet.Connection
import fr.gembasher.brumes.Character

/**
 * Une extention de la Connection Kryonet spécifique à Brumes
 */
class PlayerSession extends Connection {
  var character :fr.gembasher.brumes.Character = null

}
