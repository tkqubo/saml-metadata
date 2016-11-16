package oasis.names.tc.saml._2_0.metadata

import com.github.tkqubo.saml_metadata.marshalling.XmlReader

/**
  * See `2.4.1.1 Element <KeyDescriptor>` in
  * http://docs.oasis-open.org/security/saml/v2.0/saml-metadata-2.0-os.pdf
  * @param values
  */
case class KeyDescriptor(values: Seq[KeyDescriptorValue])

object KeyDescriptor {
  val reader = XmlReader {
    case <KeyDescriptor>{values @ _*}</KeyDescriptor> =>
      KeyDescriptor(values.flatMap(KeyDescriptorValue.reader.readOption))
  }
}
