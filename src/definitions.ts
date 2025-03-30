import type { PluginListenerHandle } from '@capacitor/core';

export enum TemplateEnum {
  List = "List"
}

export interface Template {
  type: TemplateEnum;
}

export interface ListTemplate extends Template {
  title: string;
  items: ListItem[];
}

export interface ListItem {
  actionPayload: any;
  title: string;
}

export interface AndroidAutoPlugin {
  setTemplate(options: { template: ListTemplate }): Promise<void>;
  
  /**
   * Add a listener when an action in android auto is performed.
   * @param eventName
   * @param listenerFunc
   */
  addListener(
    eventName: 'action',
    listenerFunc: (response: { data: any }) => void,
  ): Promise<PluginListenerHandle>;

  /**
   * Removes all listeners.
   */
  removeAllListeners(): Promise<void>;
}
