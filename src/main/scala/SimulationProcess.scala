import java.lang.Math._

object SimulationProcess {

  val T = 1.0
  val maxK: Int = 1000
  val ksi: List[Double] = (0 until maxK).map(_ => {
    Thread.sleep(10)
    val alpha1 = random()
    val alpha2 = random()
    val sigma = 1.0
    sigma*sqrt(-2*log(alpha1))*sin(2*PI*alpha2)
  }).toList

  val lambda: List[Double] = (0 until maxK).map(k => PI*k/T).toList
  val b: List[Double] = List(1.0) ::: (1 until maxK).map(k => 1/pow(k, 1.0 / 2.0)).toList

  def H(tau: Double): Double = exp(-tau)

  def f(k:Int, t: Double): Double = b(k)*cos(lambda(k)*t)

  def X(t: Double): Double = (0 until maxK).map(k => f(k, t)*ksi(k)).sum

  def integral(a: Double, b: Double, f: Double => Double): Double = {
    val n = 100
    val delta = (b - a) / n
    (1 to n).map(i => delta * f(i * delta )).sum
  }

  def Y(t: Double): Double = integral(0, T, (tau: Double) => H(tau)*X(t - tau))

}
