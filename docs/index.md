dd-vault-catalog-cli
======================

Provides the `vault-catalog` command to interact with `dd-vault-catalog` service via its [REST API]{:target=_blank}.

SYNOPSIS
--------

```bash
vault-catalog add-dataset [ -n <nbn> ] <json-file>
vault-catalog create-skeleton-record -n <nbn> [ -r <ocfl-storage-root> ] \
   -v <ocfl-object-version-number> -b <bag-id> [ -c <creation-timestamp> ]
vault-catalog get-unconfirmed-version-exports [ -l <limit> ] [ -o <offset> ]
vault-catalog set-archived-timestamp -n <nbn> -v <ocfl-object-version-number> \
   -a <archived-timestamp>
```

For more information use:

```bash
vault-catalog --help
```

[REST API]: {{ vault_catalog_api }}

