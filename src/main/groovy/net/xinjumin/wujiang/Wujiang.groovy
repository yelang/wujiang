package net.xinjumin.wujiang

import groovy.util.logging.Slf4j
import net.xinjumin.sql.ConnectionDef
import net.xinjumin.utils.DesEncrypt

/**
 * Wujiang.
 *
 * Author: <a href="mailto:yawolf@qq.com">Shaolin Cheung </a>
 * Created: 2007-07-06 07:26
 */
@Slf4j
class Wujiang {
    void runLoader() {
        def xmlfile = "wujiang.xml"
        def config = new XmlParser().parse(xmlfile)
        String password, destPassword
        if (config.source_datasource.encrypt.text() == "true") {
            password = config.source_datasource.password.text()
        } else {
            password = DesEncrypt.encode(config.source_datasource.password.text())
            config.source_datasource.password[0].value = password
            config.source_datasource.encrypt[0].value = "true"
            new XmlNodePrinter(new PrintWriter(new FileWriter(xmlfile))).print(config)
        }

        if (config.dest_datasource.encrypt.text() == "true") {
            destPassword = config.dest_datasource.password.text()
        } else {
            destPassword = DesEncrypt.encode(config.dest_datasource.password.text())
            config.dest_datasource.password[0].value = destPassword
            config.dest_datasource.encrypt[0].value = "true"
            new XmlNodePrinter(new PrintWriter(new FileWriter(xmlfile))).print(config)
        }
        log.info "startup"
        //源
        def srcConnectionDef = new ConnectionDef(
                url: config.source_datasource.connection_url.text(),
                driver: config.source_datasource.driver_class.text(),
                user: config.source_datasource.user_name.text(),
                password: DesEncrypt.decode(password)
        )

        //目标
        def destConnectionDef = new ConnectionDef(
                url: config.dest_datasource.connection_url.text(),
                driver: config.dest_datasource.driver_class.text(),
                user: config.dest_datasource.user_name.text(),
                password: DesEncrypt.decode(destPassword)
        )

        //TODO
    }

    static void main(String[] args) {
        new Wujiang().runLoader()
    }

}
