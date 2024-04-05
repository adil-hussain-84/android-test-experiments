import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

plugins {
    id("com.android.application") version "8.3.1" apply false
    id("com.github.ben-manes.versions") version "0.51.0"
    id("org.jetbrains.kotlin.android") version "1.9.23" apply false
}

tasks.wrapper {
    gradleVersion = "8.7"
}

// Alter the default behaviour of the "com.github.ben-manes.versions" plugin
tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf { isNonStable(candidate.version) }
}

/**
 * @param version The version name to evaluate.
 * @return true if and only if the given version name represents a non-stable version.
 */
fun isNonStable(version: String): Boolean {
    val versionInLowercase = version.lowercase()

    return setOf("alpha", "beta", "rc").any { versionInLowercase.contains(it) }
}
