package oasis.names.tc.saml._2_0.metadata

import javax.security.auth.x500.X500Principal

/**
  * Represents certificate attributes
  * https://docs.oracle.com/cd/E24191_01/common/tutorials/authz_cert_attributes.html
  * @param commonName Attribute represented by `CN`
  * @param organization Attribute represented by `O`
  * @param country Attribute represented by `C`
  * @param state Attribute represented by `ST`
  */
case class IssuerPrincipal(
  commonName: Option[String],
  organization: Option[String],
  country: Option[String],
  state: Option[String]
)

object IssuerPrincipal {
  def apply(cert: java.security.cert.X509Certificate): IssuerPrincipal = {
    val map: Map[String, String] = cert.getIssuerX500Principal
      .getName(X500Principal.RFC2253)
      .split(",")
      .map { pair =>
        val array = pair.trim.split("=")
        (array(0).toUpperCase, array(1))
      }(collection.breakOut)
    IssuerPrincipal(
      commonName = map.get("CN"),
      organization = map.get("O"),
      country = map.get("C"),
      state = map.get("ST")
    )
  }
}
