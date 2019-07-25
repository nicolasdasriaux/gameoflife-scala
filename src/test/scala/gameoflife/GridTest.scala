package gameoflife

import org.scalatest.{FunSpec, Matchers}

class GridTest extends FunSpec with Matchers {
  describe("Grid") {
    it("should construct a grid from alive cell positions") {
      val aliveCellPositions = Set(Position(1, 0), Position(1, 1), Position(1, 2))
      val grid = Grid(aliveCellPositions)
      grid.aliveCellPositions should be(aliveCellPositions)
    }

    it("should provide cells to reconsider on next turn") {
      val aliveCellPositions = Set(Position(1, 0), Position(1, 1), Position(1, 2))
      val grid = Grid(aliveCellPositions)

      grid.positionsToReconsider should be (Set(
        Position(0, -1), Position(1, -1), Position(2, -1),
        Position(0, 0), Position(1, 0), Position(2, 0),
        Position(0, 1), Position(1, 1), Position(2, 1),
        Position(0, 2), Position(1, 2), Position(2, 2),
        Position(0, 3), Position(1, 3), Position(2, 3)
      ))
    }

    it("should determine next grid state") {
      val grid = Grid(Set(Position(1, 0), Position(1, 1), Position(1, 2)))
      val nextGrid = Grid(Set(Position(0, 1), Position(1, 1), Position(2, 1)))
      grid.nextGridState should be(nextGrid)
    }

    describe("Blinker") {
      it("should cycle") {
        val blinkerV = Grid(Set(Position(1, 0), Position(1, 1), Position(1, 2)))
        val blinkerH = Grid(Set(Position(0, 1), Position(1, 1), Position(2, 1)))
        blinkerV.nextGridState should be(blinkerH)
        blinkerV.nextGridState.nextGridState should be(blinkerV)
      }
    }

    describe("Display String") {
      it("should produce duisplay string") {
        val blinkerV = Grid(Set(Position(1, 0), Position(1, 1), Position(1, 2)))
        val displayString = Grid.toDisplayString(blinkerV, Area(Position(-1, -1), Position(3, 3)))
        println(displayString)
      }
    }
  }
}
