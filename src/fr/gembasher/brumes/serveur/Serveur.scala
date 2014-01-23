package fr.gembasher.brumes.serveur

import scala.collection.mutable.SynchronizedQueue

object Serveur {
  val queue_messages_entrants = new SynchronizedQueue
  
  def main(args: Array[String]) {
    println("lancement serveur ...")
    lancer
  }

  def lancer {
    var en_marche = true
    while (en_marche) {
      tourner(1)
    }
    Service_stockage.geler
  }
  
  def tourner (delta : Double) {
    // relever temps
    traiter_messages_entrants
    Monde.evoluer(delta)
    // relever temps
    // dormir pour rester au framerate fixé
    
  }
  
  def traiter_messages_entrants {
    while(!queue_messages_entrants.isEmpty) {
      var message = queue_messages_entrants.dequeue
      // traiter message
    }
  }
  
}