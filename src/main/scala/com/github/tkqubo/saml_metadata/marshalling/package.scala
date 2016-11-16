package com.github.tkqubo.saml_metadata

import scala.reflect.ClassTag
import scala.xml.Node

package object marshalling {
  implicit class NodeOps(val self: Node) {
    def convertTo[A: XmlReader :ClassTag]: A = implicitly[XmlReader[A]].read(self)
  }
}
