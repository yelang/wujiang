package net.xinjumin.sql

import groovy.transform.CompileStatic
import groovy.transform.ToString

/**
 * 数据库连接定义.
 * @author <a href="mailto:yawolf@qq.com">Shaolin Cheung </a>
 */
@ToString(includeNames = true, includeFields = true)
@CompileStatic
class ConnectionDef {
    String url
    String driver
    String user
    String password
}

