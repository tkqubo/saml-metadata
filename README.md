# SAML metadata

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.tkqubo/saml-metadata_2.12/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.tkqubo/saml-metadata_2.12/)
[![Circle CI](https://img.shields.io/circleci/project/tkqubo/saml-metadata/master.svg)](https://circleci.com/gh/tkqubo/saml-metadata)
[![Coverage Status](https://coveralls.io/repos/tkqubo/saml-metadata/badge.svg?branch=master&service=github)](https://coveralls.io/github/tkqubo/saml-metadata?branch=master)
[![License: MIT](http://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

## About

SAML V2.0 Metadata representation written in Scala

See:

- https://www.oasis-open.org/committees/download.php/51890/SAML%20MD%20simplified%20overview.pdf
- https://docs.oasis-open.org/security/saml/v2.0/saml-metadata-2.0-os.pdf

## Usage

```scala
import oasis.names.tc.saml._2_0.metadata._
import java.net.URL
import scala.xml.XML

val url = "https://svn.sdsc.edu/repo/NGBW/misc/trunk/misc/documents/shibboleth_config/etc_shibboleth/example-metadata.xml"
val xml = XML.load(new URL(url))
val descriptor: EntityDescriptor = EntityDescriptor.reader.read(xml)

println(descriptor.entityId)
// https://idp.example.org/shibboleth

println(descriptor.idpSsoDescriptors.flatMap(_.singleSignOnServices).map(_.location))
// List(https://idp.example.org/shibboleth/profile/shibboleth/SSO, https://idp.example.org/shibboleth/profile/saml2/Redirect/SSO, https://idp.example.org/shibboleth/profile/saml2/POST/SSO)
```

