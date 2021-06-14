# SQL naming convention

## Notes
Publish real sql structure is quite counterproductive. First of all, it helps to understand any data related process that can be essential for GDPR, HIPAA or CCPA compliance. On the other hand it is an enormous security risk. That’s why we provide a naming convention that helps to understand the workflow and the sql structure, but it is a little different than a real-life sql database. For example we use “tbl” prefix for tables. It eases the readability of sql commands, but in a practice nobody uses this kind of prefix since everybody knows, we are talking about a table. Similarly, the naming convention of keys and indexes exists to provide better understanding over practical.

## tables

` <tbl prefix><project name><table name> `

1. Each table name begins with the “tbl” prefix.
2. The second part of the table name is the name of the project in CamelCase.
3. Third part is the “real” table name that should be CamelCase.
4. If the table related multiple entries or contents, the name ends with “s” or “es” to show plural.
5. Only letters are allowed.

eg:
tblTestProjectCustomers
tblTestProjectMarkets


## views

` <vw prefix><project name><view name> `

1. Each view name begins with the “vw” prefix.
2. The second part of the view name is the name of the project in CamelCase.
3. Third part is the “real” view name that should be CamelCase.
4. If the view related multiple entries or contents, the name ends with “s” or “es” to show plural.
5. Only letters are allowed.

eg:
vwTestProjectOrderDetails
vwTestProjectShippingDetails


## primary key

` <PK prefix>_<content table>_<key name> `

1. Each key name begins with the “PK” prefix.
2. The second part of the key name is the name of the content table which contains the key.
3. Third part is the key name that should be CamelCase.
4. If the name refers to an id content, the name should be end with uppercase “ID”
5. Only letters are allowed in the names.
6. Separators should be underscores.


## foreign key

` <FK prefix>_<content table>_<source table>_<key name> `

1. Each key name begins with the “FK” prefix.
2. The second part of the key name is the name of the content table which contains the key.
3. The third part of the key name is the name of the source table which contains the primary key or any unique key.
4. Fourth part is the key name that should be CamelCase.
5. If the name refers to an id content, the name should be end with uppercase “ID”
6. Only letters are allowed in the names,
7. Separators should be underscores.


## unique records

` <UX prefix>_<content table>_<key name> `

1. Each key name begins with the “UX” prefix.
2. The second part of the key name is the name of the content table which contains the key.
3. Third part is the key name that should be CamelCase.
4. If the name refers to an id content, the name should be end with uppercase “ID”
5. Only letters are allowed in the names.
6. Separators should be underscores.


## index records

` <IX prefix>_<content table>_<key name> `

1. Each key name begins with the “IX” prefix.
2. The second part of the key name is the name of the content table which contains the key.
3. Third part is the key name that should be CamelCase.
4. If the name refers to an id content, the name should be end with uppercase “ID”
5. Only letters are allowed in the names.
6. Separators should be underscores.
