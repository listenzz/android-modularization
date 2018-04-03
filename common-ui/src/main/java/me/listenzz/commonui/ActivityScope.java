package me.listenzz.commonui;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * A scoping annotation to permit dependencies conform to the life of the ConfigPersistentComponent
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}

