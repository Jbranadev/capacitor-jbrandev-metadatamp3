import { WebPlugin } from '@capacitor/core';

import type { metadatamp3Plugin } from './definitions';

export class metadatamp3Web extends WebPlugin implements metadatamp3Plugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
