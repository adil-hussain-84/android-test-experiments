# Demonstration of the 'connectedDebugAndroidTest' Gradle task hanging indefinitely

This Android application module demonstrates that the mere presence of the `androidx.fragment:fragment-testing` library as a `debugImplementation` dependency
causes the `connectedDebugAndroidTest` Gradle task to hang indefinitely.

Run the `connectedDebugAndroidTest` Gradle task with the `androidx.fragment:fragment-testing` dependency present in the [build.gradle](build.gradle) file
and you will observe the Gradle task hang indefinitely.
Then run the `connectedDebugAndroidTest` Gradle task with the `androidx.fragment:fragment-testing` dependency removed from the [build.gradle](build.gradle) file
and you will observe the Gradle task run to completion swiftly.

I have observed this behaviour in the following environments:

1. Android Studio Electric Eel (2022.1.1 Patch 2) running on macOS Ventura 13.1.
2. Android Studio Electric Dolphin (2021.3.1 Patch 1) running on macOS Ventura 13.1.

