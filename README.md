[![npm version](https://badge.fury.io/js/capacitor-android-auto.svg)](https://badge.fury.io/js/capacitor-android-auto)
[![capacitor support](https://img.shields.io/badge/capacitor%20support-v7-brightgreen?logo=capacitor)](https://capacitorjs.com/)

# capacitor-android-auto

This plugin adds an Android Auto integration.

## Supported platforms

| Platform | Supported |
| -------- | --------: |
| Android  |         ✔ |
| iOS      |         ✖ |
| Web      |         ✖ |

## Install

```bash
npm install capacitor-android-auto
npx cap sync android
```

Add this to the activity inside your AndroidManifest.xml:

```
android:showWhenLocked="true"
android:turnScreenOn="true"
```

## Usage

```javascript
import { AndroidAuto } from 'capacitor-android-auto';

...

AndroidAuto.setTemplate({
    template: {
        type: TemplateEnum.List,
        title: 'My Features',
        items: [{ title: 'Feature 1', actionPayload: 'feature-1' }]
    }
});

// Triggered when an android auto list entry was clicked
AndroidAuto.addListener('action', (response: any) => {
    // response.data contains the actionPayload
});
```

## API

<docgen-index>

* [`setTemplate(...)`](#settemplate)
* [`addListener('action', ...)`](#addlisteneraction-)
* [`removeAllListeners()`](#removealllisteners)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### setTemplate(...)

```typescript
setTemplate(options: { template: ListTemplate; }) => Promise<void>
```

| Param         | Type                                                                 |
| ------------- | -------------------------------------------------------------------- |
| **`options`** | <code>{ template: <a href="#listtemplate">ListTemplate</a>; }</code> |

--------------------


### addListener('action', ...)

```typescript
addListener(eventName: 'action', listenerFunc: (response: { data: any; }) => void) => Promise<PluginListenerHandle>
```

Add a listener when an action in android auto is performed.

| Param              | Type                                               |
| ------------------ | -------------------------------------------------- |
| **`eventName`**    | <code>'action'</code>                              |
| **`listenerFunc`** | <code>(response: { data: any; }) =&gt; void</code> |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt;</code>

--------------------


### removeAllListeners()

```typescript
removeAllListeners() => Promise<void>
```

Removes all listeners.

--------------------


### Interfaces


#### ListTemplate

| Prop        | Type                    |
| ----------- | ----------------------- |
| **`title`** | <code>string</code>     |
| **`items`** | <code>ListItem[]</code> |


#### ListItem

| Prop                | Type                |
| ------------------- | ------------------- |
| **`actionPayload`** | <code>any</code>    |
| **`title`**         | <code>string</code> |


#### PluginListenerHandle

| Prop         | Type                                      |
| ------------ | ----------------------------------------- |
| **`remove`** | <code>() =&gt; Promise&lt;void&gt;</code> |

</docgen-api>