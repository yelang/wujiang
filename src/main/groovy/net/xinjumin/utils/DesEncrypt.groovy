package net.xinjumin.utils

import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.DESKeySpec

/**
 * DES加密与解密.
 *
 * Author: <a href="mailto:yawolf@qq.com">Shaolin Cheung </a>
 * Created: 2013-07-06 07:18
 */
class DesEncrypt {
    private static getPassword() { "net.xinjumin.sinan".getBytes("UTF-8") }

    static encode = { String target ->
        def cipher = getCipher(Cipher.ENCRYPT_MODE)
        return target ? cipher.doFinal(target.bytes).encodeBase64() : null
    }

    static decode = { String target ->
        def cipher = getCipher(Cipher.DECRYPT_MODE)
        return target ? new String(cipher.doFinal(target.decodeBase64())) : null
    }

    private static getCipher(mode) {
        def keySpec = new DESKeySpec(getPassword())
        def cipher = Cipher.getInstance("DES")
        def keyFactory = SecretKeyFactory.getInstance("DES")
        cipher.init(mode, keyFactory.generateSecret(keySpec))
        return cipher
    }
}
