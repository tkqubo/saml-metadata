package oasis.names.tc.saml._2_0.metadata

import java.net.URL

import com.github.tkqubo.saml_metadata.marshalling.ExampleXml
import oasis.names.tc.saml._2_0.bindings.Binding
import org.scalatest.{DiagrammedAssertions, Matchers, WordSpec}

import scala.xml.XML

/**
  * Test class for [[SingleSignOnService]]
  * {{{
  * sbt "test-only oasis.names.tc.saml._2_0.metadata.SingleSignOnServiceTest"
  * }}}
  */
class SingleSignOnServiceTest extends WordSpec with Matchers with DiagrammedAssertions {
  classOf[SingleSignOnService].getCanonicalName should {
    "reader" should {
      "read" in {
        val url: URL = getClass.getResource("/example.xml")
        val saml = XML.load(url)
        val ssos = saml \\ "SingleSignOnService"
        val actual = ssos.flatMap(SingleSignOnService.reader.readOption)
        actual should have size 2
        actual.find(_.binding == Binding.HttpPost) should not be empty
        actual.find(_.binding == Binding.HttpPost).get.location should === (ExampleXml.idpSsoDescriptor.ssoService.postUrl)
        actual.find(_.binding == Binding.HttpRedirect) should not be empty
        actual.find(_.binding == Binding.HttpRedirect).get.location should === (ExampleXml.idpSsoDescriptor.ssoService.redirectUrl)
      }
    }
  }
}
