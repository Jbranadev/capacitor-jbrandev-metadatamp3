import { registerPlugin } from '@capacitor/core';

import type { metadatamp3Plugin } from './definitions';

const metadatamp3 = registerPlugin<metadatamp3Plugin>('metadatamp3', {
  web: () => import('./web').then(m => new m.metadatamp3Web()),
});

export * from './definitions';
export { metadatamp3 };
