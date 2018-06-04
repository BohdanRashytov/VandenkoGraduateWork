object GraduateWork {

  def main(args: Array[String]): Unit = {
    val n = 1000
    val simulationProcess = SimulationProcess
    val X = (0 until n).map(i => (1.0 * i / n, simulationProcess.X(1.0 * i / n))).toList
    Graph.paint(X, "X")
  }
}
