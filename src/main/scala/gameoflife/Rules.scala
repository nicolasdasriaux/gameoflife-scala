package gameoflife

import gameoflife.CellStatus._

object Rules {
  def nextCellState(cellStatus: CellStatus, neighbourCount: Int): CellStatus = {
    neighbourCount match {
      case n if n < 2 => Dead
      case n if n > 3 => Dead
      case 2          => cellStatus
      case 3          => Alive
    }
  }
}
