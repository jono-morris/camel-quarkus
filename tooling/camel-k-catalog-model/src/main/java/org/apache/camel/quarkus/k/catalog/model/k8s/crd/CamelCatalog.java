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
package org.apache.camel.quarkus.k.catalog.model.k8s.crd;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.camel.quarkus.k.catalog.model.k8s.ObjectMeta;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(builder = CamelCatalog.Builder.class)
@JsonPropertyOrder({ "apiVersion", "kind", "metadata", "spec" })
public interface CamelCatalog {
    @Value.Default
    default String getApiVersion() {
        return "camel.apache.org/v1";
    }

    @Value.Default
    default String getKind() {
        return "CamelCatalog";
    }

    ObjectMeta getMetadata();

    CamelCatalogSpec getSpec();

    class Builder extends ImmutableCamelCatalog.Builder {
    }
}
