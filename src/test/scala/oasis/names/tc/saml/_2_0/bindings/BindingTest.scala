package oasis.names.tc.saml._2_0.bindings

import java.net.URI

import org.scalatest.{DiagrammedAssertions, Matchers, WordSpec}

/**
  * Test class for [[Binding]]
  * {{{
  * sbt "test-only oasis.names.tc.saml._2_0.bindings.BindingTest"
  * }}}
  */
class BindingTest extends WordSpec with Matchers with DiagrammedAssertions {
  val httpPost: String = "urn:oasis:names:tc:SAML:2.0:bindings:HTTP-POST"
  val httpRedirect: String = "urn:oasis:names:tc:SAML:2.0:bindings:HTTP-Redirect"
  val httpArtifact: String = "urn:oasis:names:tc:SAML:2.0:bindings:HTTP-Artifact"
  val soap: String = "urn:oasis:names:tc:SAML:2.0:bindings:SOAP"
  val paos: String = "urn:oasis:names:tc:SAML:2.0:bindings:PAOS"
  val uri: String = "urn:oasis:names:tc:SAML:2.0:bindings:URI"
  val urlEncodingDeflate: String = "urn:oasis:names:tc:SAML:2.0:bindings:URL-Encoding:DEFLATE"

  classOf[Binding].getCanonicalName should {
    "Binding.apply" should {
      "pass" in {
        Binding(httpPost) should === (Binding.HttpPost)
        Binding(httpRedirect) should === (Binding.HttpRedirect)
        Binding(httpArtifact) should === (Binding.HttpArtifact)
        Binding(soap) should === (Binding.Soap)
        Binding(paos) should === (Binding.Paos)
        Binding(uri) should === (Binding.Uri)
        Binding(urlEncodingDeflate) should === (Binding.UrlEncodingDeflate)
      }
    }
    "identification" should {
      "pass" in {
        Binding.HttpPost.uri should === (new URI(httpPost))
        Binding.HttpRedirect.uri should === (new URI(httpRedirect))
        Binding.HttpArtifact.uri should === (new URI(httpArtifact))
        Binding.Soap.uri should === (new URI(soap))
        Binding.Paos.uri should === (new URI(paos))
        Binding.Uri.uri should === (new URI(uri))
        Binding.UrlEncodingDeflate.uri should === (new URI(urlEncodingDeflate))
      }
    }
    "name" should {
      "pass" in {
        Binding.HttpPost.name should === ("HTTP-POST")
        Binding.HttpRedirect.name should === ("HTTP-Redirect")
        Binding.HttpArtifact.name should === ("HTTP-Artifact")
        Binding.Soap.name should === ("SOAP")
        Binding.Paos.name should === ("PAOS")
        Binding.Uri.name should === ("URI")
        Binding.UrlEncodingDeflate.name should === ("URL-Encoding:DEFLATE")
      }
    }
  }
}
