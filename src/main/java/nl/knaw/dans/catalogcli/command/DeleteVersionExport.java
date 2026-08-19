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
import nl.knaw.dans.catalogcli.client.ApiException;
import nl.knaw.dans.catalogcli.client.DefaultApi;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "delete-version-export",
         mixinStandardHelpOptions = true,
         description = "Deletes a dataset version export. If it is the only version export for the parent dataset, the parent dataset is also deleted.")
@RequiredArgsConstructor
public class DeleteVersionExport implements Callable<Integer> {
    @NonNull
    private final DefaultApi api;

    @Parameters(index = "0", paramLabel = "<urn>", description = "The NBN of the dataset.")
    private String nbn;

    @Parameters(index = "1", paramLabel = "<version>", description = "The OCFL object version number to delete.")
    private Integer version;

    @Option(names = {"-f", "--force"}, description = "Force deletion even if it's not the latest version.")
    private boolean force;

    @Override
    public Integer call() {
        try {
            api.deleteVersionExport(nbn, version, force);
            System.err.println("Successfully deleted version export " + nbn + " " + version);
        }
        catch (ApiException e) {
            System.err.println("Error deleting version export: " + e.getMessage());
            return 1;
        }
        return 0;
    }
}