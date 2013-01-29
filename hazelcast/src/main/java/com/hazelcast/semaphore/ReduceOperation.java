/*
 * Copyright (c) 2008-2013, Hazelcast, Inc. All Rights Reserved.
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

package com.hazelcast.semaphore;

import com.hazelcast.spi.Operation;

/**
 * @ali 1/22/13
 */
public class ReduceOperation extends SemaphoreBackupAwareOperation {

    public ReduceOperation() {
    }

    public ReduceOperation(String name, int permitCount) {
        super(name, permitCount);
    }

    public void run() throws Exception {
        response = getPermit().reduce(permitCount);
    }

    public boolean shouldBackup() {
        return Boolean.TRUE.equals(response);
    }

    public Operation getBackupOperation() {
        return new ReduceBackupOperation(name, permitCount);
    }
}
