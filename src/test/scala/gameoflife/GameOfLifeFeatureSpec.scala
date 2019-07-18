package gameoflife

import org.scalatest.{FeatureSpec, GivenWhenThen, Matchers}

// http://www.scalatest.org/getting_started_with_feature_spec
class GameOfLifeFeatureSpec extends FeatureSpec with GivenWhenThen with Matchers {
  feature("Feature 1") {
    info("Description")
    info("More description")

    scenario("Scenario 1") {
      Given("two numbers")
      val a = 1
      val b = 2

      When("processing them")
      val sum = a + b

      Then("their sum should be calculated")
      sum should be(3)
    }
  }
}
