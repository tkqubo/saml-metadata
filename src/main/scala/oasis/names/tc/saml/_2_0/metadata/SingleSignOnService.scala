package oasis.names.tc.saml._2_0.metadata

import java.net.URI

import com.github.tkqubo.saml_metadata.marshalling.XmlReader
import oasis.names.tc.saml._2_0.bindings.Binding

/**
  * See `2.4.3 Element <IDPSSODescriptor>`'s `<SingleSignOnService>` section in
  * http://docs.oasis-open.org/security/saml/v2.0/saml-metadata-2.0-os.pdf
  * @param binding
  * @param location
  */
case class SingleSignOnService(binding: Binding, location: URI) extends Endpoint {
  override def responseLocation: Option[URI] = None
}

object SingleSignOnService {
  val reader = XmlReader {
    case elem @ <SingleSignOnService /> =>
      val binding = elem \@ "Binding"
      val location = elem \@ "Location"
      SingleSignOnService(Binding(binding), new URI(location))
  }
}
