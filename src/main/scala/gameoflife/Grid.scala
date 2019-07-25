package gameoflife

import java.nio.file.{Files, Paths}

import gameoflife.CellState.{Alive, Dead}

import scala.jdk.CollectionConverters._

case class Grid(aliveCellPositions: Set[Position]) {
  def cellState(position: Position): CellState = if (aliveCellPositions.contains(position)) Alive else Dead

  def positionsToReconsider: Set[Position] = aliveCellPositions union aliveCellPositions.flatMap(_.neighbours)

  def aliveNeighbourCount(position: Position): Int = position.neighbours.count(p => cellState(p) == Alive)

  def nextGridState: Grid = {
    val newAlivePositions = positionsToReconsider
      .map { position =>
        val nextCellState = Rules.nextCellState(cellState(position), aliveNeighbourCount(position))
        (position, nextCellState)
      }
      .collect {
        case (position, state) if state == Alive => position
      }

    Grid(newAlivePositions)
  }
}

object Grid {
  def toDisplayString(grid: Grid, area: Area): String = {
    val displayGrid = Array.fill(area.height, area.width)(".")

    grid.aliveCellPositions.filter(area.contains).map(area.normalize).foreach { position =>
      displayGrid(position.y)(position.x) = "O"
    }

    displayGrid.map(_.mkString(" ")).mkString("\n")
  }

  def load(path: String): (Grid, Area) = {
    val lines = Files.readAllLines(Paths.get(path)).asScala.toVector
    val grid: Grid = fromLines(lines)

    val width = lines.headOption.fold(0)(_.length)
    val height = lines.length
    val area = Area(Position(0, 0), Position(width - 1, height - 1))

    (grid, area)
  }

  def fromLines(lines: Seq[String]): Grid = {
    val positions =
      lines.zipWithIndex.flatMap { case (line, y) =>
        line.zipWithIndex.collect { case ('o', x) =>
          Position(x, y)
        }
      }

    Grid(positions.toSet)
  }
}
