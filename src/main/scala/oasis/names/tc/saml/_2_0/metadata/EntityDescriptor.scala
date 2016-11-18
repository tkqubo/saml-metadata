package oasis.names.tc.saml._2_0.metadata

import java.net.URI

import com.github.tkqubo.saml_metadata.marshalling._

/**
  * See `2.3.1 Element <EntitiesDescriptor>` in
  * http://docs.oasis-open.org/security/saml/v2.0/saml-metadata-2.0-os.pdf
  * @param entityId
  * @param id
  * @param signature
  * @param idpSsoDescriptors
  */
case class EntityDescriptor(
  entityId: URI,
  id: Option[String] = None,
  signature: Option[Signature] = None,
  idpSsoDescriptors: Seq[IDPSSODescriptor] = Nil
)

object EntityDescriptor {
  val reader = XmlReader {
    case elem @ <EntityDescriptor>{children @ _*}</EntityDescriptor> =>
      val entityId = elem \@ "entityID"
      val ID = Option(elem \@ "ID").filter(_.nonEmpty)
      val iDPSSODescriptors = children.flatMap(IDPSSODescriptor.reader.readOption)
      val signature = children.flatMap(Signature.reader.readOption).headOption
      EntityDescriptor(new URI(entityId), ID, signature, iDPSSODescriptors)
  }
}
