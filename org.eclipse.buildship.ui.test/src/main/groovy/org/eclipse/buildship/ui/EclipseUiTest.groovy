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

package org.eclipse.buildship.ui

import org.eclipse.swt.widgets.Display;

import spock.lang.Specification;

class EclipseUiTest extends Specification {

    def "Ui tests can run as Spock tests"() {
        expect:
        Display.getDefault() != null
    }
}
