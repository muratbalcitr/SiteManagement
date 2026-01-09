package com.balancetech.sitemanagement.ui.watermeter

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class WaterMeterDetailFragmentArgs(
  public val waterMeterId: String,
  public val unitId: String,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("water_meter_id", this.waterMeterId)
    result.putString("unit_id", this.unitId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("water_meter_id", this.waterMeterId)
    result.set("unit_id", this.unitId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): WaterMeterDetailFragmentArgs {
      bundle.setClassLoader(WaterMeterDetailFragmentArgs::class.java.classLoader)
      val __waterMeterId : String?
      if (bundle.containsKey("water_meter_id")) {
        __waterMeterId = bundle.getString("water_meter_id")
        if (__waterMeterId == null) {
          throw IllegalArgumentException("Argument \"water_meter_id\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"water_meter_id\" is missing and does not have an android:defaultValue")
      }
      val __unitId : String?
      if (bundle.containsKey("unit_id")) {
        __unitId = bundle.getString("unit_id")
        if (__unitId == null) {
          throw IllegalArgumentException("Argument \"unit_id\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"unit_id\" is missing and does not have an android:defaultValue")
      }
      return WaterMeterDetailFragmentArgs(__waterMeterId, __unitId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle):
        WaterMeterDetailFragmentArgs {
      val __waterMeterId : String?
      if (savedStateHandle.contains("water_meter_id")) {
        __waterMeterId = savedStateHandle["water_meter_id"]
        if (__waterMeterId == null) {
          throw IllegalArgumentException("Argument \"water_meter_id\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"water_meter_id\" is missing and does not have an android:defaultValue")
      }
      val __unitId : String?
      if (savedStateHandle.contains("unit_id")) {
        __unitId = savedStateHandle["unit_id"]
        if (__unitId == null) {
          throw IllegalArgumentException("Argument \"unit_id\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"unit_id\" is missing and does not have an android:defaultValue")
      }
      return WaterMeterDetailFragmentArgs(__waterMeterId, __unitId)
    }
  }
}
