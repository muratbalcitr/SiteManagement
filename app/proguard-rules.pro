# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile


########Huawei ML-KIT############
#noinspection ShrinkerUnresolvedReference
-ignorewarnings
-keepattributes *Annotation*
-keepattributes Exceptions
-keepattributes InnerClasses
-keepattributes Signature
-keepattributes SourceFile,LineNumberTable


-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable
-keep public class * extends java.lang.Exception

# VM factory/reflection senaryoları için ctor'ları koru
-keepclassmembers class * extends androidx.lifecycle.ViewModel {
    <init>(...);
}

# LiveData ve ViewModel sınıflarını koru
-keep class androidx.lifecycle.** { *; }
-keep class androidx.lifecycle.LiveData { *; }
-keep class androidx.lifecycle.MutableLiveData { *; }
-keep class androidx.lifecycle.ViewModel { *; }
-keep class androidx.lifecycle.ViewModelProvider { *; }
-keep class androidx.lifecycle.ViewModelStore { *; }
-keep class androidx.lifecycle.ViewModelStoreOwner { *; }

# LiveData observer metodlarını koru
-keepclassmembers class * {
    @androidx.lifecycle.Observe <methods>;
}

# Fragment lifecycle metodlarını koru
-keepclassmembers class * extends androidx.fragment.app.Fragment {
    public void onViewCreated(android.view.View, android.os.Bundle);
    public void onResume();
    public void onPause();
    public void onDestroyView();
}

# Hilt/Dagger ViewModel sınıflarını koru
-keep class * extends androidx.lifecycle.ViewModel {
    <init>(...);
}
-keep class * extends dagger.hilt.android.lifecycle.HiltViewModel {
    <init>(...);
}

# Hilt annotation'larını koru
-keep class dagger.hilt.** { *; }
-keep class dagger.hilt.android.** { *; }
-keep class dagger.hilt.android.lifecycle.** { *; }

# @SerializedName alanlarını koru (en sağlıklı yol)
-keepclassmembers class ** {
    @com.google.gson.annotations.SerializedName <fields>;
}

# for debug
-renamesourcefileattribute SourceFile
-keepattributes SourceFile,LineNumberTable

## Square Otto specific rules ##
## https://square.github.io/otto/ ##

-keepattributes *Annotation*
-keepclassmembers class ** {
    @com.squareup.otto.Subscribe public *;
    @com.squareup.otto.Produce public *;
}
