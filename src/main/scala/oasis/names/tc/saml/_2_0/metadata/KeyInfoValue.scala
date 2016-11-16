package oasis.names.tc.saml._2_0.metadata

import com.github.tkqubo.saml_metadata.marshalling.XmlReader

sealed trait KeyInfoValue

/** One or more identifiers of keys or X509 certificates (or certificates' identifiers or a revocation list).
  * https://www.w3.org/TR/xmldsig-core/#sec-X509Data
  * @param values
  */
case class X509Data(values: Seq[X509DataValue]) extends KeyInfoValue

object KeyInfoValue {
  val reader: XmlReader[KeyInfoValue] = X509Data.reader
}

object X509Data {
  val reader: XmlReader[X509Data] = XmlReader {
    case <X509Data>{values @ _*}</X509Data> =>
      X509Data(values.flatMap(X509DataValue.reader.readOption))
  }
}
