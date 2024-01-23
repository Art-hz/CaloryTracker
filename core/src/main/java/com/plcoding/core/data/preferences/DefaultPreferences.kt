package com.plcoding.core.data.preferences

import android.content.SharedPreferences
import com.plcoding.core.domain.model.ActivityLevel
import com.plcoding.core.domain.model.Gender
import com.plcoding.core.domain.model.GoalType
import com.plcoding.core.domain.model.UserInfo
import com.plcoding.core.domain.preferences.Preferences

class DefaultPreferences(private val sharedPref: SharedPreferences): Preferences {

    override fun saveGender(gender: Gender) {
        sharedPref.edit().putString(gender.name)
    }

    override fun saveAge(age: Int) {
        TODO("Not yet implemented")
    }

    override fun saveWeight(weight: Float) {
        TODO("Not yet implemented")
    }

    override fun saveHeight(height: Int) {
        TODO("Not yet implemented")
    }

    override fun saveActivityLevel(level: ActivityLevel) {
        TODO("Not yet implemented")
    }

    override fun saveGoalType(type: GoalType) {
        TODO("Not yet implemented")
    }

    override fun saveCarbRatio(ratio: Float) {
        TODO("Not yet implemented")
    }

    override fun saveProteinRatio(ratio: Float) {
        TODO("Not yet implemented")
    }

    override fun saveFatRatio(ratio: Float) {
        TODO("Not yet implemented")
    }

    override fun loadUserInfo(): UserInfo {
        TODO("Not yet implemented")
    }
}