# Demonstration of the 'ActivityScenario.launchActivityForResult' method not working in Android 14

This Android application module demonstrates that the [ActivityScenario.launchActivityForResult](https://developer.android.com/reference/androidx/test/core/app/ActivityScenario#launchActivityForResult(java.lang.Class%3CA%3E)) method
is unable to launch an activity if the application's `targetSdk` is set to API Level 34 (i.e. Android 14)
and the test is run on an Android 14 device.

Run the tests defined in the [MainActivityTest](src/androidTest/java/androidx/test/experiments/app/MainActivityTest.kt) class on an Android 13 or older device.
You will observe the tests all run to completion successfully.
Then run the tests on an Android 14 device.
You will observe that the tests which use the [ActivityScenario.launch](https://developer.android.com/reference/androidx/test/core/app/ActivityScenario#launch(java.lang.Class%3CA%3E)) method succeed
whilst the tests which use the [ActivityScenario.launchActivityForResult](https://developer.android.com/reference/androidx/test/core/app/ActivityScenario#launchActivityForResult(java.lang.Class%3CA%3E)) method fail.

I've raised an issue about this in the [android-test](https://github.com/android/android-test) GitHub repo. See [Issue #1871](https://github.com/android/android-test/issues/1871).

## Update

See [this comment](https://github.com/android/android-test/issues/1871#issuecomment-1961510934) in the issue that I raised in the [android-test](https://github.com/android/android-test) GitHub repo for the fix.
