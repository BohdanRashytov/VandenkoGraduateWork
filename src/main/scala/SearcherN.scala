import java.lang.Math._

object SearcherN {
  val T = 1.0
  val alpha = 1.0 / 2.0
  val c = 1.0
  val Ih = 1.0 / 2.0 * (1 - 1 / (E*E))

  val maxIndex = pow(10, 5).toInt


  def b(k: Int) = pow(k, - 3.0 / 2.0)

  def lambda(k: Int) = PI * k / T

  def deltaZero(N: Int) = sqrt(
    (2 + T*T*Ih*Ih / 2)*pow(((N + 1) to maxIndex).map(k => pow(b(k), 2)).sum, 2) +
      (8*c*c + Ih*Ih/4)*pow(((N + 1) to maxIndex).map(k => pow(b(k), 2)/lambda(k)).sum, 2) +
    T*Ih*Ih/2*((N + 1) to maxIndex).map(k => pow(b(k), 2)).sum * ((N + 1) to maxIndex).map(k => pow(b(k), 2)/lambda(k)).sum
  )

  def K(N: Int) = pow(2, 1 - alpha) * sqrt(
    ((N + 1) to maxIndex).map(k => pow(b(k), 2)*pow(lambda(k), 2*alpha)).sum * ((N + 1) to maxIndex).map(k => pow(b(k), 2)).sum +
    pow(((N + 1) to maxIndex).map(k => pow(b(k), 2)*pow(lambda(k), alpha)).sum, 2) +
    8*c*c*(((N + 1) to maxIndex).map(k => pow(b(k), 2)*pow(lambda(k), 2*alpha - 1)).sum * ((N + 1) to maxIndex).map(k => pow(b(k), 2)*pow(lambda(k), -1)).sum +
      pow(((N + 1) to maxIndex).map(k => pow(b(k), 2)*pow(lambda(k), alpha - 1)).sum, 2)) +
    16*c*c*(((N + 1) to maxIndex).map(k => pow(b(k), 2)*pow(lambda(k), 2*alpha - 2)).sum * ((N + 1) to maxIndex).map(k => pow(b(k), 2)*pow(lambda(k), -2)).sum +
      pow(((N + 1) to maxIndex).map(k => pow(b(k), 2)*pow(lambda(k), alpha - 2)).sum, 2))
  )

  def firstCondition(N: Int, delta: Double) = (deltaZero(N) max K(N)*pow(T/2.0, alpha)) < alpha*delta / (2*sqrt(2))

  def secondCondition(N: Int, delta: Double, nu: Double) = 4*exp(3.0/alpha)*exp(-delta/(2*sqrt(2)*deltaZero(N)))*
    pow(delta*alpha/(2*sqrt(2)*deltaZero(N)), 2.0 / alpha)*
    pow(1 + 4*delta/(2*sqrt(2)*deltaZero(N)), 1.0/2.0) < nu

  def apply(delta: Double, nu: Double): Int = {
    (1 to 100).foreach(N => {
      if (firstCondition(N, delta) && secondCondition(N, delta, nu)) return N
    })
    100
  }

}
