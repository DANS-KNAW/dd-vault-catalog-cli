Installation
============

Currently this project is built as an RPM package for RHEL7/CentOS7 and later. The RPM will install the binaries to
`/opt/dans.knaw.nl/dd-vault-catalog-cli` and the configuration files to `/etc/opt/dans.knaw.nl/dd-vault-catalog-cli`.

Building from source
--------------------

Prerequisites:

* Java 11 or higher
* Maven 3.3.3 or higher
* RPM

Steps:

```bash
git clone https://github.com/DANS-KNAW/dd-vault-catalog-cli.git
cd dd-vault-catalog-cli 
mvn clean install
```
