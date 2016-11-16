package oasis.names.tc.saml._2_0.metadata

import com.github.tkqubo.saml_metadata.marshalling.XmlReader

sealed trait KeyDescriptorValue

/** Enables the recipient(s) to obtain the key needed to validate the signature
  * https://www.w3.org/TR/xmldsig-core/#sec-KeyInfo
  * @param values
  */
case class KeyInfo(values: Seq[KeyInfoValue]) extends KeyDescriptorValue

object KeyInfo {
  val reader: XmlReader[KeyInfo] = XmlReader {
    case <KeyInfo>{values @ _*}</KeyInfo> => KeyInfo(values.flatMap(KeyInfoValue.reader.readOption))
  }
}

object KeyDescriptorValue {
  val reader: XmlReader[KeyDescriptorValue] = KeyInfo.reader
}