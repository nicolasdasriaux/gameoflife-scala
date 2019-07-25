package gameoflife

import gameoflife.CellStatus.{Alive, Dead}

case class Grid(aliveCellPositions: Set[Position]) {
  def positionsToReconsider: Set[Position] = aliveCellPositions.flatMap(_.neighbours)
  def cell(position: Position): CellStatus = if (aliveCellPositions.contains(position)) Alive else Dead
  def aliveNeighbourCount(position: Position): Int = position.neighbours.count(p => cell(p) == Alive)

  def nextGridState: Grid = {
    val newAlivePositions = positionsToReconsider
      .map { position =>
        val nextCellState = Rules.nextCellState(cell(position), aliveNeighbourCount(position))
        (position, nextCellState)
      }
      .collect {
        case (position, state) if state == Alive => position
      }

    Grid(newAlivePositions)
  }
}
