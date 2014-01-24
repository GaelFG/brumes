package fr.gembasher.brumes.server

import scala.collection.mutable.SynchronizedQueue

object Launcher {
  val inputs_queue = new SynchronizedQueue
  
  def main(args: Array[String]) {
    println("lancement serveur ...")
    launch
  }

  def launch {
    var running = true
    while (running) {
      run(1)
    }
    DataBase.shutdown
  }
  
  def run (delta : Double) {
    // relever temps
    process_inputs
    World.update(delta)
    // relever temps
    // dormir pour rester au framerate fixé
    
  }
  
  def process_inputs {
    while(!inputs_queue.isEmpty) {
      var message = inputs_queue.dequeue
      // traiter message
    }
  }
  
}