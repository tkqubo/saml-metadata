package oasis.names.tc.saml._2_0.metadata

import com.github.tkqubo.saml_metadata.marshalling.XmlReader

trait KeyDescriptorValue

object KeyDescriptorValue {
  val reader: XmlReader[KeyDescriptorValue] = KeyInfo.reader
}