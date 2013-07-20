package net.xinjumin.utils

import net.xinjumin.sql.ConnectionDef

/**
 * TestConnection.
 *
 * Author: <a href="mailto:yawolf@qq.com">Shaolin Cheung </a>
 * Created: 2013-07-06 19:47
 */
class TestConnection {
    static connectionDef = new ConnectionDef(
            url: "jdbc:oracle:thin:@(description=(address_list=(address=(protocol=tcp)(host=127.0.0.1)(port=1521)))(connect_data=(service_name=orcl)))",
            driver: "oracle.jdbc.driver.OracleDriver",
            user: "TEST",
            password: "PASSWORD"
    )
}
