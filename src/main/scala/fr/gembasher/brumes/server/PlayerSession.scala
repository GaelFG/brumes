package fr.gembasher.brumes.server

import com.esotericsoftware.kryonet.Connection

/**
 * Une extention de la Connection Kryonet spécifique à Brumes
 */
class PlayerSession extends Connection {
  var character :Character = null

}
