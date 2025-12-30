package com.balancetech.sitemanagement.ui.users

import android.os.Bundle
import androidx.navigation.NavDirections
import com.balancetech.sitemanagement.R
import kotlin.Int
import kotlin.String

public class UsersFragmentDirections private constructor() {
  private data class ActionUsersFragmentToUserDetailFragment(
    public val userId: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_usersFragment_to_userDetailFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("user_id", this.userId)
        return result
      }
  }

  public companion object {
    public fun actionUsersFragmentToUserDetailFragment(userId: String): NavDirections =
        ActionUsersFragmentToUserDetailFragment(userId)
  }
}
