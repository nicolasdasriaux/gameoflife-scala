package gameoflife

sealed trait CellState extends Product with Serializable

object CellState {
  final case object Alive extends CellState
  final case object Dead extends CellState
}
