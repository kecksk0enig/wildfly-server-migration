/*
 * Copyright 2017 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.migration.wfly10.config.management;

import org.jboss.as.controller.PathAddress;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @author emmartins
 */
public interface ServerGroupResource extends ManageableResource, JvmResource.Parent {

    Type<ServerGroupResource> RESOURCE_TYPE = new Type<>(ServerGroupResource.class, JvmResource.RESOURCE_TYPE);

    @Override
    default Type<ServerGroupResource> getResourceType() {
        return RESOURCE_TYPE;
    }

    /**
     * A facade (with full defaults) for a {@link ManageableResource} which has {@link ServerGroupResource} children.
     */
    interface Parent extends ManageableResource {
        default ServerGroupResource getServerGroupResource(String resourceName) throws IOException {
            return getChildResource(RESOURCE_TYPE, resourceName);
        }
        default List<ServerGroupResource> getServerGroupResources() throws IOException {
            return getChildResources(RESOURCE_TYPE);
        }
        default Set<String> getServerGroupResourceNames() throws IOException {
            return getChildResourceNames(RESOURCE_TYPE);
        }
        default PathAddress getServerGroupResourcePathAddress(String resourceName) {
            return getChildResourcePathAddress(RESOURCE_TYPE, resourceName);
        }
        default String getServerGroupResourceAbsoluteName(String resourceName) {
            return getChildResourcePathAddress(RESOURCE_TYPE, resourceName).toCLIStyleString();
        }
        default void removeServerGroupResource(String resourceName) throws IOException {
            removeResource(RESOURCE_TYPE, resourceName);
        }
    }
}