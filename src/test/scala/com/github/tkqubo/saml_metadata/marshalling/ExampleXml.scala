package com.github.tkqubo.saml_metadata.marshalling

import java.net.URI

object ExampleXml {
  val id = Some("exampleId")
  val entityId = new URI("https://example.com/saml/metadata")

  object certificate {
    object issuer {
      val email = "example-company@example.com"
      val commonName = "ExampleCompany"
      val company = "Example Company"
      val state = "Some-State"
      val country = "JP"
    }
    val value1 =
      """MIIGcTCCBFmgAwIBAgIJAPUCUZehdYL9MA0GCSqGSIb3DQEBBQUAMIGBMQswCQYD
        |VQQGEwJKUDETMBEGA1UECBMKU29tZS1TdGF0ZTEYMBYGA1UEChMPRXhhbXBsZSBD
        |b21wYW55MRcwFQYDVQQDEw5FeGFtcGxlQ29tcGFueTEqMCgGCSqGSIb3DQEJARYb
        |ZXhhbXBsZS1jb21wYW55QGV4YW1wbGUuY29tMB4XDTE2MTExNTA0MDY0NVoXDTE3
        |MTExNTA0MDY0NVowgYExCzAJBgNVBAYTAkpQMRMwEQYDVQQIEwpTb21lLVN0YXRl
        |MRgwFgYDVQQKEw9FeGFtcGxlIENvbXBhbnkxFzAVBgNVBAMTDkV4YW1wbGVDb21w
        |YW55MSowKAYJKoZIhvcNAQkBFhtleGFtcGxlLWNvbXBhbnlAZXhhbXBsZS5jb20w
        |ggIiMA0GCSqGSIb3DQEBAQUAA4ICDwAwggIKAoICAQDO8mHrhGOXuJ/1Mj+ZbhAL
        |B8JZzfIoiKVP8UBWUz+89ZobS9mBen76on2zQ53AiNocOs3eJZxnyk7gINznxvnW
        |L/IBboFkNmLW3CIkXYrTkQetpFa04TeXEBCWU+m1RvgqRbKGhnCXQ9VMtKFkld/A
        |i1Io72Syy7AWZPS5OxN2TketO4J4V/+982qsL8y/AWyslOmcLlk2g9PXPKY3DC+D
        |MyH0SAz7WWb5ka3a7T26Dt/8pqLsOw9mLkdrvZzammkdlkKE+kgNURl5TFijvaMB
        |EqrUswsMtU+35Pb5r0jeumGAvl6GcvHJYa/Kr42L8RnRESudOYXWrcTZKkQIZWB0
        |MP5d8Zzpz1iuDLl5lF7Fmxi/X7py3Beo6NtmOlrYBFLVUZ05HWy0cv1AU8BqjAVw
        |+8m08yHh6KwuedD0jW14nOqtyI1Vnt7POk+JlCRvwQI/wnQjC4EJemxBZledp/0C
        |20xXbqg7dT8I8oS4Y1W0potBsLkxWPNACAM5wKw32peoJHXjdaNtkB7mVj3WXR6B
        |LP9PUvEYZj8H5zl17qCp9WE4v4lAqMGJMmobZdDhkSqzbLvLlx9wjeH1wwCUV27e
        |0zYUm9rgZQv89hK9UNAnGg6q4u3dFhGulaLvdK8A4Gskd5FC6X3BpsFFL5R2MRNR
        |jND3rUzfqbye3OKr9nNTXQIDAQABo4HpMIHmMB0GA1UdDgQWBBRCI6HVeaJ+0fK8
        |0fv40R2LZqfX8zCBtgYDVR0jBIGuMIGrgBRCI6HVeaJ+0fK80fv40R2LZqfX86GB
        |h6SBhDCBgTELMAkGA1UEBhMCSlAxEzARBgNVBAgTClNvbWUtU3RhdGUxGDAWBgNV
        |BAoTD0V4YW1wbGUgQ29tcGFueTEXMBUGA1UEAxMORXhhbXBsZUNvbXBhbnkxKjAo
        |BgkqhkiG9w0BCQEWG2V4YW1wbGUtY29tcGFueUBleGFtcGxlLmNvbYIJAPUCUZeh
        |dYL9MAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADggIBAGSK2X3L5cL0Wryy
        |bZcNxea9ainuzVBK00+g18nMko/Qx0Sa2vKY/iZYGGt7YKqHExoTbGoxz2+jeX2e
        |jyltaDt0WH85AuTse81L0GHI0FBsOsEcTDqECzibopOrllQPUQvdd705buLWASNc
        |wbuGY50QXcylCXPAmiLXbXa++btNizERGf3mdRD838jFIzj7pRXW+UXtoC4O5MWQ
        |MXDjHfDCvfxhKV254aWRMLJCwzY92g5/k/oJuO84cjcowwy68FuIa/JzrlZ+NOy/
        |SsEwc3OengFfzrABaUGrl98t1rrXkVnmNC56Xwek1jA0pFrdiN/HhGSbVevL/m++
        |RbUgp63XoFu6wbz63IoZ80OSgQJT3aB89NnDAmMgkGp9Mih/ku0/nrHUwan+V9BH
        |eac+0IF0BPbCukPO9n0Cx71BkuoKI3cOqNJCj5ZbG51npO3QTu6yQUrpdvl46LOe
        |ijuZYRplSKHNv4g1uCdPmiu7J6SWrS0JRc9Jg/cQBxaDepmGkMmgbSc6uIgVK2tN
        |AKb7/Vgf2t0iYhUbxz1HsYlNcjqhggD4HeT1FrqF6KkY592xxCr8ZXjQGdgtt1H/
        |Hx7ZhPwmvYqYKg8tsMhmcvQIP3Hp/3F+Qdl+4kq/TDOucI1AXMLVuDQ6jhED2kFY
        |yvAF8DwFUIPC+/xw5Z/0MBKzpxGh""".stripMargin
  }

  object idpSsoDescriptor {
    object ssoService {
      val redirectUrl = new URI("https://example.com/saml/metadata/sso-http-redirect")
      val postUrl = new URI("https://example.com/saml/metadata/sso-http-post")
    }
  }
}
