package oasis.names.tc.saml._2_0.metadata

import java.net.URL

import com.github.tkqubo.saml_metadata.marshalling.ExampleXml
import org.scalatest.{DiagrammedAssertions, Matchers, WordSpec}

import scala.xml._

/**
  * Test class for [[EntityDescriptor]]
  * {{{
  * sbt "test-only oasis.names.tc.saml._2_0.metadata.EntityDescriptorTest"
  * }}}
  */
class EntityDescriptorTest extends WordSpec with Matchers with DiagrammedAssertions {
  classOf[EntityDescriptor].getCanonicalName should {
    "reader" should {
      "pass" in {
        val url: URL = getClass.getResource("/example.xml")
        val saml = XML.load(url)
        val actual: Option[EntityDescriptor] = EntityDescriptor.reader.readOption(saml)
        actual should not be None
        actual.get.id should === (ExampleXml.id)
        actual.get.entityId should === (ExampleXml.entityId)
        actual.get.signature should not be None
        actual.get.signature.get.keyInfos should have size 1
        actual.get.idpSsoDescriptors should have size 1
      }
    }
  }
}
