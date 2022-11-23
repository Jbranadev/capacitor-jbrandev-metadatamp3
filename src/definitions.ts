import type { PermissionState } from "@capacitor/core";

export interface metadatamp3Plugin {
  echo(options: { value: string }): Promise<{ value: string }>;

  getMetadata(file:File):Promise<MetaDataMp3>;

  checkPermissions(): Promise<PermissionStatus>;

  requestPermissions(): Promise<PermissionStatus>;

}

export interface File{
  name?:string;
  uri:string;
}

export interface MetaDataMp3{
  data:MetaData[];
}

export interface MetaData{
  name:string;
  value:any;
}

export interface PermissionStatus {
  // TODO: change 'location' to the actual name of your alias!
  location: PermissionState;
}