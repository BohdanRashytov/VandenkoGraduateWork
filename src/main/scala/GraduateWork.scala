object GraduateWork {

  def main(args: Array[String]): Unit = {
    paintGraph("0.0 - 0.0 -> 0")
//    createTable
  }

  def createTable = {
    val data = List(
        (0.6, 0.4),
        (0.75, 0.25),
        (0.8, 0.2),
        (0.9, 0.1),
        (0.95, 0.05),
        (0.5, 0.35),
        (0.5, 0.5),
        (0.78, 0.9),
        (0.3, 0.15),
        (0.27, 0.4),
        (0.23, 0.42),
        (0.4, 0.8),
        (0.8, 0.15),
        (0.15, 0.16),
        (0.16, 0.23),
        (0.42, 0.4)
      )
    val result = data.map(d => (d._1, d._2, SearcherN(d._1, d._2)))
    Writer.write("table", result)
  }

  def paintGraph(name: String) = {
    val n = 1000
    val simulationProcess = SimulationProcess
    val X = (0 until n).map(i => (1.0 * i / n, simulationProcess.X(1.0 * i / n))).toList
    Graph.paint(X, name)
  }
}
