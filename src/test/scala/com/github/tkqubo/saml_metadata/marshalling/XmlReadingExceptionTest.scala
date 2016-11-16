package com.github.tkqubo.saml_metadata.marshalling

import org.scalatest.{DiagrammedAssertions, Matchers, WordSpec}

/**
  * Test class for [[XmlReadingException]]
  * {{{
  * sbt "test-only com.github.tkqubo.saml_metadata.marshalling.XmlReadingExceptionTest"
  * }}}
  */
class XmlReadingExceptionTest extends WordSpec with Matchers with DiagrammedAssertions {
  classOf[XmlReadingException[_]].getCanonicalName should {
    "getMessage" should {
      "pass" in {
        case class Foo(name: String)
        val xml = <bar></bar>
        val actual = new XmlReadingException[Foo](xml).getMessage
        actual should === (s"bar cannot be converted to ${classOf[Foo].getName}")
      }
      "pass with non-elem" in {
        case class Foo(name: String)
        val xml = <xml:group><bar></bar><baz></baz></xml:group>
        val actual = new XmlReadingException[Foo](xml).getMessage
        actual should === (s"<bar></bar><baz></baz> cannot be converted to ${classOf[Foo].getName}")
      }
    }
  }
}
