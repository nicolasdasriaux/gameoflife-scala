package gameoflife

case class Area(p1: Position, p2: Position) {
  val xRange: Range.Inclusive = (p1.x min p2.x) to (p1.x max p2.x)
  val yRange: Range.Inclusive = (p1.y min p2.y) to (p1.y max p2.y)

  def width: Int = xRange.size
  def height: Int = yRange.size

  def contains(position: Position): Boolean =
    xRange.contains(position.x) &&  yRange.contains(position.y)

  def normalize(position: Position): Position = Position(position.x - xRange.start, position.y - yRange.start)
}
