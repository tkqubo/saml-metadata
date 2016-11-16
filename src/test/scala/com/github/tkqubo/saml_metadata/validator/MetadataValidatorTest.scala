package com.github.tkqubo.saml_metadata.validator

import java.io.File

import org.scalatest.{DiagrammedAssertions, Matchers, WordSpec}

/**
  * Test class for [[MetadataValidator]]
  * {{{
  * sbt "test-only com.github.tkqubo.saml_metadata.validator.MetadataValidatorTest"
  * }}}
  */
class MetadataValidatorTest extends WordSpec with Matchers with DiagrammedAssertions {
  classOf[MetadataValidator].getCanonicalName should {
    "validate" should {
      "return true" in {
        val file: File = new File(getClass.getResource("/example.xml").toURI)
        MetadataValidator.validate(file) should === (true)
      }
      "return false" in {
        val file: File = new File(getClass.getResource("/example2.xml").toURI)
        MetadataValidator.validate(file) should === (false)
      }
    }
  }
}
