import { WebPlugin } from '@capacitor/core';

import type { File, MetaDataMp3, metadatamp3Plugin, PermissionStatus } from './definitions';


export class metadatamp3Web extends WebPlugin implements metadatamp3Plugin {
  
  async requestPermissions(): Promise<PermissionStatus> {
    // TODO
    throw this.unimplemented('Not implemented on web.');
  }

  async checkPermissions(): Promise<PermissionStatus> {
    // TODO
    throw this.unimplemented('Not implemented on web.');
  }

  

  async getMetadata(file:File):Promise<MetaDataMp3>{
    throw this.unimplemented('Not implemented on web.' +file.name);
  }

  
  
  


}
