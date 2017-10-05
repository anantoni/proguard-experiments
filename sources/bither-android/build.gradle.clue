apply plugin: 'com.android.library'
apply plugin: 'doop'

buildscript {
    configurations.all {
        //This is required for SNAPSHOT dependencies
        resolutionStrategy.cacheChangingModulesFor 0, 'seconds'
        //This is required for dependencies using the  notation
        resolutionStrategy.cacheDynamicVersionsFor 0, 'seconds'
    }
    repositories {
            mavenLocal()
            mavenCentral()
            maven {
                url "${artifactory_contextUrl}/plast-public"
            }
            maven {
                url "${artifactory_contextUrl}/plast-private"
                credentials {
                    username = artifactory_user
                    password = artifactory_password
                }
            }
        mavenCentral()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:2.3.0'
        classpath ('org.clyze:doop-gradle-plugin:2.0+')
    }
}

project(':bither-android') {
    apply plugin: 'com.android.library'
apply plugin: 'doop'
    // apply plugin: 'android'
}
project(':wheel') {
    apply plugin: 'com.android.library'
apply plugin: 'doop'
}
project(':android-charts') {
    apply plugin: 'com.android.library'
apply plugin: 'doop'
}
project(':bitherj') {
    apply plugin: 'java'
apply plugin: 'doop'
}
subprojects {

    android {
        compileSdkVersion 22
        buildToolsVersion '25.0.0'

        sourceSets {
            main {
                manifest.srcFile 'AndroidManifest.xml'
                java.srcDirs = ['src']
                res.srcDirs = ['res']
                assets.srcDirs = ['assets']
                jniLibs.srcDirs = ['native-libs']
                jni.srcDirs = []
            }

            // Move the build types to build-types/<type>
            // For instance, build-types/debug/java, build-types/debug/AndroidManifest.xml, ...
            // This moves them out of them default location under src/<type>/... which would
            // conflict with src/ being used by the main source set.
            // Adding new build types or product flavors should be accompanied
            // by a similar customization.
            debug.setRoot('build-types/debug')
            release.setRoot('build-types/release')
        }
        packagingOptions {
            exclude 'META-INF/NOTICE.txt'
            exclude 'META-INF/LICENSE.txt'
            exclude 'META-INF/NOTICE'
            exclude 'META-INF/LICENSE'
            exclude 'META-INF/DEPENDENCIES'
            exclude 'org/apache/http/entity/mime/version.properties'
            exclude 'org/apache/http/version.properties'
            exclude 'lib/x86_64/darwin/libscrypt.dylib'
            exclude 'lib/x86_64/freebsd/libscrypt.so'
            exclude 'lib/x86_64/linux/libscrypt.so'
        }
        lintOptions {
            abortOnError false
            disable "ResourceType"
        }
    }
}
