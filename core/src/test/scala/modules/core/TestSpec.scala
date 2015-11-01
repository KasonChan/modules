package modules.core

import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by kasonchan on 10/31/15.
 */
class TestSpec extends FlatSpec with Matchers {

  "Test" should "= This is module-core" in {
    Test.apply() shouldBe "This is module-core"
  }

}
