package com.github.tkqubo.saml_metadata.marshalling

import org.scalatest.{DiagrammedAssertions, Matchers, WordSpec}

/**
  * Test class for [[XmlReader]]
  * {{{
  * sbt "test-only com.github.tkqubo.saml_metadata.marshalling.XmlReaderTest"
  * }}}
  */
class XmlReaderTest extends WordSpec with Matchers with DiagrammedAssertions {
  case class Foo(name: String)
  val fooReader: XmlReader[Foo] = XmlReader { case <foo>{name}</foo> => Foo(name.text) }

  classOf[XmlReader[_]].getCanonicalName should {
    "read" should {
      "pass" in {
        val expected = "Bar"
        val xml = <foo>{expected}</foo>
        val actual = fooReader.read(xml)
        actual.name should === (expected)
      }
      "fail" in {
        val xml = <baz><foo>bop</foo></baz>
        the [XmlReadingException[Foo]] thrownBy fooReader.read(xml) should have message s"baz cannot be converted to ${classOf[Foo].getName}"
      }
    }
    "readOption" should {
      "return Some with correct node" in {
        val expected = "Bar"
        val xml = <foo title="this is foo">{expected}</foo>
        val actual = fooReader.readOption(xml)
        actual should not be empty
        actual.get.name should === (expected)
      }
      "return None with incorrect node" in {
        val xml = <baz><foo>bop</foo></baz>
        val actual = fooReader.readOption(xml)
        actual should === (None)
      }
    }
  }
}
