package oasis.names.tc.saml._2_0.metadata

import java.net.URI

import oasis.names.tc.saml._2_0.bindings.Binding

trait Endpoint {
  def binding: Binding
  def location: URI
  def responseLocation: Option[URI]
}


