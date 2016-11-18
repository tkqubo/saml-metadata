package oasis.names.tc.saml._2_0.metadata

import com.github.tkqubo.saml_metadata.marshalling.XmlReader

case class Signature(keyInfos: Seq[KeyInfo])

object Signature {
  val reader: XmlReader[Signature] = XmlReader {
    case elem @ <Signature>{children@_*}</Signature> =>
      Signature(children.flatMap(KeyInfo.reader.readOption))
  }
}
