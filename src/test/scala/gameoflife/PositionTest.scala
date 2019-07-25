package gameoflife

import org.scalatest.{FunSpec, Matchers}

class PositionTest extends FunSpec with Matchers {
  describe("Position") {
    it ("should provide neighbour positions") {
      val position = Position(6, 4)
      position.neighbours should be(Set(
        Position(5, 3), Position(6, 3), Position(7, 3),
        Position(5, 4),                 Position(7, 4),
        Position(5, 5), Position(6, 5), Position(7, 5)
      ))
    }
  }
}
