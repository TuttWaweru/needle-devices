package needle.devices.com.repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import needle.devices.com.db.NeedleDatabase
import needle.devices.com.db.NeedleUser

interface NeedleUserRepository {
    suspend fun selectAllUsers(): List<NeedleUser>
    fun selectAllUsersFlow(): Flow<List<NeedleUser>>
}

class NeedleUserRepositoryImpl(
    private val db: NeedleDatabase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : NeedleUserRepository {
    override suspend fun selectAllUsers(): List<NeedleUser> =
        db.userQueries.selectAll().executeAsList()

    override fun selectAllUsersFlow(): Flow<List<NeedleUser>> =
        db.userQueries.selectAll().asFlow().mapToList(ioDispatcher)
}