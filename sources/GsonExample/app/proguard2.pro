##---------------Begin: proguard configuration for Gson  ----------
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature

# For using GSON @Expose annotation
-keepattributes *Annotation*

# Gson specific classes
-keep class sun.misc.Unsafe { *; }
#-keep class com.google.gson.stream.** { *; }

# Application classes that will be serialized/deserialized over Gson
-keep class com.google.gson.examples.android.model.** { *; }

# Prevent proguard from stripping interface information from TypeAdapterFactory,
# JsonSerializer, JsonDeserializer instances (so they can be used in @JsonAdapter)
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

##---------------End: proguard configuration for Gson  ----------

#-keepclassmembers class android.app.Notification {
#    java.lang.String getChannel();
#}

#-dontwarn android.app.Notification
#-dontwarn android.app.Notification$Builder
#-dontwarn android.media.session.MediaController
#-dontwarn android.media.session.MediaController$TransportControls
#-dontwarn android.media.session.MediaSession

#-keepclassmembers class android.app.Notification$Builder {
#    android.app.Notification$Builder setChannel();
#}

#-keepclassmembers class android.media.session.MediaController {
#    int getRepeatMode();
#    boolean isShuffleModeEnabled();
#}

#-keepclassmembers class android.media.session.MediaController$TransportControls {
#    void setRepeatMode(int);
#    void setShuffleModeEnabled(boolean);
#}

#-keepclassmembers class android.media.session.MediaSession {
#    void setRepeatMode(int);
#    void setShuffleModeEnabled(boolean);
#}

#-keep class android.content.pmParceledListSlice { *; }
#-keep class libcore.icu.ICU { *; }
#-keep class android.content.res.ThemedResourceCache { *; }
#-keep class android.graphics.Insets { *; }
#-keep class sun.misc.Unsafe { *; }

#-keepclassmembers class * {
#    *** icon;
#}

#-keepclassmembers class * {
#    *** title;
#}

#-keepclassmembers class * {
#    *** actionIntent;
#}

#-keepclassmembers class * {
#    *** OP_POST_NOTIFICATION;
#}

#-keepclassmembers class * {
#    *** addLikelySubtags(java.util.Locale);
#}
