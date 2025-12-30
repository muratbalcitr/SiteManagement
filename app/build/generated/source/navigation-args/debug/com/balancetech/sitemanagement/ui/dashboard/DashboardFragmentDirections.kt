package com.balancetech.sitemanagement.ui.dashboard

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.balancetech.sitemanagement.R

public class DashboardFragmentDirections private constructor() {
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
  }
}
