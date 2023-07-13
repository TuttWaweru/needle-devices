package needle.devices.com.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import needle.devices.com.db.NeedleDatabase

actual class DbDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(
            name = "needle_database",
            schema = NeedleDatabase.Schema
        )
    }

}