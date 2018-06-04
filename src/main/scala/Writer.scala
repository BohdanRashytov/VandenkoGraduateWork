import java.io.{BufferedWriter, FileWriter}
import GraduateWork._

object Writer {
  def write(name: String, list: List[Double]) = {
    val folder = s"src/main/resources"
    val buffer = new BufferedWriter(new FileWriter(s"$folder/$name.txt"))
    buffer.write(name)
    buffer.write("\n")
    buffer.flush()
  }
}
