# capacitor-jbrandev-metadatamp3

Obtiene la metadata de los archivos mp3

## Install

```bash
npm install capacitor-jbrandev-metadatamp3
npx cap sync
```

## API

<docgen-index>

* [`getMetadata(...)`](#getmetadata)
* [`checkPermissions()`](#checkpermissions)
* [`requestPermissions()`](#requestpermissions)
* [Interfaces](#interfaces)
* [Type Aliases](#type-aliases)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### getMetadata(...)

```typescript
getMetadata(file: File) => Promise<MetaDataMp3>
```

Retorna la meta data del archivo proporcionado

| Param      | Type                                  | Description                                                            |
| ---------- | ------------------------------------- | ---------------------------------------------------------------------- |
| **`file`** | <code><a href="#file">File</a></code> | - Representación del archivo de audio del cual se obtendra la metadata |

**Returns:** <code>Promise&lt;<a href="#metadatamp3">MetaDataMp3</a>&gt;</code>

--------------------


### checkPermissions()

```typescript
checkPermissions() => Promise<PermissionStatus>
```

**Returns:** <code>Promise&lt;<a href="#permissionstatus">PermissionStatus</a>&gt;</code>

--------------------


### requestPermissions()

```typescript
requestPermissions() => Promise<PermissionStatus>
```

**Returns:** <code>Promise&lt;<a href="#permissionstatus">PermissionStatus</a>&gt;</code>

--------------------


### Interfaces


#### MetaDataMp3

Definicion de <a href="#metadatamp3">MetaDataMp3</a> Representa toda la meta data obtenida del archivo por medio del pluggin

| Prop       | Type                    |
| ---------- | ----------------------- |
| **`data`** | <code>MetaData[]</code> |


#### MetaData

Definicion de <a href="#metadata">MetaData</a> Representa cada uno de los metadatos que se pueden obtener del pluggin

| Prop        | Type                |
| ----------- | ------------------- |
| **`name`**  | <code>string</code> |
| **`value`** | <code>string</code> |


#### File

Definicion de <a href="#file">File</a>, Representa el file del cual se quiere obtener la metadata

| Prop       | Type                |
| ---------- | ------------------- |
| **`name`** | <code>string</code> |
| **`uri`**  | <code>string</code> |


#### PermissionStatus

| Prop           | Type                                                        |
| -------------- | ----------------------------------------------------------- |
| **`location`** | <code><a href="#permissionstate">PermissionState</a></code> |


### Type Aliases


#### PermissionState

<code>'prompt' | 'prompt-with-rationale' | 'granted' | 'denied'</code>

</docgen-api>
