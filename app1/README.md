# Demonstration of an Android Test Orchestrator parameterized tests bug

This Android application module demonstrated a bug in the AndroidX test libraries which is now resolved.

Prior to the bug fix, it was not possible to define a [Parameterized.Parameters.name](https://junit.org/junit4/javadoc/4.13/org/junit/runners/Parameterized.Parameters.html#name) pattern
in a parameterized test class which contained `{0}`, `{1}` etc if any of the parameters in the test was an enum value
and the test was to run with [Android Test Orchestrator](https://developer.android.com/training/testing/junit-runner#using-android-test-orchestrator).

See the [androidTest](src/androidTest/java/androidx/test/experiments/app) folder for some parameterized test classes which demonstrated the problem.

#### Links

* See [Issue #975](https://github.com/android/android-test/issues/975) in the [android-test](https://github.com/android/android-test) GitHub repo for a more detailed description of the problem.
