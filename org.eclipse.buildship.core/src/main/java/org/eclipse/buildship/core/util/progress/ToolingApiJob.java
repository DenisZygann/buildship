/*
 * Copyright (c) 2015 the original author or authors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Etienne Studer & Donát Csikós (Gradle Inc.) - initial API and implementation and initial documentation
 */

package org.eclipse.buildship.core.util.progress;

import org.gradle.tooling.CancellationToken;
import org.gradle.tooling.CancellationTokenSource;
import org.gradle.tooling.GradleConnector;

import org.eclipse.core.runtime.jobs.Job;

/**
 * Base class for cancellable jobs that invoke the Gradle Tooling API.
 */
public abstract class ToolingApiJob extends Job {

    private final CancellationTokenSource tokenSource;

    /**
     * Creates a new job with the specified name. The job name is a human-readable value that is
     * displayed to users. The name does not need to be unique, but it must not be {@code null}. A
     * token for Gradle build cancellation is created.
     *
     * @param name the name of the job
     */
    protected ToolingApiJob(String name) {
        super(name);
        this.tokenSource = GradleConnector.newCancellationTokenSource();
    }

    protected CancellationToken getToken() {
        return this.tokenSource.token();
    }

    @Override
    protected void canceling() {
        this.tokenSource.cancel();
    }

}
