package needle.devices.com.database

import app.cash.sqldelight.db.SqlDriver
import needle.devices.com.db.NeedleDatabase

expect class DbDriverFactory {
    fun createDriver(): SqlDriver
}

fun createNeedleDatabase(driverFactory: DbDriverFactory): NeedleDatabase {
    val driver = driverFactory.createDriver()
    return NeedleDatabase(driver)
}