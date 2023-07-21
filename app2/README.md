# Demonstration of the 'connectedDebugAndroidTest' Gradle task hanging indefinitely

This Android application module demonstrates that the mere presence of version `1.5.5` of the [androidx.fragment:fragment-testing](https://maven.google.com/web/index.html#androidx.fragment:fragment-testing) library as a `debugImplementation` or `implementation` dependency
causes the `connectedDebugAndroidTest` Gradle task to hang indefinitely.

Run the `connectedDebugAndroidTest` Gradle task with the `androidx.fragment:fragment-testing:1.5.5` dependency present in the [build.gradle](build.gradle) file
and you will observe the Gradle task hang indefinitely.
Then run the `connectedDebugAndroidTest` Gradle task with the `androidx.fragment:fragment-testing:1.5.5` dependency removed from the [build.gradle](build.gradle) file
and you will observe the Gradle task run to completion swiftly.

The quick fix is to upgrade the [androidx.fragment:fragment-testing](https://maven.google.com/web/index.html#androidx.fragment:fragment-testing) library to version `1.6.0` or later.
The better fix is to start using the [androidx.fragment:fragment-testing-manifest](https://maven.google.com/web/index.html#androidx.fragment:fragment-testing-manifest) library as described in [this](https://stackoverflow.com/a/75700331/1071320) StackOverflow answer.
