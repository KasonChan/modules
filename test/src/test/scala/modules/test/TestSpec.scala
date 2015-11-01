package modules.test

import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by kasonchan on 10/31/15.
 */
class TestSpec extends FlatSpec with Matchers {

  "Test" should "= This is module-test" in {
    Test.apply() shouldBe "This is module-test"
  }

}
