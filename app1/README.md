# Demonstration of an Android Test Orchestrator parameterized tests bug

This Android application module demonstrated a bug in the AndroidX test libraries which is now resolved.

Prior to the bug fix, it was not possible to define a [Parameterized.Parameters.name][1] pattern
in a parameterized test class which contained `{0}`, `{1}` etc if any of the parameters in the test was an enum value
and the test was to run with [Android Test Orchestrator][2].

See the [androidTest][3] folder for some parameterized test classes which demonstrated the problem.

#### Links

* See [Issue #975][4] in the [android-test][5] GitHub repo for a more detailed description of the problem.

[1]: https://junit.org/junit4/javadoc/4.13/org/junit/runners/Parameterized.Parameters.html#name
[2]: https://developer.android.com/training/testing/junit-runner#using-android-test-orchestrator
[3]: src/androidTest/java/androidx/test/experiments/app
[4]: https://github.com/android/android-test/issues/975
[5]: https://github.com/android/android-test
