package oasis.names.tc.saml._2_0.metadata

import java.net.URL

import org.scalatest.{DiagrammedAssertions, Matchers, WordSpec}

import scala.xml.XML

/**
  * Test class for [[KeyInfo]]
  * {{{
  * sbt "test-only oasis.names.tc.saml._2_0.metadata.KeyInfoTest"
  * }}}
  */
class KeyInfoTest extends WordSpec with Matchers with DiagrammedAssertions {
  classOf[KeyInfo].getCanonicalName should {
    "reader" should {
      "pass" in {
        val url: URL = getClass.getResource("/example.xml")
        val saml = XML.load(url)
        val info = (saml \\ "KeyInfo").head
        val actual = KeyInfo.reader.read(info)
        actual.values should have size 1
      }
    }
  }
}
