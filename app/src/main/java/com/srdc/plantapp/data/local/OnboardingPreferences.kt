package com.srdc.plantapp.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private const val PREF_NAME = "onboarding_prefs"
private const val ONBOARDING_KEY = "onboarding_completed"

class OnboardingPreferences@Inject constructor(
    @ApplicationContext private val context: Context
) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREF_NAME)

    private val onboardingKey = booleanPreferencesKey(ONBOARDING_KEY)

    suspend fun setOnboardingCompleted(completed: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[onboardingKey] = completed
        }
    }

    fun isOnboardingCompleted(): Flow<Boolean> {
        return context.dataStore.data
            .map { prefs -> prefs[onboardingKey] ?: false }
    }
}