package needle.devices.com.database

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import needle.devices.com.db.NeedleDatabase

actual class DbDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = NeedleDatabase.Schema,
            name = "needle_database",
            context = context,
        )
    }

}