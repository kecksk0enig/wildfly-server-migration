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

package org.jboss.migration.wfly10.config.task.factory;

import org.jboss.migration.core.ServerMigrationTask;
import org.jboss.migration.core.ServerMigrationTaskName;
import org.jboss.migration.wfly10.config.management.DeploymentsManagement;
import org.jboss.migration.wfly10.config.task.executor.DeploymentsManagementSubtaskExecutor;

/**
 * @author emmartins
 */
public class DeploymentsManagementTask<S> extends ResourceManagementTask<S, DeploymentsManagement> {

    protected DeploymentsManagementTask(Builder<S> builder, S source, DeploymentsManagement... resourceManagements) {
        super(builder, source, resourceManagements);
    }

    public static class Builder<S> extends ResourceManagementTask.BaseBuilder<S, DeploymentsManagement, DeploymentsManagementSubtaskExecutor<S>, Builder<S>> {

        public Builder(ServerMigrationTaskName taskName) {
            super(taskName);
        }

        @Override
        public ServerMigrationTask build(S source, DeploymentsManagement... resourceManagements) {
            return new DeploymentsManagementTask<>(this, source, resourceManagements);
        }
    }


}