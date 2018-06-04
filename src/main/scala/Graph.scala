import java.awt.{Color, Frame}
import javax.swing.JFrame

import org.math.plot.Plot2DPanel

object Graph {
  def paint(graph: List[(Double, Double)] = List(), plotName: String = "Graph") = {
    val plot: Plot2DPanel = new Plot2DPanel()
    val frame: JFrame = new JFrame(plotName)
    frame.setExtendedState(Frame.MAXIMIZED_BOTH)
    frame.setVisible(true)
    frame.setContentPane(plot)
    plot.addLinePlot(s"$plotName-Analytics points", Color.BLUE, graph.map(_._1).toArray, graph.map(_._2).toArray)
  }
}