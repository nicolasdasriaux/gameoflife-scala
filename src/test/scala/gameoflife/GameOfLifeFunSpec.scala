package gameoflife

import org.scalatest.{FunSpec, Matchers}
import org.scalatest.prop.TableDrivenPropertyChecks._

// http://www.scalatest.org/getting_started_with_fun_spec
class GameOfLifeFunSpec extends FunSpec with Matchers {
  describe("...") {
    it("should ...") {
      // http://www.scalatest.org/user_guide/using_matchers
      "1".toInt should ===(1)
    }

    // http://www.scalatest.org/user_guide/table_driven_property_checks
    it("should ... ...") {
      val examples = Table(
        ("a", "b", "sum"),
        (1, 2, 3),
        (4, 5, 9),
        (12, 5, 17)
      )

      forAll(examples) { (a, b, sum) =>
        a + b should ===(sum)
      }
    }
  }
}
