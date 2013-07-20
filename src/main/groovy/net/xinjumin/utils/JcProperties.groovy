package net.xinjumin.utils

import net.xinjumin.sql.ConnectionDef

/**
 * JcProperties.
 *
 * Author: <a href="mailto:yawolf@qq.com">Shaolin Cheung </a>
 * Created: 2013-07-06 13:46
 */
class JcProperties {
    /**
     * 数据库连接属性.
     * @param connDef 数据库连接定义
     * @return
     */
    static Properties getProperties(ConnectionDef connDef) {
        Properties prop = new Properties()
        prop.setProperty("user", connDef.user)
        prop.setProperty("password", connDef.password)
        //10gJDBC 驱动导致date型字段，时间没有了
        prop.setProperty("oracle.jdbc.V8Compatible", "true")
        return prop
    }
}
