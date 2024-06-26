/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.quarkus.component.fhir.it;

import ca.uhn.fhir.context.FhirContext;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.apache.camel.quarkus.component.fhir.FhirFlags;

@ApplicationScoped
public class FhirR5RouteBuilder extends AbstractFhirRouteBuilder {

    private static final Boolean ENABLED = new FhirFlags.R5Enabled().getAsBoolean();

    @Inject
    @Named("R5")
    Instance<FhirContext> fhirContextInstance;

    @Override
    String getFhirVersion() {
        return "r5";
    }

    @Override
    FhirContext getFhirContext() {
        return fhirContextInstance.get();
    }

    @Override
    boolean isEnabled() {
        return ENABLED;
    }
}
