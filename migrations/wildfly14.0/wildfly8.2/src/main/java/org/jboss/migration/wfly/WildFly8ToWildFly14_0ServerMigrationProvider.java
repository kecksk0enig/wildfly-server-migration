/*
 * Copyright 2018 Red Hat, Inc.
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
package org.jboss.migration.wfly;

import org.jboss.migration.wfly10.WildFlyServerMigration10;
import org.jboss.migration.wfly10.config.task.module.MigrateReferencedModules;
import org.jboss.migration.wfly10.config.task.paths.MigrateReferencedPaths;
import org.jboss.migration.wfly10.config.task.subsystem.jacorb.MigrateJacorbSubsystem;
import org.jboss.migration.wfly10.config.task.subsystem.jberet.AddBatchJBeretSubsystem;
import org.jboss.migration.wfly10.config.task.subsystem.messaging.MigrateMessagingSubsystem;
import org.jboss.migration.wfly10.config.task.subsystem.requestcontroller.AddRequestControllerSubsystem;
import org.jboss.migration.wfly10.config.task.subsystem.securitymanager.AddSecurityManagerSubsystem;
import org.jboss.migration.wfly10.config.task.subsystem.singleton.AddSingletonSubsystem;
import org.jboss.migration.wfly10.config.task.update.AddApplicationRealmSSLServerIdentity;
import org.jboss.migration.wfly10.config.task.update.AddJmxSubsystemToHosts;
import org.jboss.migration.wfly10.config.task.update.AddLoadBalancerProfile;
import org.jboss.migration.wfly10.config.task.update.AddPrivateInterface;
import org.jboss.migration.wfly10.config.task.update.AddSocketBindingMulticastAddressExpressions;
import org.jboss.migration.wfly10.config.task.update.MigrateCompatibleSecurityRealms;
import org.jboss.migration.wfly10.config.task.update.MigrateDeployments;
import org.jboss.migration.wfly10.config.task.update.RemovePermgenAttributesFromJVMConfigs;
import org.jboss.migration.wfly10.config.task.update.RemoveUnsecureInterface;
import org.jboss.migration.wfly10.config.task.update.RemoveUnsupportedExtensions;
import org.jboss.migration.wfly10.config.task.update.RemoveUnsupportedSubsystems;
import org.jboss.migration.wfly10.config.task.update.ServerUpdate;
import org.jboss.migration.wfly10.config.task.update.UpdateUnsecureInterface;
import org.jboss.migration.wfly11.task.subsystem.coremanagement.AddCoreManagementSubsystem;
import org.jboss.migration.wfly11.task.subsystem.logging.RemoveConsoleHandlerFromLoggingSubsystem;
import org.jboss.migration.wfly13.task.hostexclude.WildFly13_0AddHostExcludes;
import org.jboss.migration.wfly13.task.subsystem.discovery.AddDiscoverySubsystem;
import org.jboss.migration.wfly13.task.subsystem.eesecurity.AddEESecuritySubsystem;
import org.jboss.migration.wfly13.task.subsystem.elytron.WildFly13_0AddElytronSubsystem;
import org.jboss.migration.wfly8.WildFlyServer8;

/**
 * Server migration to WFLY 14.0, from WFLY 8.
 * @author emmartins
 */
public class WildFly8ToWildFly14_0ServerMigrationProvider implements WildFly14_0ServerMigrationProvider {

    @Override
    public WildFlyServerMigration10 getServerMigration() {
        final ServerUpdate.Builders<WildFlyServer8> serverUpdateBuilders = new ServerUpdate.Builders<>();
        return serverUpdateBuilders.serverUpdateBuilder()
                .standaloneServer(serverUpdateBuilders.standaloneConfigurationBuilder()
                        .subtask(new RemoveUnsupportedExtensions<>())
                        .subtask(new RemoveUnsupportedSubsystems<>())
                        .subtask(new MigrateReferencedModules<>())
                        .subtask(new MigrateReferencedPaths<>())
                        .subtask(new WildFly8ToWildFly14_0UpdateInfinispanSubsystem<>())
                        .subtask(new WildFly8ToWildFly14_0UpdateUndertowSubsystem<>())
                        .subtask(new WildFly8ToWildFly14_0UpdateJGroupsSubsystem<>())
                        .subtask(new MigrateJacorbSubsystem<>())
                        .subtask(new MigrateMessagingSubsystem<>())
                        .subtask(new AddBatchJBeretSubsystem<>())
                        .subtask(new AddCoreManagementSubsystem<>())
                        .subtask(new WildFly13_0AddElytronSubsystem<>())
                        .subtask(new AddRequestControllerSubsystem<>())
                        .subtask(new AddSecurityManagerSubsystem<>())
                        .subtask(new AddSingletonSubsystem<>())
                        .subtask(new AddDiscoverySubsystem<>())
                        .subtask(new AddEESecuritySubsystem<>())
                        .subtask(new AddPrivateInterface<>())
                        .subtask(new AddSocketBindingMulticastAddressExpressions<>())
                        .subtask(new MigrateCompatibleSecurityRealms<>())
                        .subtask(new AddApplicationRealmSSLServerIdentity<>())
                        .subtask(new MigrateDeployments<>()))
                .domain(serverUpdateBuilders.domainBuilder()
                        .domainConfigurations(serverUpdateBuilders.domainConfigurationBuilder()
                                .subtask(new RemoveUnsupportedExtensions<>())
                                .subtask(new RemoveUnsupportedSubsystems<>())
                                .subtask(new MigrateReferencedModules<>())
                                .subtask(new MigrateReferencedPaths<>())
                                .subtask(new WildFly8ToWildFly14_0UpdateInfinispanSubsystem<>())
                                .subtask(new WildFly8ToWildFly14_0UpdateUndertowSubsystem<>())
                                .subtask(new WildFly8ToWildFly14_0UpdateJGroupsSubsystem<>())
                                .subtask(new MigrateJacorbSubsystem<>())
                                .subtask(new MigrateMessagingSubsystem<>())
                                .subtask(new AddBatchJBeretSubsystem<>())
                                .subtask(new AddCoreManagementSubsystem<>())
                                .subtask(new WildFly13_0AddElytronSubsystem<>())
                                .subtask(new AddRequestControllerSubsystem<>())
                                .subtask(new AddSecurityManagerSubsystem<>())
                                .subtask(new AddSingletonSubsystem<>())
                                .subtask(new AddDiscoverySubsystem<>())
                                .subtask(new AddEESecuritySubsystem<>())
                                .subtask(new UpdateUnsecureInterface<>())
                                .subtask(new AddPrivateInterface<>())
                                .subtask(new AddSocketBindingMulticastAddressExpressions<>())
                                .subtask(new RemovePermgenAttributesFromJVMConfigs<>())
                                .subtask(new AddLoadBalancerProfile<>())
                                .subtask(new WildFly13_0AddHostExcludes<>())
                                .subtask(new RemoveConsoleHandlerFromLoggingSubsystem<>())
                                .subtask(new MigrateDeployments<>()))
                        .hostConfigurations(serverUpdateBuilders.hostConfigurationBuilder()
                                .subtask(new MigrateReferencedModules<>())
                                .subtask(new MigrateReferencedPaths<>())
                                .subtask(serverUpdateBuilders.hostBuilder()
                                        .subtask(new AddCoreManagementSubsystem<>())
                                        .subtask(new WildFly13_0AddElytronSubsystem<>())
                                        .subtask(new AddJmxSubsystemToHosts<>())
                                        .subtask(new RemoveUnsecureInterface<>())
                                        .subtask(new RemovePermgenAttributesFromJVMConfigs<>())
                                        .subtask(new MigrateCompatibleSecurityRealms<>())
                                        .subtask(new AddApplicationRealmSSLServerIdentity<>()))))
                .build();
    }

    @Override
    public Class<WildFlyServer8> getSourceType() {
        return WildFlyServer8.class;
    }
}
