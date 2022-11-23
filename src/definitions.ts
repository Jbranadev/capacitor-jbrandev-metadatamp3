export interface metadatamp3Plugin {
  echo(options: { value: string }): Promise<{ value: string }>;


  getMetadata(file:File):Promise<MetaDataMp3>;



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
