# capacitor-jbrandev-metadatamp3

Obtiene la metadata de los archivos mp3

## Install

```bash
npm install capacitor-jbrandev-metadatamp3
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`getMetadata(...)`](#getmetadata)
* [`checkPermissions()`](#checkpermissions)
* [`requestPermissions()`](#requestpermissions)
* [Interfaces](#interfaces)
* [Type Aliases](#type-aliases)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### getMetadata(...)

```typescript
getMetadata(file: File) => Promise<MetaDataMp3>
```

| Param      | Type                                  |
| ---------- | ------------------------------------- |
| **`file`** | <code><a href="#file">File</a></code> |

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

| Prop       | Type                    |
| ---------- | ----------------------- |
| **`data`** | <code>MetaData[]</code> |


#### MetaData

| Prop        | Type                |
| ----------- | ------------------- |
| **`name`**  | <code>string</code> |
| **`value`** | <code>any</code>    |


#### File

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
