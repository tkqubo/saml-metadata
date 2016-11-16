package oasis.names.tc.saml._2_0.bindings

import java.net.URI

sealed trait Binding {
  def name: String
  def uri: URI
}

object Binding {
  class BindingBase(override final val name: String) extends Binding {
    override final val uri: URI = new URI(s"urn:oasis:names:tc:SAML:2.0:bindings:$name")
  }

  case object Soap extends BindingBase("SOAP")
  case object Paos extends BindingBase("PAOS")
  case object HttpRedirect extends BindingBase("HTTP-Redirect")
  case object HttpPost extends BindingBase("HTTP-POST")
  case object HttpArtifact extends BindingBase("HTTP-Artifact")
  case object UrlEncodingDeflate extends BindingBase("URL-Encoding:DEFLATE")
  case object Uri extends BindingBase("URI")

  def all: Set[Binding] = Set(Soap, Paos, HttpRedirect, HttpPost, HttpArtifact, UrlEncodingDeflate, Uri)

  def apply(uri: String): Binding = all.find(_.uri.toString == uri).getOrElse(throw new NoSuchElementException(s"$uri does not exist for binding"))
}

