package modules.docs

import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by kasonchan on 11/6/15.
 */
class TestSpec extends FlatSpec with Matchers {

  "Test" should "= This is module-docs core" in {
    Test.apply() shouldBe "This is module-docs core"
  }

}
