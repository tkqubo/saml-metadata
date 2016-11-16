package com.github.tkqubo.saml_metadata.marshalling

import scala.reflect.ClassTag
import scala.xml.{Elem, Node}

class XmlReadingException[A: ClassTag](node: Node) extends Exception {
  private val tag: ClassTag[A] = implicitly[ClassTag[A]]
  override def getMessage: String = node match {
    case elem: Elem => s"${elem.label} cannot be converted to ${tag.runtimeClass.getName}"
    case _ => s"$node cannot be converted to ${tag.runtimeClass.getName}"
  }
}
