/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.presto.spi;

import java.util.List;

public interface ConnectorSplitManager
{
    /**
     * Gets the Partitions for the specified table.
     *
     * The TupleDomain indicates the execution filters that will be directly applied to the
     * data stream produced by this connector. Connectors are encouraged to take advantage of
     * this information to perform connector-specific optimizations.
     */
    ConnectorPartitionResult getPartitions(ConnectorTableHandle table, TupleDomain<ConnectorColumnHandle> tupleDomain);

    /**
     * Gets the Splits for the specified Partitions in the indicated table.
     */
    ConnectorSplitSource getPartitionSplits(ConnectorTableHandle table, List<ConnectorPartition> partitions);
}
