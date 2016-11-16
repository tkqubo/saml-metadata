package oasis.names.tc.saml._2_0.metadata

import com.github.tkqubo.saml_metadata.marshalling.XmlReader

/**
  * See `2.4.3 Element <IDPSSODescriptor>` in
  * http://docs.oasis-open.org/security/saml/v2.0/saml-metadata-2.0-os.pdf
  * @param singleSignOnServices
  * @param keyDescriptors
  */
case class IDPSSODescriptor(
  singleSignOnServices: Seq[SingleSignOnService],
  keyDescriptors: Seq[KeyDescriptor]
) extends RoleDescriptor

object IDPSSODescriptor {
  val reader = XmlReader {
    case <IDPSSODescriptor>{children @ _*}</IDPSSODescriptor> =>
      val singleSignOnServices = children.flatMap(SingleSignOnService.reader.readOption)
      val keyDescriptors = children.flatMap(KeyDescriptor.reader.readOption)
      IDPSSODescriptor(singleSignOnServices, keyDescriptors)
  }
}


