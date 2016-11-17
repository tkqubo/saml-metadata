package oasis.names.tc.saml._2_0.metadata

import com.github.tkqubo.saml_metadata.marshalling.ExampleXml
import org.scalatest.{DiagrammedAssertions, Matchers, WordSpec}

/**
  * Test class for [[IssuerPrincipal]]
  * {{{
  * sbt "test-only oasis.names.tc.saml._2_0.metadata.IssuerPrincipalTest"
  * }}}
  */
class IssuerPrincipalTest extends WordSpec with Matchers with DiagrammedAssertions {
  classOf[IssuerPrincipal].getCanonicalName should {
    "apply" should {
      "pass" in {
        val certificate = X509Certificate.loadCertificate(ExampleXml.certificate.value1)
        val actual = IssuerPrincipal(certificate)
        import ExampleXml.certificate.issuer._
        actual should === (IssuerPrincipal(Some(commonName), Some(company), Some(country), Some(state)))
      }
    }
  }
}
