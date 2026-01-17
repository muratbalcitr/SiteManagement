package com.balancetech.sitemanagement.ui.dashboard

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.balancetech.sitemanagement.R
import kotlin.Int
import kotlin.String

public class DashboardFragmentDirections private constructor() {
  private data class ActionDashboardFragmentToUserDetailFragment(
    public val userId: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_dashboardFragment_to_userDetailFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("user_id", this.userId)
        return result
      }
  }

  public companion object {
    public fun actionDashboardFragmentToFeesFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_dashboardFragment_to_feesFragment)

    public fun actionDashboardFragmentToWaterMeterFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_dashboardFragment_to_waterMeterFragment)

    public fun actionDashboardFragmentToPaymentsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_dashboardFragment_to_paymentsFragment)

    public fun actionDashboardFragmentToExtraPaymentsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_dashboardFragment_to_extraPaymentsFragment)

    public fun actionDashboardFragmentToUsersFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_dashboardFragment_to_usersFragment)

    public fun actionDashboardFragmentToUserDetailFragment(userId: String): NavDirections =
        ActionDashboardFragmentToUserDetailFragment(userId)

    public fun actionDashboardFragmentToBankTransactionsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_dashboardFragment_to_bankTransactionsFragment)
  }
}
