package com.srdc.plantapp.ui.ui.onboarding

import androidx.lifecycle.ViewModel
import com.srdc.plantapp.data.local.OnboardingPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val dataStore: OnboardingPreferences
) : ViewModel() {


    suspend fun setOnboardingCompleted(completed: Boolean) {
        dataStore.setOnboardingCompleted(completed)
    }

    fun isOnboardingCompleted(): Flow<Boolean> {
        return dataStore.isOnboardingCompleted()
            .map { prefs -> prefs }
    }

}
