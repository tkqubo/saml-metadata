package oasis.names.tc.saml._2_0.metadata

import java.net.URL

import org.scalatest.{DiagrammedAssertions, Matchers, WordSpec}

import scala.xml.XML

/**
  * Test class for [[KeyDescriptor]]
  * {{{
  * sbt "test-only oasis.names.tc.saml._2_0.metadata.KeyDescriptorTest"
  * }}}
  */
class KeyDescriptorTest extends WordSpec with Matchers with DiagrammedAssertions {
  classOf[KeyDescriptor].getCanonicalName should {
    "reader" should {
      "pass" in {
        val url: URL = getClass.getResource("/example.xml")
        val saml = XML.load(url)
        val descriptor = (saml \\ "KeyDescriptor").head
        val actual = KeyDescriptor.reader.read(descriptor)
        actual.values should have size 1
      }
    }
  }
}
