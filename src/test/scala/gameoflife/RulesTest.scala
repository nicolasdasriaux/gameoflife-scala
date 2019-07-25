package gameoflife

import org.scalatest.{FunSpec, Matchers}
import org.scalatest.prop.TableDrivenPropertyChecks._

import CellState._

class RulesTest extends FunSpec with Matchers {
  describe("Rules") {
    it("Cell should be dead when underpopulated neighbourhood") {
      Rules.nextCellState(Dead, 1) should be(Dead)
      Rules.nextCellState(Alive, 1) should be(Dead)
    }

    it("Cell should be dead when overpopulated neighbourhood") {
      val examples = Table("n", 4, 5, 6, 7, 8)

      forAll(examples) { n =>
        Rules.nextCellState(Dead, n) should be(Dead)
        Rules.nextCellState(Alive, n) should be(Dead)
      }
    }

    it("Cell should stay the same when neutral neighbourhood") {
        Rules.nextCellState(Dead, 2) should be(Dead)
        Rules.nextCellState(Alive, 2) should be(Alive)
    }

    it("New Cell should be born when reproduction neighbourhood") {
      Rules.nextCellState(Dead, 3) should be(Alive)
      Rules.nextCellState(Alive, 3) should be(Alive)
    }
  }
}
