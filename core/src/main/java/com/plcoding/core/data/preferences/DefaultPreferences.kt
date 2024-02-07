package com.plcoding.core.data.preferences

import android.content.SharedPreferences
import com.plcoding.core.domain.model.ActivityLevel
import com.plcoding.core.domain.model.Gender
import com.plcoding.core.domain.model.GoalType
import com.plcoding.core.domain.model.UserInfo
import com.plcoding.core.domain.preferences.Preferences
import com.plcoding.core.domain.preferences.Preferences.Companion.GENDER_KEY
import com.plcoding.core.domain.preferences.Preferences.Companion.KEY_ACTIVITY_LEVEL
import com.plcoding.core.domain.preferences.Preferences.Companion.KEY_AGE
import com.plcoding.core.domain.preferences.Preferences.Companion.KEY_CARB_RATIO
import com.plcoding.core.domain.preferences.Preferences.Companion.KEY_FAT_RATIO
import com.plcoding.core.domain.preferences.Preferences.Companion.KEY_GOAL_TYPE
import com.plcoding.core.domain.preferences.Preferences.Companion.KEY_HEIGHT
import com.plcoding.core.domain.preferences.Preferences.Companion.KEY_PROTEIN_RATIO
import com.plcoding.core.domain.preferences.Preferences.Companion.KEY_WEIGHT

class DefaultPreferences(private val sharedPref: SharedPreferences): Preferences {

    override fun saveGender(gender: Gender) {
        sharedPref.edit().putString(GENDER_KEY, gender.name).apply()
    }

    override fun saveAge(age: Int) {
        sharedPref.edit().putInt(KEY_AGE, age).apply()
    }

    override fun saveWeight(weight: Float) {
        sharedPref.edit().putFloat(KEY_WEIGHT, weight).apply()
    }

    override fun saveHeight(height: Int) {
        sharedPref.edit().putInt(KEY_HEIGHT, height).apply()
    }

    override fun saveActivityLevel(level: ActivityLevel) {
        sharedPref.edit().putString(KEY_ACTIVITY_LEVEL, level.name).apply()
    }

    override fun saveGoalType(type: GoalType) {
        sharedPref.edit().putString(KEY_GOAL_TYPE, type.name).apply()
    }

    override fun saveCarbRatio(ratio: Float) {
        sharedPref.edit().putFloat(KEY_CARB_RATIO, ratio).apply()
    }

    override fun saveProteinRatio(ratio: Float) {
        sharedPref.edit().putFloat(KEY_PROTEIN_RATIO, ratio).apply()
    }

    override fun saveFatRatio(ratio: Float) {
        sharedPref.edit().putFloat(KEY_FAT_RATIO, ratio).apply()
    }

    override fun loadUserInfo(): UserInfo {
        return UserInfo(
            gender = Gender.fromString(sharedPref.getString(GENDER_KEY, "") ?: "male"),
            age = sharedPref.getInt(KEY_AGE, 2),
            weight = sharedPref.getFloat(KEY_WEIGHT, 1F),
            height = sharedPref.getInt(KEY_HEIGHT, 3),
            activityLevel = ActivityLevel.fromString(sharedPref.getString(KEY_ACTIVITY_LEVEL, "") ?: "medium"),
            goalType = GoalType.fromString(sharedPref.getString(KEY_GOAL_TYPE, "") ?: "keep_weight"),
            carbRatio = sharedPref.getFloat(KEY_CARB_RATIO, 1F),
            proteinRatio = sharedPref.getFloat(KEY_PROTEIN_RATIO, 1F),
            fatRatio = sharedPref.getFloat(KEY_FAT_RATIO, 1F)
        )
    }
}