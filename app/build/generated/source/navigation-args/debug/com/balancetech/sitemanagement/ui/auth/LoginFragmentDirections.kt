package com.balancetech.sitemanagement.ui.auth

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.balancetech.sitemanagement.R

public class LoginFragmentDirections private constructor() {
  public companion object {
    public fun actionLoginFragmentToRegisterFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_registerFragment)

    public fun actionLoginFragmentToDashboardFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_dashboardFragment)
  }
}
