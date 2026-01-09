package com.balancetech.sitemanagement.ui.watermeter

import android.os.Bundle
import androidx.navigation.NavDirections
import com.balancetech.sitemanagement.R
import kotlin.Int
import kotlin.String

public class WaterMeterFragmentDirections private constructor() {
  private data class ActionWaterMeterFragmentToWaterMeterDetailFragment(
    public val waterMeterId: String,
    public val unitId: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_waterMeterFragment_to_waterMeterDetailFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("water_meter_id", this.waterMeterId)
        result.putString("unit_id", this.unitId)
        return result
      }
  }

  public companion object {
    public fun actionWaterMeterFragmentToWaterMeterDetailFragment(waterMeterId: String,
        unitId: String): NavDirections =
        ActionWaterMeterFragmentToWaterMeterDetailFragment(waterMeterId, unitId)
  }
}
