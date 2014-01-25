package fr.gembasher.brumes.server

import scala.collection.mutable.SynchronizedQueue
import fr.gembasher.brumes.Network

object Launcher {
  val inputs_queue = new SynchronizedQueue
  
  def main(args: Array[String]) {
    println("lancement serveur ...")
    launch
  }

  def launch {

    Network.register
    KryoServer.addListener(BrumesListener)
    KryoServer.bind(Network.port);
    KryoServer.start();

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
    Thread sleep 333 
    // dormir pour rester au framerate fixé
    
  }
  
  def process_inputs {
    while(!inputs_queue.isEmpty) {
      var message = inputs_queue.dequeue
      // traiter message
    }
  }
  
}