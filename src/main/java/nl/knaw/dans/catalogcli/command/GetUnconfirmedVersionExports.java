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

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import nl.knaw.dans.catalogcli.client.DefaultApi;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(name = "get-unconfirmed-version-exports",
         mixinStandardHelpOptions = true,
         description = "Retrieve unconfirmed dataset version exports from the Data Vault Catalog.")
@RequiredArgsConstructor
public class GetUnconfirmedVersionExports implements Callable<Integer> {
    @NonNull
    private final DefaultApi api;

    @NonNull
    private final ObjectMapper objectMapper;

    @Option(names = { "-l", "--limit" },
            description = "The maximum number of unconfirmed dataset version exports to retrieve.", defaultValue = "100")
    private Integer limit;

    @Option(names = { "-o", "--offset" },
            description = "The number of unconfirmed dataset version exports to skip before starting to collect the result set.", defaultValue = "0")
    private Integer offset;

    @Override
    public Integer call() {
        try {
            var dves = api.getUnconfirmedDatasetVersionExports(limit, offset);
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dves);
            System.out.println(json);
            return 0;
        }
        catch (Exception e) {
            System.err.println("Error retrieving unconfirmed dataset version exports: " + e.getMessage());
            return 1;
        }

    }
}
