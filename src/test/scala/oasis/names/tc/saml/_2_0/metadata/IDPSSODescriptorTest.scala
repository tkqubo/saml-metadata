package oasis.names.tc.saml._2_0.metadata

import java.net.URL

import org.scalatest.{DiagrammedAssertions, Matchers, WordSpec}

import scala.xml.XML

/**
  * Test class for [[IDPSSODescriptor]]
  * {{{
  * sbt "test-only oasis.names.tc.saml._2_0.metadata.IDPSSODescriptorTest"
  * }}}
  */
class IDPSSODescriptorTest extends WordSpec with Matchers with DiagrammedAssertions {
  classOf[IDPSSODescriptor].getCanonicalName should {
    "reader" should {
      "pass" in {
        val url: URL = getClass.getResource("/example.xml")
        val saml = XML.load(url)
        val descriptor = (saml \\ "IDPSSODescriptor").head
        val actual = IDPSSODescriptor.reader.read(descriptor)
        actual.keyDescriptors should have size 2
        actual.singleSignOnServices should have size 2
      }
    }
  }
}
