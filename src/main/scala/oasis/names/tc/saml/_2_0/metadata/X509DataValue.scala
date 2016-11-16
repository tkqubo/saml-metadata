package oasis.names.tc.saml._2_0.metadata

import java.io.ByteArrayInputStream
import java.security.cert
import java.security.cert.CertificateFactory
import java.util.Base64

import com.github.tkqubo.saml_metadata.marshalling.XmlReader


sealed trait X509DataValue
final case class X509Certificate(value: cert.X509Certificate, rawValue: String) extends X509DataValue {
  val principal: IssuerPrincipal = IssuerPrincipal(value)
}

object X509DataValue {
  val reader: XmlReader[X509DataValue] = X509Certificate.reader
}

object X509Certificate {
  val reader: XmlReader[X509Certificate] = XmlReader {
    case <X509Certificate>{value}</X509Certificate> =>
      X509Certificate(loadCertificate(value.text), value.text)
  }

  def loadCertificate(certificate: String): cert.X509Certificate = {
    val factory = CertificateFactory.getInstance("X.509")
    val bytes: Array[Byte] = certificate.split("\\s").mkString.getBytes
    val decoded: Array[Byte] = Base64.getDecoder.decode(bytes)
    factory.generateCertificate(new ByteArrayInputStream(decoded)).asInstanceOf[cert.X509Certificate]
  }
}