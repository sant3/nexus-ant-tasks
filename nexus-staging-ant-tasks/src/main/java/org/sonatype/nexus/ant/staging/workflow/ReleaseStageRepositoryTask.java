/**
 * Sonatype Nexus (TM) Open Source Version
 * Copyright (c) 2007-2012 Sonatype, Inc.
 * All rights reserved. Includes the third-party code listed at http://links.sonatype.com/products/nexus/oss/attributions.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License Version 1.0,
 * which accompanies this distribution and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Sonatype Nexus (TM) Professional Version is available from Sonatype, Inc. "Sonatype" and "Sonatype Nexus" are trademarks
 * of Sonatype, Inc. Apache Maven is a trademark of the Apache Software Foundation. M2eclipse is a trademark of the
 * Eclipse Foundation. All other trademarks are the property of their respective owners.
 */
package org.sonatype.nexus.ant.staging.workflow;

import java.util.Arrays;

import org.apache.tools.ant.BuildException;
import org.sonatype.nexus.client.srv.staging.StagingWorkflowV2Service;

/**
 * Releases a single closed Nexus staging repository into a permanent Nexus repository for general consumption.
 * 
 * @author cstamas
 * @since 2.1
 */
public class ReleaseStageRepositoryTask
    extends AbstractStagingActionTask
{
    @Override
    public void doExecute( final StagingWorkflowV2Service stagingWorkflow )
        throws BuildException
    {
        log( "Releasing staging repository with ID=" + Arrays.toString( getStagingRepositoryId() ) );
        stagingWorkflow.releaseStagingRepositories( getDescription(), getStagingRepositoryId() );
    }
}