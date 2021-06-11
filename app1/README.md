# Android Test Orchestrator parameterized tests bug

This Android application module contains a number of parameterized test classes in the [androidTest](src/androidTest/java) folder
which demonstrate how it's not possible to define a [Parameterized.Parameters.name](https://junit.org/junit4/javadoc/4.13/org/junit/runners/Parameterized.Parameters.html#name) pattern
which contains `{0}`, `{1}` etc if any of the parameters in the test is an enum value and if the test is to run with [Android Test Orchestrator](https://developer.android.com/training/testing/junit-runner#using-android-test-orchestrator).

#### Links

* See [here](https://github.com/android/android-test/issues/975) for the issue which has been raised in the [android-test](https://github.com/android/android-test) GitHub repo about this bug.
