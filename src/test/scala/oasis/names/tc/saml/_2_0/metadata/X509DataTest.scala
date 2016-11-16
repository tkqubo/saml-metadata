package oasis.names.tc.saml._2_0.metadata

import java.net.URL

import org.scalatest.{DiagrammedAssertions, Matchers, WordSpec}

import scala.xml.XML

/**
  * Test class for [[X509Data]]
  * {{{
  * sbt "test-only oasis.names.tc.saml._2_0.metadata.X509DataTest"
  * }}}
  */
class X509DataTest extends WordSpec with Matchers with DiagrammedAssertions {
  classOf[X509Data].getCanonicalName should {
    "reader" should {
      "pass" in {
        val url: URL = getClass.getResource("/example.xml")
        val saml = XML.load(url)
        val x509 = (saml \\ "X509Data").head
        val actual = X509Data.reader.read(x509)
        actual.values should have size 1
      }
    }
  }
}
