package fr.gembasher.brumes.server

import scala.collection.mutable.SynchronizedQueue
import fr.gembasher.brumes.Network

object Launcher {
  val inputs_queue = new SynchronizedQueue
  var running = true
  var simulation_time = 0
  
  def main(args: Array[String]) {
    println("lancement serveur ...")
    launch
  }

  def launch {

    Network.register
    World.initialize
    KryoServer.addListener(BrumesListener)
    KryoServer.bind(Network.port);
    KryoServer.start();

    while (running) {
      run(1)
    }
    DataBase.shutdown
  }
  
  def run (delta : Double) {
    var real_time = System.currentTimeMillis
    while (simulation_time < real_time)
      simulation_time += 16 //TODO choisir framerate
      process_inputs
      World.update(16)
    
  }
  
  def process_inputs {
    while(!inputs_queue.isEmpty) {
      var message = inputs_queue.dequeue
      // traiter message
    }
  }
  
}