vault-catalog
=============
Command line tool to interact with the `dd-vault-catalog` service.

SYNOPSIS
--------

```shell
vaul-catalog [OPTIONS] COMMAND [ARGS]...
```

DESCRIPTION
-----------
This package provides the `vault-catalog` command, to interact with the `dd-vault-catalog` service via its [REST API]{:target=_blank}.

[REST API]: https://dans-knaw.github.io/dd-vault-catalog/swagger-ui/

INSTALLATION AND CONFIGURATION
------------------------------
Currently, this project is built as an RPM package for RHEL8 compatible OSes and later. The RPM will install the binaries to
`/opt/dans.knaw.nl/dd-vault-catalog-cli` and the configuration files to `/etc/opt/dans.knaw.nl/dd-vault-catalog-cli`. The configuration options are documented by
comments in the default configuration file `config.yml`.

BUILDING FROM SOURCE
--------------------
Prerequisites:

* Java 17 or higher
* Maven 3.6.3 or higher
* RPM

Steps:

```shell 
git clone https://github.com/DANS-KNAW/dd-vault-catalog-cli.git
cd dd-vault-catalog-cli
mvn clean install
```

