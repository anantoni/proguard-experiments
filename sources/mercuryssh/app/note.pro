-ignorewarnings
-dontnote
-dontobfuscate

-keep class **$$ViewBinder { *;  }

###### Event Bus 3
-keepattributes *Annotation*
-keepclassmembers class ** {
    @org.greenrobot.eventbus.Subscribe <methods>;

}
-keep enum org.greenrobot.eventbus.ThreadMode { *;  }

# Only required if you use AsyncExecutor
-keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent {
    <init>(java.lang.Throwable);

}
###### Event Bus 3 - end

###### Event Bus 2 - begin
    -keepclassmembers class ** {
        public void onEvent*(**);

    }

    # Only required if you use AsyncExecutor
    -keepclassmembers class * extends de.greenrobot.event.util.ThrowableFailureEvent {
        ** *(java.lang.Throwable);

    }
    ###### Event Bus 2 - end

