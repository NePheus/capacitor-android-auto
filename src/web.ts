import { WebPlugin } from '@capacitor/core';

import type { AndroidAutoPlugin, Template } from './definitions';

export class AndroidAutoWeb extends WebPlugin implements AndroidAutoPlugin {
  async setTemplate(options: { template: Template }): Promise<void> {
    console.error("Method not implemented.", JSON.stringify(options));
    throw new Error('Method not implemented.');
  }
}
