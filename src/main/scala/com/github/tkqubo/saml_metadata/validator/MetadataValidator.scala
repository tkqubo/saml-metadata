package com.github.tkqubo.saml_metadata.validator

import java.io.{File, FileInputStream}
import javax.xml.XMLConstants
import javax.xml.transform.Source
import javax.xml.transform.stream.StreamSource
import javax.xml.validation.{Schema, SchemaFactory, Validator}

trait MetadataValidator {
  private lazy val validator: Validator = buildValidator()
  private val xsdFileNames = Seq(
    "MetadataExchange.xsd",
    "oasis-200401-wss-wssecurity-secext-1.0.xsd",
    "oasis-200401-wss-wssecurity-utility-1.0.xsd",
    "saml-schema-assertion-2.0.xsd",
    "saml-schema-metadata-2.0.xsd",
    "ws-addr.xsd",
    "ws-authorization.xsd",
    "ws-federation.xsd",
    "ws-securitypolicy-1.2.xsd",
    "xenc-schema.xsd",
    "xmldsig-core-schema.xsd"
  )

  def validate(file: File): Boolean = {
    val xmlSource = new StreamSource(new FileInputStream(file))
    try {
      validator.validate(xmlSource)
      true
    } catch {
      case e: Throwable =>
        false
    }
  }

  private def buildValidator(): Validator = {
    val xsdSources: Array[Source] = xsdFileNames
      .map { fileName =>
        new StreamSource(new FileInputStream(new File(getClass.getResource(s"/schemas/$fileName").toURI)))
      }(collection.breakOut)
    val factory: SchemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
    val schema: Schema = factory.newSchema(xsdSources)
    schema.newValidator()
  }
}

object MetadataValidator extends MetadataValidator
