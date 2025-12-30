package com.balancetech.sitemanagement.ui.users

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class UserDetailFragmentArgs(
  public val userId: String,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("user_id", this.userId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("user_id", this.userId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): UserDetailFragmentArgs {
      bundle.setClassLoader(UserDetailFragmentArgs::class.java.classLoader)
      val __userId : String?
      if (bundle.containsKey("user_id")) {
        __userId = bundle.getString("user_id")
        if (__userId == null) {
          throw IllegalArgumentException("Argument \"user_id\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"user_id\" is missing and does not have an android:defaultValue")
      }
      return UserDetailFragmentArgs(__userId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): UserDetailFragmentArgs {
      val __userId : String?
      if (savedStateHandle.contains("user_id")) {
        __userId = savedStateHandle["user_id"]
        if (__userId == null) {
          throw IllegalArgumentException("Argument \"user_id\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"user_id\" is missing and does not have an android:defaultValue")
      }
      return UserDetailFragmentArgs(__userId)
    }
  }
}
