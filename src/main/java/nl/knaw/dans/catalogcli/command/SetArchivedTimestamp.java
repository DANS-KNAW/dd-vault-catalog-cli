/*
 * Copyright (C) 2022 DANS - Data Archiving and Networked Services (info@dans.knaw.nl)
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
package nl.knaw.dans.catalogcli.command;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import nl.knaw.dans.catalogcli.client.DefaultApi;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.time.OffsetDateTime;
import java.util.concurrent.Callable;

@Command(
    name = "set-archived-timestamp",
    mixinStandardHelpOptions = true,
    description = "Set the archived timestamp for a dataset in the Data Vault Catalog."
)
@RequiredArgsConstructor
public class SetArchivedTimestamp implements Callable<Integer> {
    @NonNull
    private final DefaultApi api;

    @Option(names = { "-n", "--nbn" },
            description = "The NBN of the dataset.",
            required = true)
    private String nbn;

    @Option(names = { "-v", "--ocfl-object-version-number" },
            description = "The OCFL object version number of the dataset.",
            required = true)
    private Integer ocflObjectVersionNumber;

    @Option(names = { "-a", "--archived-timestamp" },
            description = "The archived timestamp to set for the dataset.",
            required = true)
    private OffsetDateTime archivedTimestamp;

    @Override
    public Integer call() {
        try {
            api.setVersionExportArchivedTimestamp(nbn, ocflObjectVersionNumber, archivedTimestamp);
            System.err.println("Set archived timestamp for dataset with NBN " + nbn + " and OCFL object version number " + ocflObjectVersionNumber);
            return 0;
        }
        catch (Exception e) {
            System.err.println("Error setting archived timestamp: " + e.getMessage());
            return 1;
        }
    }
}
