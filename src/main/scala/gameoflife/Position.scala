package gameoflife

case class Position(x: Int, y: Int) {
  def neighbours: Set[Position] = Position.deltas.map({ case (dx, dy) =>
    Position(x + dx, y + dy)
  }).toSet
}

object Position {
  val deltas: Seq[(Int, Int)] = for {
    dx <- -1 to 1
    dy <- -1 to 1
    if !(dx == 0 && dy == 0)
  } yield (dx, dy)
}
