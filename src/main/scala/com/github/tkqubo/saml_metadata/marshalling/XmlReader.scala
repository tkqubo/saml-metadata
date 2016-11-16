package com.github.tkqubo.saml_metadata.marshalling

import scala.reflect.ClassTag
import scala.xml.Node

trait XmlReader[+A] {
  def readOption(node: Node): Option[A]
  def read[B >: A](node: Node)(implicit classTag: ClassTag[B]): A = readOption(node) getOrElse (throw new XmlReadingException[B](node))
}

object XmlReader {
  def apply[A](pf: PartialFunction[Node, A]): XmlReader[A] = new XmlReader[A] {
    override def readOption(node: Node): Option[A] = {
      val someApplication: PartialFunction[Node, Option[A]] = pf andThen Option.apply
      val noneApplication: PartialFunction[Node, Option[A]] = PartialFunction(_ => None)
      (someApplication orElse noneApplication).apply(node)
    }
  }
}
