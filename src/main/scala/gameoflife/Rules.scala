package gameoflife

import gameoflife.CellState._

object Rules {
  def nextCellState(cellStatus: CellState, neighbourCount: Int): CellState = {
    neighbourCount match {
      case n if n < 2 => Dead
      case n if n > 3 => Dead
      case 2          => cellStatus
      case 3          => Alive
    }
  }
}
