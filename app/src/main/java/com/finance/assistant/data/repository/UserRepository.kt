package com.finance.assistant.data.repository

import com.finance.assistant.data.objectbox.entity.UserProfileEntity
import com.finance.assistant.data.objectbox.mapper.toDomain
import com.finance.assistant.data.objectbox.mapper.toEntity
import com.finance.assistant.domain.model.profile.UserProfile
import io.objectbox.Box
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.time.LocalDate
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val userBox: Box<UserProfileEntity>,
) {

    suspend fun saveProfile(profile: UserProfile): Long =
        withContext(Dispatchers.IO) {
            val entity = profile.toEntity().copy(updatedAt = LocalDate.now().toEpochDay())
            userBox.put(entity)
        }

    suspend fun getProfile(): UserProfile? =
        withContext(Dispatchers.IO) {
            userBox.all.firstOrNull()?.toDomain()
        }

    suspend fun updateBalance(newBalance: Double) =
        withContext(Dispatchers.IO) {
            userBox.all.firstOrNull()?.let { entity ->
                entity.balance = newBalance
                entity.updatedAt = LocalDate.now().toEpochDay()
                userBox.put(entity)
            }
        }

    suspend fun updateSalary(newSalary: Double) =
        withContext(Dispatchers.IO) {
            userBox.all.firstOrNull()?.let { entity ->
                entity.salary = newSalary
                entity.updatedAt = LocalDate.now().toEpochDay()
                userBox.put(entity)
            }
        }

    suspend fun updateSalaryDay(day: Int) =
        withContext(Dispatchers.IO) {
            userBox.all.firstOrNull()?.let { entity ->
                entity.salaryDay = day
                entity.updatedAt = LocalDate.now().toEpochDay()
                userBox.put(entity)
            }
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    fun observeProfile(): Flow<UserProfile?> =
        userBox.query()
            .build()
            .flow()
            .map { list -> list.firstOrNull()?.toDomain() }
            .flowOn(Dispatchers.IO)
}
