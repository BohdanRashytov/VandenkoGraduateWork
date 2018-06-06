import java.io.{BufferedWriter, FileWriter}
import java.lang.{Double => JDouble}

object Writer {
  def write(name: String, list: List[(Double, Double, Int)]) = {
    val folder = s"src/main/resources"
    val buffer = new BufferedWriter(new FileWriter(s"$folder/$name.txt"))
    buffer.write("Accuracy\tSignificant level\t\tN\n")
    list.foreach(row => buffer.write(s"${String.format("%.2f", row._1: JDouble).replace(",", ".")}\t\t\t\t${String.format("%.2f", row._2: JDouble).replace(",", ".")}\t\t\t${row._3}\n"))
    buffer.flush()
  }
}
