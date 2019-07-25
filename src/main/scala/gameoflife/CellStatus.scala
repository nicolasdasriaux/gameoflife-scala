package gameoflife

sealed trait CellStatus extends Product with Serializable

object CellStatus {
  final case object Alive extends CellStatus
  final case object Dead extends CellStatus
}
