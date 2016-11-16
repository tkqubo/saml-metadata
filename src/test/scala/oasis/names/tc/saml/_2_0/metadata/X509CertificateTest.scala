package oasis.names.tc.saml._2_0.metadata

import java.net.URL
import java.security.cert.CertificateException

import com.github.tkqubo.saml_metadata.marshalling.ExampleXml
import org.scalatest.{DiagrammedAssertions, Matchers, WordSpec}

import scala.xml.XML

/**
  * Test class for [[X509Certificate]]
  * {{{
  * sbt "test-only oasis.names.tc.saml._2_0.metadata.X509CertificateTest"
  * }}}
  */
class X509CertificateTest extends WordSpec with Matchers with DiagrammedAssertions {
  classOf[X509Certificate].getCanonicalName should {
    "reader" should {
      "read" in {
        val url: URL = getClass.getResource("/example.xml")
        val saml = XML.load(url)
        val node = (saml \\ "X509Certificate").head
        val actual = X509Certificate.reader.read(node)
        actual.rawValue.split("\n").map(_.trim).mkString("\n").trim should === (ExampleXml.certificate.value1)
      }
    }

    "loadCertificate" should {
      "pass" in {
        X509Certificate.loadCertificate(ExampleXml.certificate.value1)
        succeed
      }
      "fail" in {
        intercept[CertificateException] {
          X509Certificate.loadCertificate("foo")
        }
      }
    }
  }
}
